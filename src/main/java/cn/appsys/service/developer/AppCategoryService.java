package cn.appsys.service.developer;

import cn.appsys.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppCategoryService {
    public List<AppCategory> getAppCategoryListByParentId(Integer parentId)throws Exception;
}
