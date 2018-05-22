package com.xyb2c.dao;

import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Recycle;
import com.xyb2c.pojo.RecycleExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecycleMapper {
    int countByExample(RecycleExample example);

    int deleteByExample(RecycleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recycle record);

    int insertSelective(Recycle record);

    List<Recycle> selectByExample(RecycleExample example);

    Recycle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recycle record, @Param("example") RecycleExample example);

    int updateByExample(@Param("record") Recycle record, @Param("example") RecycleExample example);

    int updateByPrimaryKeySelective(Recycle record);

    int updateByPrimaryKey(Recycle record);
    
    /**
     * 回收站 界面
     * @param recycle
     * @param page
     * @param start
     * @param end
     * @return
     */
    List<Recycle> selectRecycle(@Param(value="recycle")Recycle recycle,@Param(value="page")PageBean page,@Param(value="start") Date start,@Param(value="end") Date end);
    
    /**
     * 查询总条数
     * @param recycle
     * @param start
     * @param end
     * @return
     */
    int recycleCount(@Param(value="recycle")Recycle recycle,@Param(value="start") Date start,@Param(value="end") Date end);
    
    /**
     * 回收站 类别
     * @return
     */
    List<Recycle> selectRecycleType();
    
    /**
     * 通过ID查询
     * @param id
     * @return
     */
    Recycle selectRecycleById(Integer id);
    
    /**
     * 根据fkid 改变状态
     * @param fkId
     * @param tbName
     */
    void updateRecycleByFkidByTbname(@Param(value="fkId")Integer fkId,@Param(value="tbName")String tbName);
    
    /**
     * 删除回收站记录
     * @param id
     */
    void deleteRecycleById(Integer id);
}