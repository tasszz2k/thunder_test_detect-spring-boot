package com.thundertestdetect.service.base;

import com.thundertestdetect.dto.RawDataDTO;

public interface IRawDataService {
    String getRaw(RawDataDTO rawData);
    String getRequest(RawDataDTO rawData);
}
