package com.xyb2c.dao;

import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.UploadFile;
import com.xyb2c.pojo.UploadFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UploadFileMapper {
    int countByExample(UploadFileExample example);

    int deleteByExample(UploadFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UploadFile record);

    int insertSelective(UploadFile record);

    List<UploadFile> selectByExample(UploadFileExample example);

    UploadFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UploadFile record, @Param("example") UploadFileExample example);

    int updateByExample(@Param("record") UploadFile record, @Param("example") UploadFileExample example);

    int updateByPrimaryKeySelective(UploadFile record);

    int updateByPrimaryKey(UploadFile record);
    
    /**
     * 安全指导 添加
     * @param uploadFile
     */
    void insertUploadFile(UploadFile uploadFile);
    
    /**
     * 安全指导 修改(覆盖)
     * @param uploadFile
     */
    void updateUploadFile(UploadFile uploadFile);
    
    /**
     * 查询所有
     * @return
     */
    List<UploadFile> uploadFileList();
    
    /**
     * 查询no
     * @return
     */
    UploadFile uploadFileNo();
    
    /**
     * 查询页面
     * @return
     */
    List<UploadFile> listUploadFile(PageBean page);
    
    int countUploadFile();
    
    /**
     * 删除 安全指导
     * @param no
     */
    void deleteSecurityGuidance(String no);
    
    /**
     *  通过no查询所有 安全指导
     * @param no
     * @return
     */
    UploadFile downloadUploadFile(String no);
    
}