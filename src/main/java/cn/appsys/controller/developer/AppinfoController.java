package cn.appsys.controller.developer;

import cn.appsys.pojo.*;
import cn.appsys.service.developer.AppCategoryService;
import cn.appsys.service.developer.AppVersionService;
import cn.appsys.service.developer.AppinfoService;
import cn.appsys.service.developer.DataDictionaryService;
import cn.appsys.tools.AppInfoFileUpload;
import cn.appsys.tools.Constants;
import cn.appsys.tools.PageSupport;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/dev/flatform/app")
public class AppinfoController {
    @Resource
    private AppinfoService appinfoService;
    @Resource
    private DataDictionaryService dataDictionaryService;
    @Resource
    private AppCategoryService appCategoryService;
    @Resource
    private AppVersionService appVersionService;
    private Logger logger = Logger.getLogger(AppinfoController.class);

    @RequestMapping("/list")
    public String getAppinfoList(Model model,
                                 HttpSession session,
                                 @RequestParam(value = "querySoftwareName", required = false) String querySoftwareName,
                                 @RequestParam(value = "queryStatus", required = false) String _queryStatus,
                                 @RequestParam(value = "queryCategoryLevel1", required = false) String _queryCategoryLevel1,
                                 @RequestParam(value = "queryCategoryLevel2", required = false) String _queryCategoryLevel2,
                                 @RequestParam(value = "queryCategoryLevel3", required = false) String _queryCategoryLevel3,
                                 @RequestParam(value = "queryFlatformId", required = false) String _queryFlatformId,
                                 @RequestParam(value = "pageIndex", required = false) String pageIndex) {
        logger.info("getAppInfoList -- > querySoftwareName: " + querySoftwareName);
        logger.info("getAppInfoList -- > queryStatus: " + _queryStatus);
        logger.info("getAppInfoList -- > queryCategoryLevel1: " + _queryCategoryLevel1);
        logger.info("getAppInfoList -- > queryCategoryLevel2: " + _queryCategoryLevel2);
        logger.info("getAppInfoList -- > queryCategoryLevel3: " + _queryCategoryLevel3);
        logger.info("getAppInfoList -- > queryFlatformId: " + _queryFlatformId);
        logger.info("getAppInfoList -- > pageIndex: " + pageIndex);

        Integer devId = ((DevUser) (session.getAttribute(Constants.DEV_USER_SESSION))).getId();
        List<AppInfo> appInfoList = null;
        List<DataDictionary> statusList = null;
        List<DataDictionary> flatFormList = null;
        //列出一级分类列表，注：二级和三级分类通过ajax异步获取
        List<AppCategory> categoryLevel1List = null;
        List<AppCategory> categoryLevel2List = null;
        List<AppCategory> categoryLevel3List = null;
        //页面容量
        Integer pageSize = Constants.pageSize;
        //当前页码
        Integer currentPageNo = 1;
        if (pageIndex != null) {
            try {
                currentPageNo = Integer.valueOf(pageIndex);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Integer queryStatus = null;
        if (_queryStatus != null && !("").equals(_queryStatus)) {
            queryStatus = Integer.parseInt(_queryStatus);
        }
        Integer queryCategoryLevel1 = null;
        if (_queryCategoryLevel1 != null && !_queryCategoryLevel1.equals("")) {
            queryCategoryLevel1 = Integer.parseInt(_queryCategoryLevel1);
        }
        Integer queryCategoryLevel2 = null;
        if (_queryCategoryLevel2 != null && !_queryCategoryLevel2.equals("")) {
            queryCategoryLevel2 = Integer.parseInt(_queryCategoryLevel2);
        }
        Integer queryCategoryLevel3 = null;
        if (_queryCategoryLevel3 != null && !_queryCategoryLevel3.equals("")) {
            queryCategoryLevel3 = Integer.parseInt(_queryCategoryLevel3);
        }
        Integer queryFlatformId = null;
        if (_queryFlatformId != null && !_queryFlatformId.equals("")) {
            queryFlatformId = Integer.parseInt(_queryFlatformId);
        }

        //总数量（列表）
        int totalCount = 0;
        try {
            totalCount = appinfoService.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //总页数
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        try {
            appInfoList = appinfoService.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
            statusList = this.getDataDictionaryList("APP_STATUS");
            flatFormList = this.getDataDictionaryList("APP_FLATFORM");
            categoryLevel1List = appCategoryService.getAppCategoryListByParentId(null);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("appInfoList", appInfoList);
        model.addAttribute("statusList", statusList);
        model.addAttribute("flatFormList", flatFormList);
        model.addAttribute("categoryLevel1List", categoryLevel1List);
        model.addAttribute("pages", pages);
        model.addAttribute("queryStatus", queryStatus);
        model.addAttribute("querySoftwareName", querySoftwareName);
        model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
        model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
        model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
        model.addAttribute("queryFlatformId", queryFlatformId);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("currentPageNo", currentPageNo);
        //二级分类列表和三级分类列表---回显
        if (queryCategoryLevel2 != null && !queryCategoryLevel2.equals("")) {
            categoryLevel2List = getCategoryList(queryCategoryLevel1.toString());
            model.addAttribute("categoryLevel2List", categoryLevel2List);
        }
        if (queryCategoryLevel3 != null && !queryCategoryLevel3.equals("")) {
            categoryLevel3List = getCategoryList(queryCategoryLevel2.toString());
            model.addAttribute("categoryLevel3List", categoryLevel3List);
        }
        return "developer/appinfolist";
    }

    public List<DataDictionary> getDataDictionaryList(String typeCode) {
        List<DataDictionary> dataDictionaryList = null;
        try {
            dataDictionaryList = dataDictionaryService.getDataDictionaryList(typeCode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataDictionaryList;
    }

    @RequestMapping(value = "categorylist.json", method = RequestMethod.GET)
    @ResponseBody
    public List<AppCategory> getAppCategoryList(@RequestParam String pid) {
        if (pid.equals("")) {
            pid = null;
        }
        return getCategoryList(pid);
    }


    public List<AppCategory> getCategoryList(String pid) {
        logger.debug("getAppCategoryList pid ============ " + pid);
        List<AppCategory> categoryLevelList = null;
        try {
            categoryLevelList = appCategoryService.getAppCategoryListByParentId(pid == null ? null : Integer.parseInt(pid));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return categoryLevelList;
    }

    @RequestMapping(value = "/datadictionarylist.json", method = RequestMethod.GET)
    @ResponseBody
    public List<DataDictionary> getDataDictionaryListToAdd(String tcode) {
        List<DataDictionary> dataDictionaryList = null;
        try {
            dataDictionaryList = dataDictionaryService.getDataDictionaryList(tcode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataDictionaryList;
    }

    @RequestMapping(value = "categorylevellist.json", method = RequestMethod.GET)
    @ResponseBody
    public List<AppCategory> getCategoryListToAdd(String pid) {
        logger.debug("getAppCategoryList pid ============ " + pid);
        List<AppCategory> categoryLevelList = null;
        try {
            categoryLevelList = appCategoryService.getAppCategoryListByParentId(pid == "" || pid == null ? null : Integer.parseInt(pid));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return categoryLevelList;
    }

    @RequestMapping(value = "apkexist.json", method = RequestMethod.GET)
    @ResponseBody
    public String apkExist(String APKName) {
        HashMap<String, String> result = new HashMap<String, String>();
        if (APKName == null || APKName == "") {
            result.put("APKName", "empty");
        } else {
            AppInfo apk = null;
            try {
                apk = appinfoService.getAppInfo(null, APKName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (apk == null) {
                result.put("APKName", "noexist");
            } else {
                result.put("APKName", "exist");
            }
        }
        return JSONArray.toJSONString(result);
    }

    @RequestMapping(value = "/appinfoadd.html", method = RequestMethod.GET)
    public String appInfoAdd(@ModelAttribute("appInfo") AppInfo appInfo) {
        return "/developer/appinfoadd";
    }

    @RequestMapping(value = "/addAPP", method = RequestMethod.POST)
    public String addAPPInfo(AppInfo appInfo, HttpSession session, HttpServletRequest request,
                             @RequestParam(value = "a_logoPicPath", required = false) MultipartFile attach, Model model) {
        HashMap<String, Object> file = new HashMap<String, Object>();
        if (!AppInfoFileUpload.fileUpload(attach, request, file)) {
            model.addAttribute("appinfo", appInfo);
            return "developer/appinfoadd";
        }
        appInfo.setCreatedBy(((DevUser) session.getAttribute(Constants.DEV_USER_SESSION)).getId());
        appInfo.setCreationDate(new Date());
        appInfo.setLogoLocPath(file.get("logoLocPath").toString());
        appInfo.setLogoPicPath(file.get("logoPicPath").toString());
        appInfo.setDevId(((DevUser) session.getAttribute(Constants.DEV_USER_SESSION)).getId());
        appInfo.setStatus(1);
        try {
            if (appinfoService.add(appInfo) == 1) {
                return "redirect:/dev/flatform/app/list";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "developer/appinfoadd";
    }

    @RequestMapping(value = "/appinfoview/{appInfoId}", method = RequestMethod.GET)
    public String view(@PathVariable String appInfoId, Model model) {
        Integer id = Integer.parseInt(appInfoId);
        List<AppVersionInfo> versions = new ArrayList<AppVersionInfo>();
        AppInfo app = null;
        try {
            app = appinfoService.getAppInfo(id, null);
            versions = appVersionService.getVersionList(Integer.parseInt(appInfoId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("appinfo", app);
        model.addAttribute("version", versions);
        System.out.println(versions);
        return "/developer/appinfoview";
    }

    @RequestMapping(value = "appinfomodify", method = RequestMethod.GET)
    public String appinfomodify(@RequestParam String id, Model model) {
        AppInfo appInfo = null;
        try {
            appInfo = appinfoService.getAppInfo(Integer.parseInt(id), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("&^#*%@&*%@#^&%@#^&@" + appInfo.getStatus());
        model.addAttribute("appinfo", appInfo);
        return "/developer/appinfomodify";
    }

    @RequestMapping(value = "delfile.json", method = RequestMethod.GET)
    @ResponseBody
    public String delPic(@RequestParam(value = "flag", required = false) String flag,
                         @RequestParam(value = "id", required = false) String id) {
        HashMap<String, String> resultMap = new HashMap<String, String>();
        String fileLocPath = null;
        if (flag == null || flag.equals("") ||
                id == null || id.equals("")) {
            resultMap.put("result", "failed");
        } else if (flag.equals("logo")) {
            try {
                fileLocPath = (appinfoService.getAppInfo(Integer.parseInt(id), null)).getLogoLocPath();
                File file = new File(fileLocPath);
                if (file.exists()) {
                    if (file.delete()) {//删除服务器存储的物理文件
                        if (appinfoService.deleteAppLogo(Integer.parseInt(id)) == 1) {//更新表
                            resultMap.put("result", "success");
                        }
                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (flag.equals("apk")) {
            try {
                fileLocPath = (appVersionService.getVersionVId(Integer.parseInt(id))).getApkLocPath();
                File file = new File(fileLocPath);
                if (file.exists()) {
                    if (file.delete()) {
                        if (appVersionService.updateApk(Integer.parseInt(id)) == 1) {
                            resultMap.put("result", "success");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSONArray.toJSONString(resultMap);
    }

    @RequestMapping(value = "/modifyApp", method = RequestMethod.POST)
    public String modifyAPP(AppInfo appInfo, HttpSession session, HttpServletRequest request,
                            @RequestParam(value = "attach", required = false) MultipartFile attach) {
        HashMap<String, Object> file = new HashMap<String, Object>();
        if (!AppInfoFileUpload.fileUpload(attach, request, file)) {
            request.setAttribute("appinfo", appInfo);
            return "/developer/appinfomodify";
        }
        appInfo.setModifyBy(((DevUser) session.getAttribute(Constants.DEV_USER_SESSION)).getId());
        appInfo.setModifyDate(new Date());
        appInfo.setLogoPicPath(file.get("logoPicPath") == null ? null : file.get("logoPicPath").toString());
        appInfo.setLogoLocPath(file.get("logoLocPath") == null ? null : file.get("logoLocPath").toString());
        try {
            if (appinfoService.modify(appInfo) == 1) {
                return "redirect:/dev/flatform/app/list";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/developer/appinfomodify";
    }

    @RequestMapping(value = "/appversionadd.html", method = RequestMethod.GET)
    public String toVersionAdd(@RequestParam("appid") String appid, @ModelAttribute("appversion") AppVersion appVersion, Model model) {
        List<AppVersionInfo> versions = new ArrayList<AppVersionInfo>();
        try {
            versions = appVersionService.getVersionList(Integer.parseInt(appid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("version", versions);
        model.addAttribute("appId", appid);
        return "/developer/appversionadd";
    }

    @RequestMapping(value = "appversionAdd", method = RequestMethod.POST)
    public String appversionAdd(@RequestParam(value = "attach", required = false) MultipartFile attach,
                                HttpServletRequest request,
                                AppVersion appVersion, HttpSession session) {
        String downloadLink = null;
        String apkLocPath = null;
        String apkFileName = null;
        if (!attach.isEmpty()) {
            String path = session.getServletContext().getRealPath("statice" + File.separator + "uploadfiles");
            String oldFileName = attach.getOriginalFilename();//原文件名
            String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀
            if (prefix.equalsIgnoreCase("apk")) {
                String apkName = null;
                try {
                    apkName = appinfoService.getAppInfo(appVersion.getAppId(), null).getAPKName();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (apkName == null || "".equals(apkName)) {
                    return "redirect:/dev/flatform/app/appversionadd.html?appid=" + appVersion.getAppId();
                }
                apkFileName = apkName + "-" + appVersion.getVersionNo() + ".apk";
                File targetFile = new File(path, apkFileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                try {
                    attach.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "redirect:/dev/flatform/app/appversionadd.html?appid=" + appVersion.getAppId();
                }
                downloadLink = request.getContextPath() + "/statics/uploadfiles/" + apkFileName;
                apkLocPath = path + File.separator + apkFileName;
            } else {
                return "redirect:/dev/flatform/app/appversionadd.html?appid=" + appVersion.getAppId();
            }
        }
        appVersion.setCreatedBy((((DevUser) session.getAttribute(Constants.DEV_USER_SESSION)).getId()));
        appVersion.setCreationDate(new Date());
        appVersion.setDownloadLink(downloadLink);
        appVersion.setPublishStatus(3);
        appVersion.setApkFileName(apkFileName);
        appVersion.setApkLocPath(apkLocPath);
        try {
            if (appVersionService.versionAdd(appVersion) == 1) {
                Integer appid = Integer.parseInt(request.getParameter("appId"));
                AppVersion v = appVersionService.getVersionId(appid);
                Integer vId = v.getId();
                if (appinfoService.updateVersionId(vId, appid) != 1) {
                    return "redirect:/dev/flatform/app/appversionadd?id=" + appVersion.getAppId();
                }
                return "redirect:/dev/flatform/app/list";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/dev/flatform/app/appversionadd?id=" + appVersion.getAppId();
    }

    @RequestMapping(value = "delapp.json", method = RequestMethod.GET)
    @ResponseBody
    public String delApp(@RequestParam(value = "id") Integer id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            if (StringUtils.isNullOrEmpty(id.toString())) {
                map.put("delResult", "notexist");
            } else {
                if (appinfoService.deleteAppInfoById(id) == 1) {
                    if (appVersionService.delVersion(id) != -1) {
                        map.put("delResult", "true");
                    } else {
                        map.put("delResult", "false");
                    }
                } else {
                    map.put("delResult", "false");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("delResult", "false");
        }
        return JSONArray.toJSONString(map);
    }

    @RequestMapping(value = "appversionmodify", method = RequestMethod.GET)
    public String toAppinfoVersionmodify(@ModelAttribute("version") AppVersion version, @Param(value = "vid") Integer vid, @Param(value = "aid") Integer aid, Model model) {
        List<AppVersionInfo> ver = null;
        AppVersion appVersion = null;
        try {
            ver = appVersionService.getVersionList(aid);
            appVersion = appVersionService.getVersionId(aid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ver);
        model.addAttribute("appversionList", ver);
        model.addAttribute("version", appVersion);
        model.addAttribute("vid", vid);
        return "/developer/appversionmodify";
    }

    @RequestMapping(value = "appversionToModify", method = RequestMethod.POST)
    public String appversionToAdd(@RequestParam(value = "attach", required = false) MultipartFile attach,
                                  HttpServletRequest request,
                                  AppVersion appVersion, HttpSession session) {
        String downloadLink = null;
        String apkLocPath = null;
        String apkFileName = null;
        if (!attach.isEmpty()) {
            String path = session.getServletContext().getRealPath("statice" + File.separator + "uploadfiles");
            String oldFileName = attach.getOriginalFilename();//原文件名
            String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀
            if (prefix.equalsIgnoreCase("apk")) {
                String apkName = null;
                try {
                    apkName = appinfoService.getAppInfo(appVersion.getAppId(), null).getAPKName();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (apkName == null || "".equals(apkName)) {
                    return "redirect:/dev/flatform/app/appversionadd.html?a`id=" + appVersion.getAppId();
                }
                apkFileName = apkName + "-" + appVersion.getVersionNo() + ".apk";
                File targetFile = new File(path, apkFileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                try {
                    attach.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "redirect:/dev/flatform/app/appversionmodify?aid=" + appVersion.getAppId();
                }
                downloadLink = request.getContextPath() + "/statics/uploadfiles/" + apkFileName;
                apkLocPath = path + File.separator + apkFileName;
            } else {
                return "redirect:/dev/flatform/app/appversionmodify?aid=" + appVersion.getAppId();
            }
        }
        appVersion.setModifyBy((((DevUser) session.getAttribute(Constants.DEV_USER_SESSION)).getId()));
        appVersion.setModifyDate(new Date());
        appVersion.setDownloadLink(downloadLink);
        appVersion.setPublishStatus(3);
        appVersion.setApkFileName(apkFileName);
        appVersion.setApkLocPath(apkLocPath);
        try {
            if (appVersionService.modify(appVersion) == 1) {
                return "redirect:/dev/flatform/app/list";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/dev/flatform/app/appversionmodify?aid=" + appVersion.getAppId();
    }

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
                DevUser devUser = (DevUser)session.getAttribute(Constants.DEV_USER_SESSION);
                AppInfo appInfo = new AppInfo();
                appInfo.setId(appIdInteger);
                appInfo.setModifyBy(devUser.getId());
                if(appinfoService.appsysUpdateSaleStatusByAppId(appInfo)){
                    System.out.println("*&^*&^%");
                    resultMap.put("resultMsg", "success");
                }else{
                    resultMap.put("resultMsg", "success");
                }
            } catch (Exception e) {
                resultMap.put("errorCode", "exception000001");
            }
        }else{
            //errorCode:0为正常
            resultMap.put("errorCode", "param000001");
        }

        /*
         * resultMsg:success/failed
         * errorCode:exception000001
         * appId:appId
         * errorCode:param000001
         */
        return resultMap;
        }
}
