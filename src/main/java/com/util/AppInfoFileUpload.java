package com.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public  class AppInfoFileUpload {
    public static boolean fileUpload(MultipartFile attach, HttpServletRequest request, HashMap<String,Object> file){
        String logoPicPath =  null;
        String logoLocPath =  null;
        if(!attach.isEmpty()){
            String path = request.getSession().getServletContext().getRealPath("statics"+ File.separator+"uploadfiles");
//            logger.info("uploadFile path: " + path);
            String oldFileName = attach.getOriginalFilename();//原文件名
            String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀
            int filesize = 50000000;
            if(attach.getSize() > filesize){//上传大小不得超过 50k
                request.setAttribute("fileUploadError", "上传文件过大");
                return false;
            }else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
                    ||prefix.equalsIgnoreCase("jepg") || prefix.equalsIgnoreCase("pneg")){//上传图片格式
                String fileName =UUID.randomUUID() + ".jpg";//上传LOGO图片命名:apk名称.apk
                File targetFile = new File(path,fileName);
                if(!targetFile.exists()){
                    targetFile.mkdirs();
                }
                try {
                    attach.transferTo(targetFile);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    request.setAttribute("fileUploadError", "上传失败");
                    return false;
                }
                logoPicPath = request.getContextPath()+"/statics/uploadfiles/"+fileName;
                logoLocPath = path+File.separator+fileName;
                file.put("logoPicPath",logoPicPath);
                file.put("logoLocPath",logoLocPath);
            }else{
                request.setAttribute("fileUploadError", "上传格式不正确");
                return false;
            }
        }
        return true;
    }
}
