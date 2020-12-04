package com.service.impl;



import com.dao.DevUserMapper;
import com.pojo.DevUser;
import com.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DevUserServiceImpl implements DevUserService {

    @Autowired
    private DevUserMapper devUserMapper;

    public DevUser addDevUser(DevUser devUser) {
        devUserMapper.insert(devUser);
        return devUser;
    }



    public DevUser findDevUserByCode(String devcode) {
        DevUser devUser = new DevUser();
        devUser.setDevCode(devcode);
        return null;
    }

    public DevUser updateDevUser(DevUser devUser) {
        return null;
    }

    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(DevUser record) {
        return 0;
    }

    public int insertSelective(DevUser record) {
        return 0;
    }

    public DevUser selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByPrimaryKeySelective(DevUser record) {
        return 0;
    }

    public int updateByPrimaryKey(DevUser record) {
        return 0;
    }

    public DevUser findDevUserByUser(DevUser devUser) {
        return devUserMapper.findDevUserByUser(devUser);
    }
}
