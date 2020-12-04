package com.pojo;

import java.util.Date;

public class DevUser {
    private Integer id;
    private String devCode;
    private String devName;
    private String devPassword;
    private String devEmail;
    private String devInfo;
    private String createdBy;
    private Date creationDate;
    private String modifyBy;
    private  Date modifyDate;
    private String devNameType;

    public DevUser() {
    }

    public DevUser(Integer id, String devCode, String devName, String devPassword, String devEmail, String devInfo, String createdBy, Date creationDate, String modifyBy, Date modifyDate, String devNameType) {
        this.id = id;
        this.devCode = devCode;
        this.devName = devName;
        this.devPassword = devPassword;
        this.devEmail = devEmail;
        this.devInfo = devInfo;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.devNameType = devNameType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDevPassword() {
        return devPassword;
    }

    public void setDevPassword(String devPassword) {
        this.devPassword = devPassword;
    }

    public String getDevEmail() {
        return devEmail;
    }

    public void setDevEmail(String devEmail) {
        this.devEmail = devEmail;
    }

    public String getDevInfo() {
        return devInfo;
    }

    public void setDevInfo(String devInfo) {
        this.devInfo = devInfo;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getDevNameType() {
        return devNameType;
    }

    public void setDevNameType(String devNameType) {
        this.devNameType = devNameType;
    }

    @Override
    public String toString() {
        return "DevUser{" +
                "id=" + id +
                ", devCode='" + devCode + '\'' +
                ", devName='" + devName + '\'' +
                ", devPassword='" + devPassword + '\'' +
                ", devEmail='" + devEmail + '\'' +
                ", devInfo='" + devInfo + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate +
                ", devNameType='" + devNameType + '\'' +
                '}';
    }
}
