package com.thundertestdetect.entity;

import org.springframework.data.annotation.CreatedDate;
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
    private Long time;

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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
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


}
