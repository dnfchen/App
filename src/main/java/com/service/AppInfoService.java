package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.AppInfo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoService {

    public int add(AppInfo appInfo) ;

    public int modify(AppInfo appInfo);

    public int deleteAppInfoById(@Param(value = "id") Integer delId);

    public List<AppInfo> getAppInfoList(@Param(value = "softwareName") String querySoftwareName,
                                        @Param(value = "status") Integer queryStatus,
                                        @Param(value = "categoryLevel1") Integer queryCategoryLevel1,
                                        @Param(value = "categoryLevel2") Integer queryCategoryLevel2,
                                        @Param(value = "categoryLevel3") Integer queryCategoryLevel3,
                                        @Param(value = "flatformId") Integer queryFlatformId,
                                        @Param(value = "devId") Integer devId);

    public int getAppInfoCount(@Param(value = "softwareName") String querySoftwareName,
                               @Param(value = "status") Integer queryStatus,
                               @Param(value = "categoryLevel1") Integer queryCategoryLevel1,
                               @Param(value = "categoryLevel2") Integer queryCategoryLevel2,
                               @Param(value = "categoryLevel3") Integer queryCategoryLevel3,
                               @Param(value = "flatformId") Integer queryFlatformId,
                               @Param(value = "devId") Integer devId);

    public AppInfo getAppInfo(@Param(value = "id") Integer id, @Param(value = "APKName") String APKName);

    public int deleteAppLogo(@Param(value = "id") Integer id);

    /**
     * 根据appId，更新最新versionId
     * @param versionId
     * @param appId
     * @return
     * @throws Exception
     */
    public int updateVersionId(@Param(value = "versionId") Integer versionId, @Param(value = "id") Integer appId);

    /**
     * updateSaleStatusByAppId
     * @param appId
     * @return
     * @throws Exception
     */
    public int updateSaleStatusByAppId(@Param(value = "id") Integer appId) ;


    public int updateSatus(@Param(value = "status") Integer status, @Param(value = "id") Integer id);


    public boolean appsysUpdateSaleStatusByAppId(AppInfo appInfo) throws Exception;


    public PageInfo<AppInfo> getListByPage(@Param(value = "softwareName") String querySoftwareName,
                                           @Param(value = "status") Integer queryStatus,
                                           @Param(value = "categoryLevel1") Integer queryCategoryLevel1,
                                           @Param(value = "categoryLevel2") Integer queryCategoryLevel2,
                                           @Param(value = "categoryLevel3") Integer queryCategoryLevel3,
                                           @Param(value = "flatformId") Integer queryFlatformId,
                                           @Param(value = "devId") Integer devId,
                                           int page, int pageSize);

}
