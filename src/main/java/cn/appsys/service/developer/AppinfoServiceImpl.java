package cn.appsys.service.developer;

import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.pojo.AppInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AppinfoServiceImpl implements AppinfoService {
   @Resource
   private AppInfoMapper mapper;
    @Override
    public int add(AppInfo appInfo) throws Exception {
        return mapper.add(appInfo);
    }

    @Override
    public int modify(AppInfo appInfo) throws Exception {
        return mapper.modify(appInfo);
    }

    @Override
    public int deleteAppInfoById(Integer delId) throws Exception {
        return mapper.deleteAppInfoById(delId);
    }

    @Override
    public List<AppInfo> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId, Integer currentPageNo, Integer pageSize) throws Exception {
        return mapper.getAppInfoList(querySoftwareName,queryStatus,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,queryFlatformId,devId,(currentPageNo-1)*pageSize,pageSize);
    }

    @Override
    public int getAppInfoCount(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId) throws Exception {
        return mapper.getAppInfoCount(querySoftwareName,queryStatus,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,queryFlatformId,devId);
    }

    @Override
    public AppInfo getAppInfo(Integer id, String APKName) throws Exception {
        return mapper.getAppInfo(id,APKName);
    }

    @Override
    public int deleteAppLogo(Integer id) throws Exception {
        return mapper.deleteAppLogo(id);
    }

    @Override
    public int updateVersionId(Integer versionId, Integer appId) throws Exception {
        return mapper.updateVersionId(versionId,appId);
    }

    @Override
    public int updateSaleStatusByAppId(Integer appId) throws Exception {
        return 0;
    }

    @Override
    public int updateSatus(Integer status, Integer id) throws Exception {
        return 0;
    }
}
