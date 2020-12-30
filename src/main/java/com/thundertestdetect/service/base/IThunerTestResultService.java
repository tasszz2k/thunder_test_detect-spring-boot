package com.thundertestdetect.service.base;

import com.thundertestdetect.dto.RawDataDTO;
import com.thundertestdetect.dto.ThunderTestResultDTO;

public interface IThunerTestResultService {
    ThunderTestResultDTO callApi(String request_id, RawDataDTO raw_data);
}
