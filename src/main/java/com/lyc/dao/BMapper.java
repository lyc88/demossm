package com.lyc.dao;

import com.lyc.model.po.B;
import com.lyc.model.po.BExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BMapper {
    int countByExample(BExample example);

    int deleteByExample(BExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(B record);

    int insertSelective(B record);

    List<B> selectByExample(BExample example);

    B selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") B record, @Param("example") BExample example);

    int updateByExample(@Param("record") B record, @Param("example") BExample example);

    int updateByPrimaryKeySelective(B record);

    int updateByPrimaryKey(B record);
}