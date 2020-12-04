package com.dao;

import com.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DataDictionaryMapper {

    public List<DataDictionary> getDataDictionaryList(@Param("typeCode") String typeCode);
}
