package com.dao;

import com.pojo.AdPromotion;
import org.springframework.stereotype.Repository;


public interface AdPromotionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdPromotion record);

    int insertSelective(AdPromotion record);

    AdPromotion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdPromotion record);

    int updateByPrimaryKey(AdPromotion record);
}
