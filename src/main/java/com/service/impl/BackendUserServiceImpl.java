package com.service.impl;

import com.dao.BackendUserMapper;
import com.pojo.BackendUser;
import com.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackendUserServiceImpl implements BackendUserService {

    @Autowired
    private BackendUserMapper backendUserMapper;

    @Override
    public BackendUser findBackendUserByUser(BackendUser backendUser) {
        return backendUserMapper.findBackendUserByUser(backendUser);
    }
}
