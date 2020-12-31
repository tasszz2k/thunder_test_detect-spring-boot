package com.thundertestdetect.dto;

import java.util.Date;

public class ThunderTestResultDTO {

    private String request_id;
    private Long total_duration;
    private int status_code;
    private String response;
    private String raw;
    private String request;
    private Date created;
    private Date send_time;
    private Date receive_time;
    private Date response_time;
    private Date response_receive_time;
    private Double norm_time;
    private Double elastic_time;
    private Double rescore_time;
    private Double redis_time;
    private Double duration;

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public Long getTotal_duration() {
        return total_duration;
    }

    public void setTotal_duration(Long total_duration) {
        this.total_duration = total_duration;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getSend_time() {
        return send_time;
    }

    public void setSend_time(Date send_time) {
        this.send_time = send_time;
    }

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

    public Date getResponse_receive_time() {
        return response_receive_time;
    }

    public void setResponse_receive_time(Date response_receive_time) {
        this.response_receive_time = response_receive_time;
    }

    public Double getNorm_time() {
        return norm_time;
    }

    public void setNorm_time(Double norm_time) {
        this.norm_time = norm_time;
    }

    public Double getElastic_time() {
        return elastic_time;
    }

    public void setElastic_time(Double elastic_time) {
        this.elastic_time = elastic_time;
    }

    public Double getRescore_time() {
        return rescore_time;
    }

    public void setRescore_time(Double rescore_time) {
        this.rescore_time = rescore_time;
    }

    public Double getRedis_time() {
        return redis_time;
    }

    public void setRedis_time(Double redis_time) {
        this.redis_time = redis_time;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }
}
