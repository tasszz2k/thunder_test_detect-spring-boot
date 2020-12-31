package com.thundertestdetect.dto;

import java.util.Date;

public class DataResponseDTO {
    private int status_code;
    private String data;
    private Long total_duration;
    private Date send_time;
    private Date response_receive_time;
    private AnalyzerTimeDTO analyzer_time;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getTotal_duration() {
        return total_duration;
    }

    public void setTotal_duration(Long total_duration) {
        this.total_duration = total_duration;
    }

    public Date getSend_time() {
        return send_time;
    }

    public void setSend_time(Date send_time) {
        this.send_time = send_time;
    }

    public Date getResponse_receive_time() {
        return response_receive_time;
    }

    public void setResponse_receive_time(Date response_receive_time) {
        this.response_receive_time = response_receive_time;
    }

    public AnalyzerTimeDTO getAnalyzer_time() {
        return analyzer_time;
    }

    public void setAnalyzer_time(AnalyzerTimeDTO analyzer_time) {
        this.analyzer_time = analyzer_time;
    }
}

