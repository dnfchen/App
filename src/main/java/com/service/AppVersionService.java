package com.service;

import com.pojo.AppVersion;
import com.pojo.AppVersionInfo;

import java.util.List;

public interface AppVersionService {
    public List<AppVersionInfo> getVersionList(Integer appid) ;

    public int versionAdd(AppVersion appVersion) ;

    public AppVersion getVersionId(Integer appid) ;

    public int delVersion(Integer appId) ;

    public int updateApk(Integer id) ;
    public AppVersion getVersionVId(Integer id) ;

    public int modify(AppVersion appVersion) ;
}
