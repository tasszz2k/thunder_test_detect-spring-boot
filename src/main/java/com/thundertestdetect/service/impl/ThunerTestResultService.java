package com.thundertestdetect.service.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

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
        thunderTestResultEntity.setRequest(rawDataService.getRequest(raw_data));

        //call api --> get data, code response
        DataResponseDTO dataResponse = callNewDetectApi(thunderTestResultEntity.getRequest());
        //count elapsed time
        thunderTestResultEntity.setTime(dataResponse.getTime());
        thunderTestResultEntity.setResponse(dataResponse.getData());
        thunderTestResultEntity.setCode(dataResponse.getStatusCode());
        //save to db
        thunderTestResultEntity = thunderTestResultRepository.save(thunderTestResultEntity);

        return thunderTestResultConverter.toDTO(thunderTestResultEntity);
    }

    private DataResponseDTO callNewDetectApi(String sURL) {
        DataResponseDTO dataResponse = new DataResponseDTO();
        try {
            int statusCode;
            StringBuilder data = new StringBuilder();

            //start time
            //call api --> get data, code response
            URL url = new URL(sURL);
            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            sURL = uri.toASCIIString();

            url = new URL(sURL);
            Long startTime = System.currentTimeMillis();
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

            dataResponse.setData(data.toString());
            dataResponse.setStatusCode(statusCode);
            dataResponse.setTime(elapsedTime);
        } catch (IOException | URISyntaxException e) {
            e.getStackTrace();
        }
        return dataResponse;
    }

}
