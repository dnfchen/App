package com.service;

import com.pojo.DevUser;

import java.util.List;

public interface DevUserService {

    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);

    DevUser findDevUserByUser(DevUser devUser);
}
