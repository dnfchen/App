package com.service.impl;

import com.dao.AppVersionMapper;
import com.github.pagehelper.PageInfo;
import com.pojo.AppInfo;
import com.pojo.AppVersion;
import com.pojo.AppVersionInfo;
import com.service.AppInfoService;
import com.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppVersionServiceImpl implements AppVersionService {

    @Autowired
    private AppVersionMapper appVersionMapper;

    public List<AppVersionInfo> getVersionList(Integer appid) {
        return appVersionMapper.getVersionList(appid);
    }

    public int versionAdd(AppVersion appVersion) {
        return appVersionMapper.versionAdd(appVersion);
    }

    public AppVersion getVersionId(Integer appid) {
        return appVersionMapper.getVersionVId(appid);
    }

    public int delVersion(Integer appId) {
        return appVersionMapper.delVersion(appId);
    }

    public int updateApk(Integer id) {
        return 0;
    }

    public AppVersion getVersionVId(Integer id) {
        return appVersionMapper.getVersionVId(id);
    }

    public int modify(AppVersion appVersion) {
        return appVersionMapper.modify(appVersion);
    }
}
