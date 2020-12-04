package com.dao;

import com.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AppCategoryMapper {

    public List<AppCategory> getAppCategoryListByParentId(@Param("parentId") Integer parentId);
}
