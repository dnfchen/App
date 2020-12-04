package com.service.impl;

import com.dao.DataDictionaryMapper;
import com.pojo.DataDictionary;
import com.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> getDataDictionaryList(String typeCode) {
        return dataDictionaryMapper.getDataDictionaryList(typeCode);
    }
}
