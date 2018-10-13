package cn.appsys.tools;

import cn.appsys.pojo.AppInfo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public  class AppInfoFileUpload {
    public static boolean fileUpload(MultipartFile attach, HttpServletRequest request, HashMap<String,Object> file){
        String logoPicPath =  null;
        String logoLocPath =  null;
        if(!attach.isEmpty()){
            String path = request.getSession().getServletContext().getRealPath("statics"+java.io.File.separator+"uploadfiles");
//            logger.info("uploadFile path: " + path);
            String oldFileName = attach.getOriginalFilename();//原文件名
            String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀
            int filesize = 500000;
            if(attach.getSize() > filesize){//上传大小不得超过 50k
                request.setAttribute("fileUploadError", Constants.FILEUPLOAD_ERROR_4);
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
                    request.setAttribute("fileUploadError", Constants.FILEUPLOAD_ERROR_2);
                    return false;
                }
                logoPicPath = request.getContextPath()+"/statics/uploadfiles/"+fileName;
                logoLocPath = path+File.separator+fileName;
                file.put("logoPicPath",logoPicPath);
                file.put("logoLocPath",logoLocPath);
            }else{
                request.setAttribute("fileUploadError", Constants.FILEUPLOAD_ERROR_3);
                return false;
            }
        }
        return true;
    }
}
