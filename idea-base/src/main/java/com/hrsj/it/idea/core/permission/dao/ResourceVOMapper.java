package com.hrsj.it.idea.core.permission.dao;

import com.hrsj.it.idea.core.permission.domain.ResourceVO;
import com.hrsj.it.idea.core.permission.domain.ResourceVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceVOMapper {
    int countByExample(ResourceVOExample example);

    int deleteByExample(ResourceVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResourceVO record);

    int insertSelective(ResourceVO record);

    List<ResourceVO> selectByExample(ResourceVOExample example);

    ResourceVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResourceVO record, @Param("example") ResourceVOExample example);

    int updateByExample(@Param("record") ResourceVO record, @Param("example") ResourceVOExample example);

    int updateByPrimaryKeySelective(ResourceVO record);

    int updateByPrimaryKey(ResourceVO record);
}