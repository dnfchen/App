package com.dao;

import com.pojo.DevUser;
import org.springframework.stereotype.Repository;


public interface DevUserMapper  {
    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);

    DevUser findDevUserByUser(DevUser devUser);
}
