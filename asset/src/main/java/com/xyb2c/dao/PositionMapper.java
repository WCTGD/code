package com.xyb2c.dao;

import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.LocationConditions;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.PositionExample;


import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionMapper {
    int countByExample(PositionExample example);

    int deleteByExample(PositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
    
    /**
     * 位置条件查询
     * @param locationConditions
     * @return
     */
    List<LocationConditions> positionList(@Param(value="locationConditions")LocationConditions locationConditions,@Param(value="page") PageBean page);
    
    /**
     * 查询总条数
     * @return
     */
    int positionCount(@Param(value="locationConditions")LocationConditions locationConditions);
    
    /**
     * 位置查询页面
     * @param page
     * @return
     */
    List<LocationConditions> positionListPage(PageBean page);
    
    /**
     * 部门查询
     * @return
     */
    List<BaseDepartment> selectDepartment();
    
    /**
     * 通过部门Id查询  最大的位置编号
     */
    LocationConditions selectLocationNumberByDepartmentId(Integer id);

	/**
     * 通过部门Id查询  最大的位置编号
     */
    LocationConditions updateLocationNumberByDepartmentId(Integer aid);
    
    /**
     * 添加位置表单
     */
    void insertPosition(LocationConditions lc);
    
    /**
     * 删除（修改flag状态）
     * @param id
     */
    void deleteById(Integer id);
    
    
    /**
     * 修改前的查询
     * @return
     */
    LocationConditions selectPlaceById(Integer id);


    /**
     * 通过Id修改
     * @param lC
     */
    void updateById(LocationConditions locationConditions);

    
    /**
     * 通过部门查询  部门编号
     */
    BaseDepartment selectLocationNumberByDepartment(Integer id);
    
    
    /**
     * 添加前 根据id 查询出该部门的信息
     * @param id
     * @return
     */
    BaseDepartment selectDepartmentById(Integer id);
    
    /**
     * 无条件查询位置编号
     * @return
     */
    List<LocationConditions> selectlc();
    
    /**
     * 删除 位置(update)
     * @param no
     */
    void deletePositionByNo(String no);
    
    /**
     * 通过 no 查询 (获取id)
     * @param no
     * @return
     */
    Position selectPositionByNo(String no);
    
    /**
     * 查询位置所有信息
     * @return
     */
    List<Position> selectPosition();
    
    /**
     * 回收站
     * @return
     */
    LocationConditions selectPositionByShow(Integer id);
    
    
}