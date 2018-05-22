package com.xyb2c.dao;

import com.xyb2c.pojo.RepairList;
import com.xyb2c.pojo.RepairListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairListMapper {
    int countByExample(RepairListExample example);

    int deleteByExample(RepairListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RepairList record);

    int insertSelective(RepairList record);

    List<RepairList> selectByExample(RepairListExample example);

    RepairList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RepairList record, @Param("example") RepairListExample example);

    int updateByExample(@Param("record") RepairList record, @Param("example") RepairListExample example);

    int updateByPrimaryKeySelective(RepairList record);

    int updateByPrimaryKey(RepairList record);
    /**
     * 分页查询
     * @param example
     * @return
     */
    List<RepairList> selectByExamplePage(RepairListExample example);
    
    /**
     * 回收站 
     * @return
     */
    List<RepairList> selectRepairListByFlag();
}