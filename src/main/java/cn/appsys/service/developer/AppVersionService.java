package cn.appsys.service.developer;

import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.AppVersionInfo;

import java.util.List;

public interface AppVersionService {
    public List<AppVersionInfo> getVersionList(Integer appid) throws Exception;
    public int versionAdd(AppVersion appVersion) throws Exception;
    public AppVersion getVersionId(Integer appid) throws Exception;
    public int delVersion(Integer appId) throws Exception;
    public int updateApk(Integer id) throws Exception;

    public AppVersion getVersionVId(Integer id) throws Exception;
    public int modify(AppVersion appVersion) throws Exception;
}
