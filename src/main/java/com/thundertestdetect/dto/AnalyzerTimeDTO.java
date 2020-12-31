package com.thundertestdetect.dto;

import java.util.Date;

public class AnalyzerTimeDTO {
    private Date receive_time;
    private Date response_time;
    private Double elastic_time;
    private Double redis_time;
    private Double norm_time;
    private Double rescore_time;
    private Double duration;

    public Date getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(Date receive_time) {
        this.receive_time = receive_time;
    }

    public Date getResponse_time() {
        return response_time;
    }

    public void setResponse_time(Date response_time) {
        this.response_time = response_time;
    }

    public Double getElastic_time() {
        return elastic_time;
    }

    public void setElastic_time(Double elastic_time) {
        this.elastic_time = elastic_time;
    }

    public Double getRedis_time() {
        return redis_time;
    }

    public void setRedis_time(Double redis_time) {
        this.redis_time = redis_time;
    }

    public Double getNorm_time() {
        return norm_time;
    }

    public void setNorm_time(Double norm_time) {
        this.norm_time = norm_time;
    }

    public Double getRescore_time() {
        return rescore_time;
    }

    public void setRescore_time(Double rescore_time) {
        this.rescore_time = rescore_time;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }
}
