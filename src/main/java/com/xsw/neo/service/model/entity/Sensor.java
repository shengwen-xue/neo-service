package com.xsw.neo.service.model.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Sensor {
    private Long id;

    private String name;

    private String data;

    private String address;

    private BigDecimal sensorValue;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public BigDecimal getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(BigDecimal sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}