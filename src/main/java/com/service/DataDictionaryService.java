package com.service;

import com.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryService {

    public List<DataDictionary> getDataDictionaryList(String typeCode);
}
