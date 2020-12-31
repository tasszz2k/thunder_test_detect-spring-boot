package com.thundertestdetect.entity;

import javax.persistence.Id;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "thunder_test_result")
public class ThunderTestResultEntity {
    @Id
    private String requestId;

    @Column
    private Long totalDuration;

    @Column
    private int code;

    @Column(columnDefinition = "TEXT")

    private String response;

    @Column(columnDefinition = "TEXT")
    private String raw;

    @Column(columnDefinition = "TEXT")
    private String request;

    @Column
    @LastModifiedDate
    private Date created;

    @Column
    private Date sendTime;

    @Column
    private Date receiveTime;

    @Column
    private Date responseTime;

    @Column
    private Date responseReceiveTime;

    @Column
    private Double normTime;

    @Column
    private Double elasticTime;

    @Column
    private Double rescoreTime;

    @Column
    private Double redisTime;

    @Column
    private Double duration;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Long totalDuration) {
        this.totalDuration = totalDuration;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public Date getResponseReceiveTime() {
        return responseReceiveTime;
    }

    public void setResponseReceiveTime(Date responseReceiveTime) {
        this.responseReceiveTime = responseReceiveTime;
    }

    public Double getNormTime() {
        return normTime;
    }

    public void setNormTime(Double normTime) {
        this.normTime = normTime;
    }

    public Double getElasticTime() {
        return elasticTime;
    }

    public void setElasticTime(Double elasticTime) {
        this.elasticTime = elasticTime;
    }

    public Double getRescoreTime() {
        return rescoreTime;
    }

    public void setRescoreTime(Double rescoreTime) {
        this.rescoreTime = rescoreTime;
    }

    public Double getRedisTime() {
        return redisTime;
    }

    public void setRedisTime(Double redisTime) {
        this.redisTime = redisTime;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }
}
