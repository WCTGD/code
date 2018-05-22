package com.xyb2c.dao;

import com.xyb2c.pojo.Zzf;
import com.xyb2c.pojo.ZzfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzfMapper {
    int countByExample(ZzfExample example);

    int deleteByExample(ZzfExample example);

    int insert(Zzf record);

    int insertSelective(Zzf record);

    List<Zzf> selectByExample(ZzfExample example);

    int updateByExampleSelective(@Param("record") Zzf record, @Param("example") ZzfExample example);

    int updateByExample(@Param("record") Zzf record, @Param("example") ZzfExample example);
}