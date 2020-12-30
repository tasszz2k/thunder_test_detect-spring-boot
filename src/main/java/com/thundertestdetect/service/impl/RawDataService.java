package com.thundertestdetect.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thundertestdetect.dto.RawDataDTO;
import com.thundertestdetect.service.base.IRawDataService;
import org.springframework.stereotype.Service;

@Service
public class RawDataService implements IRawDataService {
    @Override
    /**
     * @Param RawDataDTO
     * Return data type dictionary as String
     */
    public String getRaw(RawDataDTO rawData) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(rawData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public String getRequest(RawDataDTO rawData) {
        String url = "https://address-sorting.ghtk.vn/cart-predict";
        return String.format(url + "?address=%s&hamlet=%s&street=%s&ward=%s&district=%s&province=%s&cart_type=%d",
                rawData.getAddress(), rawData.getHamlet(),rawData.getStreet(),
                rawData.getWard(),rawData.getDistrict(), rawData.getProvince(),
                rawData.getCart_type());
    }
}
