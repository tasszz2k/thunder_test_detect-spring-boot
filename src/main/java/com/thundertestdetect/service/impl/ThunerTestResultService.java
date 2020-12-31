package com.thundertestdetect.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thundertestdetect.converter.Converter;
import com.thundertestdetect.converter.ThunderTestResultConverter;
import com.thundertestdetect.dto.RawDataDTO;
import com.thundertestdetect.dto.DataResponseDTO;
import com.thundertestdetect.dto.ThunderTestResultDTO;
import com.thundertestdetect.entity.ThunderTestResultEntity;
import com.thundertestdetect.repository.ThunderTestResultRepository;
import com.thundertestdetect.service.base.IRawDataService;
import com.thundertestdetect.service.base.IThunerTestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class ThunerTestResultService implements IThunerTestResultService {

    @Autowired
    private ThunderTestResultRepository thunderTestResultRepository;

    @Autowired
    private ThunderTestResultConverter thunderTestResultConverter;

    @Autowired
    private IRawDataService rawDataService;

    @Override
    public ThunderTestResultDTO callApi(String request_id, RawDataDTO raw_data) {

        ThunderTestResultEntity thunderTestResultEntity = new ThunderTestResultEntity();
        //set value attribute
        thunderTestResultEntity.setRequestId(request_id);
        thunderTestResultEntity.setRaw(rawDataService.getRaw(raw_data));
        thunderTestResultEntity.setRequest(Converter.decodeUTF8(rawDataService.getRequest(raw_data, request_id)));

        //call api --> get data, code response
        DataResponseDTO dataResponse = callNewDetectApi(thunderTestResultEntity.getRequest());
        //count elapsed time
        thunderTestResultEntity.setTotalDuration(dataResponse.getTotal_duration());
        thunderTestResultEntity.setResponse(dataResponse.getData());
        thunderTestResultEntity.setCode(dataResponse.getStatus_code());
        thunderTestResultEntity.setSendTime(dataResponse.getSend_time());
        thunderTestResultEntity.setResponseReceiveTime(dataResponse.getResponse_receive_time());


        thunderTestResultEntity.setReceiveTime(dataResponse.getAnalyzer_time().getReceive_time());
        thunderTestResultEntity.setResponseTime(dataResponse.getAnalyzer_time().getResponse_time());
        thunderTestResultEntity.setElasticTime(dataResponse.getAnalyzer_time().getElastic_time());
        thunderTestResultEntity.setRedisTime(dataResponse.getAnalyzer_time().getRedis_time());
        thunderTestResultEntity.setNormTime(dataResponse.getAnalyzer_time().getNorm_time());
        thunderTestResultEntity.setRescoreTime(dataResponse.getAnalyzer_time().getRescore_time());
        thunderTestResultEntity.setDuration(dataResponse.getAnalyzer_time().getDuration());
        //save to db
        thunderTestResultEntity = thunderTestResultRepository.save(thunderTestResultEntity);
        return thunderTestResultConverter.toDTO(thunderTestResultEntity);
    }

    private DataResponseDTO callNewDetectApi(String sURL) {
        DataResponseDTO dataResponse = new DataResponseDTO();
        Gson gson = new GsonBuilder()
                .setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
        try {
            int statusCode;
            StringBuffer data = new StringBuffer();

            //start time
            //call api --> get data, code response
            URL url = new URL(sURL);
            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            sURL = uri.toASCIIString();

            url = new URL(sURL);
            Long startTime = System.currentTimeMillis();
            Date sendTime = Calendar.getInstance().getTime();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("GET");
            statusCode = httpURLConnection.getResponseCode();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    // ... do something with line
                    data.append(line);
                }
            }
            //count elapsed time
            Long elapsedTime = System.currentTimeMillis() - startTime;
            Date responseReceiveTime = Calendar.getInstance().getTime();
            //Mapping data from json response
            dataResponse = gson.fromJson(data.toString(),DataResponseDTO.class);

            dataResponse.setSend_time(sendTime);
            dataResponse.setResponse_receive_time(responseReceiveTime);
            dataResponse.setData(Converter.decodeUTF8(data.toString()));
            dataResponse.setStatus_code(statusCode);
            dataResponse.setTotal_duration(elapsedTime);
        } catch (IOException | URISyntaxException e) {
            e.getStackTrace();
        }
        System.out.println(Calendar.getInstance().getTime());
        return dataResponse;
    }

}
