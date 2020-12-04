package com.service.impl;

import com.dao.AppInfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.AppInfo;
import com.pojo.AppVersion;
import com.service.AppInfoService;
import com.service.AppVersionService;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Autowired
    private AppVersionService appVersionService;

    public int add(AppInfo appInfo) {
        return appInfoMapper.add(appInfo);
    }

    public int modify(AppInfo appInfo) {
        return appInfoMapper.modify(appInfo);
    }

    public int deleteAppInfoById(Integer delId) {
        return appInfoMapper.deleteAppInfoById(delId);
    }

    public List<AppInfo> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId) {

        return appInfoMapper.getAppInfoList(querySoftwareName,queryStatus,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,queryFlatformId,devId);
    }

    public PageInfo<AppInfo> getListByPage(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId, int currentPageNo, int pageSize) {
        //开启分页支持
        PageHelper.startPage(currentPageNo,pageSize);
        //调用dao层查询所有
        List<AppInfo> list = appInfoMapper.getAppInfoList(querySoftwareName,queryStatus,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,queryFlatformId,devId);
        //获取分页的相关信息
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public int getAppInfoCount(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId) {
        return 0;
    }

    public AppInfo getAppInfo(Integer id, String APKName) {
        return appInfoMapper.getAppInfo(id,APKName);
    }

    public int deleteAppLogo(Integer id) {
        return 0;
    }

    public int updateVersionId(Integer versionId, Integer appId) {
        return appInfoMapper.updateVersionId(versionId,appId);
    }

    public int updateSaleStatusByAppId(Integer appId) {
        return 0;
    }

    public int updateSatus(Integer status, Integer id) {
        return 0;
    }

    public boolean appsysUpdateSaleStatusByAppId(AppInfo appInfo) throws Exception {
        Integer operator = appInfo.getModifyBy();
        if(operator < 0 || appInfo.getId() < 0){
            throw new RuntimeException("用户id有误,无法进行修改");
        }
        AppInfo app = appInfoMapper.getAppInfo(appInfo.getId(), null);
        if(null == app){
            return false;
        }else{
            switch(app.getStatus()){
                case 2://当状态为审核通过时，可以进行上架操作
                    onSale(app,operator,4,2);
                    break;
                case 5://当状态为下架时，可以进行上架操作
                    onSale(app,operator,4,2);
                    break;
                case 4://当状态为上架时，可以进行下架操作
                    offSale(app,operator,5);
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private void onSale(AppInfo app, Integer operator,
                        int appInfoStatus, int appVersionStatus) throws Exception{
        //修改app_info的状态,修改时间 上架以及下架时间
        offSale(app,operator,appInfoStatus);
        //修改app_version的版本状态 以及发布状态id,修改者以及修改时间
        setSaleSwitchToAppVersion(app,operator,appVersionStatus);

    }

    private boolean setSaleSwitchToAppVersion(AppInfo app, Integer operator,
                                              int appVersionStatus) throws Exception{
        AppVersion appVersion = new AppVersion();
        appVersion.setId(app.getVersionId());
        appVersion.setPublishStatus(appVersionStatus);
        appVersion.setModifyBy(operator);
        appVersion.setModifyDate(new Date(System.currentTimeMillis()));
        appVersionService.modify(appVersion);
        return true;
    }

    private boolean offSale(AppInfo app, Integer operator,
                            int appInfoStatus) throws Exception{
        AppInfo a = new AppInfo();
        a.setId(app.getId());
        a.setModifyBy(operator);
        a.setStatus(appInfoStatus);
        a.setOffSaleDate(new Date(System.currentTimeMillis()));

        return appInfoMapper.modify(a)>0?true:false;
    }
}
