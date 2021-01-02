package com.thundertestdetect.converter;

import com.thundertestdetect.dto.ThunderTestResultDTO;
import com.thundertestdetect.entity.ThunderTestResultEntity;
import org.springframework.stereotype.Component;

@Component
public class ThunderTestResultConverter {
    public ThunderTestResultEntity toEntity(ThunderTestResultDTO dto) {
        ThunderTestResultEntity entity = new ThunderTestResultEntity();
        entity.setRequestId(dto.getRequest_id());
        entity.setTotalDuration(dto.getTotal_duration());
        entity.setCode(dto.getStatus_code());
        entity.setResponse(dto.getResponse());
        entity.setRaw(dto.getRaw());
        entity.setRequest(dto.getRequest());
        entity.setCreated(dto.getCreated());
        entity.setSendTime(dto.getSend_time());
        entity.setReceiveTime(dto.getReceive_time());
        entity.setResponseTime(dto.getResponse_time());
        entity.setResponseReceiveTime(dto.getResponse_receive_time());
        entity.setNormTime(dto.getNorm_time());
        entity.setElasticTime(dto.getElastic_time());
        entity.setRescoreTime(dto.getRescore_time());
        entity.setRedisTime(dto.getRedis_time());
        entity.setDuration(dto.getDuration());
        return entity;
    }

    public ThunderTestResultDTO toDTO(ThunderTestResultEntity entity) {
        ThunderTestResultDTO dto = new ThunderTestResultDTO();
        dto.setRequest_id(entity.getRequestId());
        dto.setTotal_duration(entity.getTotalDuration());
        dto.setStatus_code(entity.getCode());
        dto.setResponse(entity.getResponse());
        dto.setRaw(entity.getRaw());
        dto.setRequest(entity.getRequest());
        dto.setCreated(entity.getCreated());
        dto.setSend_time(entity.getSendTime());
        dto.setReceive_time(entity.getReceiveTime());
        dto.setResponse_time(entity.getResponseTime());
        dto.setResponse_receive_time(entity.getResponseReceiveTime());
        dto.setNorm_time(entity.getNormTime());
        dto.setElastic_time(entity.getElasticTime());
        dto.setRescore_time(entity.getRescoreTime());
        dto.setRedis_time(entity.getRedisTime());
        dto.setDuration(entity.getDuration());
        return dto;
    }


}
