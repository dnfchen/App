package com.service;

import com.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppCategoryService {

    public List<AppCategory> getAppCategoryListByParentId(@Param("parentId") Integer parentId);
}
