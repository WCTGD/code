package com.xyb2c.dao;

import com.xyb2c.pojo.Maintain;
import com.xyb2c.pojo.MaintainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaintainMapper {
    int countByExample(MaintainExample example);

    int deleteByExample(MaintainExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Maintain record);

    int insertSelective(Maintain record);

    List<Maintain> selectByExample(MaintainExample example);

    Maintain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Maintain record, @Param("example") MaintainExample example);

    int updateByExample(@Param("record") Maintain record, @Param("example") MaintainExample example);

    int updateByPrimaryKeySelective(Maintain record);

    int updateByPrimaryKey(Maintain record);
    /**
     * 分页查询
     * @param example
     * @return
     */
    List<Maintain> selectByExamplePage(MaintainExample example);
    
    /**
     * 回收站
     * @return
     */
    List<Maintain> selectMaintainByShow();
}