package cn.appsys.service.developer;

import cn.appsys.dao.appversion.AppVersionMapper;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.AppVersionInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Resource
    private AppVersionMapper mapper;

    @Override
    public int modify(AppVersion appVersion) throws Exception {
        return mapper.modify(appVersion);
    }

    @Override
    public AppVersion getVersionVId(Integer id) throws Exception {
        return mapper.getVersionVId(id);
    }

    @Override
    public int updateApk(Integer id) throws Exception {
        return mapper.updateApk(id);
    }

    @Override
    public int versionAdd(AppVersion appVersion) throws Exception {
        return mapper.versionAdd(appVersion);
    }

    @Override
    public int delVersion(Integer appId) throws Exception {
        return mapper.delVersion(appId);
    }

    @Override
    public AppVersion getVersionId(Integer appid) throws Exception {
        return mapper.getVersionId(appid);
    }

    @Override
    public List<AppVersionInfo> getVersionList(Integer appid) throws Exception {
        return mapper.getVersionList(appid);
    }


}
