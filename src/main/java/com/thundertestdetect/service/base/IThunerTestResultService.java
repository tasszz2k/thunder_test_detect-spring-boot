package com.thundertestdetect.service.base;

import com.thundertestdetect.dto.RawDataDTO;

public interface IThunerTestResultService {
    void callApi(String request_id, RawDataDTO raw_data);
}
