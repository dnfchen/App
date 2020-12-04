package com.dao;

import com.pojo.BackendUser;
import org.springframework.stereotype.Repository;


public interface BackendUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    BackendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);

    BackendUser findBackendUserByUser(BackendUser backendUser);
}
