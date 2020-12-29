package com.thundertestdetect.service.impl;

import com.thundertestdetect.dto.RawDataDTO;
import com.thundertestdetect.repository.ThunderTestResultRepository;
import com.thundertestdetect.service.base.IThunerTestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThunerTestResultService implements IThunerTestResultService {

    @Autowired
    private ThunderTestResultRepository thunderTestResultRepository;

    @Override
    public void callApi(String request_id, RawDataDTO raw_data) {

    }
}
