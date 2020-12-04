package com.controller.developer;


import com.github.pagehelper.PageInfo;
import com.pojo.*;
import com.service.AppCategoryService;
import com.service.AppInfoService;
import com.service.AppVersionService;
import com.service.DataDictionaryService;
import com.util.AppInfoFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/dev/flatform/app")
public class AppInfoController {

    @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private DataDictionaryService dataDictionaryService;

    @Autowired
    private AppCategoryService appCategoryService;

    @Autowired
    private AppVersionService appVersionService;

    /**
     * 列表信息
     */
    @RequestMapping(value = "/list")
    public String getAppInfoList(HttpSession session, Model model,
                                 @RequestParam(value = "querySoftwareName", required = false) String querySoftwareName,
                                 @RequestParam(value = "queryStatus", required = false) Integer queryStatus,
                                 @RequestParam(value = "queryFlatformId", required = false) Integer queryFlatformId,
                                 @RequestParam(value = "queryCategoryLevel1", required = false) Integer queryCategoryLevel1,
                                 @RequestParam(value = "queryCategoryLevel2", required = false) Integer queryCategoryLevel2,
                                 @RequestParam(value = "queryCategoryLevel3", required = false) Integer queryCategoryLevel3,
                                 @RequestParam(value = "pageIndex", required = false) String pageIndex) {


        PageInfo<AppInfo> appInfoList = null;

        List<DataDictionary> statusList = null;

        List<DataDictionary> flatFormList = null;

        List<AppCategory> categoryLevel1List = null;

        List<AppCategory> categoryLevel2List = null;

        List<AppCategory> categoryLevel3List = null;
        //页面显示的数量
        Integer pageSize = 5;
        //设置当前页码
        Integer currentPageNo = 1;
        if (null != pageIndex) {
            currentPageNo = Integer.parseInt(pageIndex);
        }

        //获取devId
        Integer devId = ((DevUser) session.getAttribute("devUserSession")).getId();

        appInfoList = appInfoService.getListByPage(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
        statusList = dataDictionaryService.getDataDictionaryList("APP_STATUS");
        flatFormList = dataDictionaryService.getDataDictionaryList("APP_FLATFORM");
        categoryLevel1List = appCategoryService.getAppCategoryListByParentId(null);

        //进行页面回显
        model.addAttribute("appInfoList", appInfoList);
        model.addAttribute("statusList", statusList);
        model.addAttribute("flatFormList", flatFormList);
        model.addAttribute("querySoftwareName", querySoftwareName);
        model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
        model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
        model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
        model.addAttribute("categoryLevel1List", categoryLevel1List);
        model.addAttribute("queryFlatformId", queryFlatformId);
        model.addAttribute("queryStatus", queryStatus);
        if (null != queryCategoryLevel2) {
            categoryLevel2List = getCategoryList(queryCategoryLevel1);
            model.addAttribute("categoryLevel2List", categoryLevel2List);
        }
        if (null != queryCategoryLevel3) {
            categoryLevel3List = getCategoryList(queryCategoryLevel2);
            model.addAttribute("categoryLevel3List", categoryLevel3List);
        }
        return "developer/appinfolist";
    }


    /**
     * 根据父节点查找分类
     */
    public List<AppCategory> getCategoryList(Integer pid) {

        List<AppCategory> categoryLevelList = appCategoryService.getAppCategoryListByParentId(pid);

        return categoryLevelList;
    }

    /**
     * 异步请求:获取子节点信息
     */
    @RequestMapping("/categorylevellist.json")
    @ResponseBody
    public List<AppCategory> getAppCategoryList(@RequestParam Integer pid) {

        return getCategoryList(pid);
    }


    /**
     * 异步请求:加载平台列表
     */
    @RequestMapping("/datadictionarylist.json")
    @ResponseBody
    public List<DataDictionary> getDictionaryDataList(String code) {

        List<DataDictionary> dataDictionaryList = dataDictionaryService.getDataDictionaryList(code);

        return dataDictionaryList;
    }

    /**
     * 异步请求:验证APKName是否重复
     */
    @RequestMapping("apkexist.json")
    @ResponseBody
    public HashMap<String, String> apkExist(String APKName) {
        HashMap<String, String> result = new HashMap<String, String>();
        if (APKName == null || APKName == "") {
            result.put("APKName", "empty");
        } else {
            AppInfo apk = appInfoService.getAppInfo(null, APKName);
            if (null == apk) {
                result.put("APKName", "noexist");
            } else {
                result.put("APKName", "exist");
            }
        }
        return result;
    }

    /**
     * 跳转到添加页面
     */
    @RequestMapping("/appinfoadd")
    public String appInfoPage(AppInfo appInfo) {
        return "developer/appinfoadd";
    }

    /**
     * 新增App信息
     */
    @RequestMapping("appinfoaddsave")
    public String addAppInfo(AppInfo appInfo, HttpSession session, HttpServletRequest request,
                             @RequestParam(value = "a_logoPicPath", required = false) MultipartFile attach, Model model) {
        HashMap<String, Object> file = new HashMap<String, Object>();
        if (!AppInfoFileUpload.fileUpload(attach, request, file)) {
            model.addAttribute("appinfo", appInfo);
            return "developer/appinfoadd";
        }

        appInfo.setCreatedBy(((DevUser) session.getAttribute("devUserSession")).getId());
        appInfo.setCreationDate(new Date());
        appInfo.setLogoLocPath(file.get("logoLocPath").toString());
        appInfo.setLogoPicPath(file.get("logoPicPath").toString());
        appInfo.setDevId(((DevUser) session.getAttribute("devUserSession")).getId());
        appInfo.setStatus(1);
        if (appInfoService.add(appInfo) == 1) {
            return "redirect:/dev/flatform/app/list";
        }
        return "developer/appinfoadd";
    }

    /**
     * 查看详情
     */
    @RequestMapping("/appview/{appInfoId}")
    public String view(@PathVariable String appInfoId, Model model) {
        Integer id = Integer.parseInt(appInfoId);
        List<AppVersionInfo> versions = new ArrayList<AppVersionInfo>();
        AppInfo appInfo = appInfoService.getAppInfo(id, null);
        versions = appVersionService.getVersionList(Integer.parseInt(appInfoId));

        model.addAttribute("appInfo", appInfo);
        model.addAttribute("appVersionList", versions);
        return "developer/appinfoview";
    }

    /**
     * 异步请求:删除App信息
     */
    @RequestMapping("delapp.json")
    @ResponseBody
    public HashMap<String, Object> delAppInfo(@RequestParam(value = "id", required = false) Integer id) {
        HashMap<String, Object> map = new HashMap<String, Object>();

        if (id == null) {
            map.put("delResult", "notexist");
        } else {
            if (appInfoService.deleteAppInfoById(id) == 1) {
                if (appVersionService.delVersion(id) != -1) {
                    map.put("delResult", "true");
                } else {

                    map.put("delResult", "false");
                }
            }
        }
        return map;
    }

    /**
     * 修改app信息
     */
    @RequestMapping("/appinfomodify")
    public String appInfoModify(@RequestParam("id") String id,
                                @RequestParam(value = "error", required = false) String fileUploadError,
                                Model model) {
        AppInfo appInfo = null;
        //文件上传错误信息提示 回显至页面
        if (null != fileUploadError && "error2".equals(fileUploadError)) {
            fileUploadError = "上传失败";
        } else if (null != fileUploadError && "error3".equals(fileUploadError)) {
            fileUploadError = "上传文件格式不正确";
        } else if (null != fileUploadError && "error4".equals(fileUploadError)) {
            fileUploadError = "上传文件过大";
        }

        appInfo = appInfoService.getAppInfo(Integer.parseInt(id), null);

        model.addAttribute("fileUploadError", fileUploadError);
        model.addAttribute("appInfo", appInfo);
        return "developer/appinfomodify";
    }



    /**
     * 点击新增app版本信息 跳转appVersionadd页面
     */
    @RequestMapping("/appversionadd")
    public String appVersionAdd(@RequestParam("id") String appId, @ModelAttribute("appversion") AppVersion appVersion, Model model) {

        List<AppVersionInfo> versions = new ArrayList<AppVersionInfo>();
        try {
            versions = appVersionService.getVersionList(Integer.parseInt(appId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("appVersionList", versions);
        model.addAttribute("id", appId);
        return "/developer/appversionadd";
    }

    /**
     *信息修改保存
     */
    @RequestMapping(value = "/appinfomodifysave", method = RequestMethod.POST)
    public String modifyAPP(AppInfo appInfo, HttpSession session, HttpServletRequest request,
                            @RequestParam(value = "attach", required = false) MultipartFile attach) {
        HashMap<String, Object> file = new HashMap<String, Object>();
        if (!AppInfoFileUpload.fileUpload(attach, request, file)) {
            request.setAttribute("appinfo", appInfo);
            return "/developer/appinfomodify";
        }
        appInfo.setModifyBy(((DevUser) session.getAttribute("devUserSession")).getId());
        appInfo.setModifyDate(new Date());
        appInfo.setLogoPicPath(file.get("logoPicPath") == null ? null : file.get("logoPicPath").toString());
        appInfo.setLogoLocPath(file.get("logoLocPath") == null ? null : file.get("logoLocPath").toString());

        if (appInfoService.modify(appInfo) == 1) {
            return "redirect:/dev/flatform/app/list";
        }
        return "/developer/appinfomodify";
    }


    /**
     * 上下架
     */
    @RequestMapping(value = "{appid}/sale.json", method = RequestMethod.PUT)
    @ResponseBody
    public Object sale(@PathVariable String appid,HttpSession session){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        Integer appIdInteger = 0;
        try{
            appIdInteger = Integer.parseInt(appid);
        }catch(Exception e){
            appIdInteger = 0;
        }
        resultMap.put("errorCode", "0");
        resultMap.put("appId", appid);
        if(appIdInteger>0){
            try {
                DevUser devUser = (DevUser)session.getAttribute("devUserSession");
                AppInfo appInfo = new AppInfo();
                appInfo.setId(appIdInteger);
                appInfo.setModifyBy(devUser.getId());
                if(appInfoService.appsysUpdateSaleStatusByAppId(appInfo)){
                    resultMap.put("resultMsg", "success");
                }else{
                    resultMap.put("resultMsg", "success");
                }
            } catch (Exception e) {
                resultMap.put("errorCode", "exception000001");
            }
        }else{

            resultMap.put("errorCode", "param000001");
        }


        return resultMap;
    }


}
