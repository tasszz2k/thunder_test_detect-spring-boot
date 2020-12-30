package com.thundertestdetect.converter;

import com.thundertestdetect.dto.ThunderTestResultDTO;
import com.thundertestdetect.entity.ThunderTestResultEntity;
import org.springframework.stereotype.Component;

@Component
public class ThunderTestResultConverter {
    public ThunderTestResultEntity toEntity(ThunderTestResultDTO dto) {
        ThunderTestResultEntity entity = new ThunderTestResultEntity();
        entity.setRequestId(dto.getRequestId());
        entity.setTime(dto.getTime());
        entity.setCode(dto.getCode());
        entity.setResponse(dto.getResponse());
        entity.setRaw(dto.getRaw());
        entity.setRequest(dto.getRequest());
        entity.setCreated(dto.getCreated());
        return entity;
    }

    public ThunderTestResultDTO toDTO(ThunderTestResultEntity entity) {
        ThunderTestResultDTO dto = new ThunderTestResultDTO();
        dto.setRequestId(entity.getRequestId());
        dto.setTime(entity.getTime());
        dto.setCode(entity.getCode());
        dto.setResponse(entity.getResponse());
        dto.setRaw(entity.getRaw());
        dto.setRequest(entity.getRequest());
        dto.setCreated(entity.getCreated());
        return dto;
    }


}
