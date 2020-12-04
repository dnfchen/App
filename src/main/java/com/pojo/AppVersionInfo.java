package com.pojo;

import java.util.Date;

public class AppVersionInfo {
    private String softwareName;//软件名称
    private String publishStatusName;
    private String versionNo;
    private Double versionSize;
    private Date modifyDate;
    private String apkFileName;

    public AppVersionInfo(String softwareName, String publishStatusName, String versionNo, Double versionSize, Date modifyDate, String apkFileName) {
        this.softwareName = softwareName;
        this.publishStatusName = publishStatusName;
        this.versionNo = versionNo;
        this.versionSize = versionSize;
        this.modifyDate = modifyDate;
        this.apkFileName = apkFileName;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getPublishStatusName() {
        return publishStatusName;
    }

    public void setPublishStatusName(String publishStatus) {
        this.publishStatusName = publishStatus;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public Double getVersionSize() {
        return versionSize;
    }

    public void setVersionSize(Double versionSize) {
        this.versionSize = versionSize;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getApkFileName() {
        return apkFileName;
    }

    public void setApkFileName(String apkFileName) {
        this.apkFileName = apkFileName;
    }

    public AppVersionInfo() {
    }
}
