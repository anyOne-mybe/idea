package com.idea.it.core.user.dao;

import com.idea.it.core.user.domain.TplUser;
import com.idea.it.core.user.domain.TplUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TplUserMapper {
    int countByExample(TplUserExample example);

    int deleteByExample(TplUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TplUser record);

    int insertSelective(TplUser record);

    List<TplUser> selectByExample(TplUserExample example);

    TplUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TplUser record, @Param("example") TplUserExample example);

    int updateByExample(@Param("record") TplUser record, @Param("example") TplUserExample example);

    int updateByPrimaryKeySelective(TplUser record);

    int updateByPrimaryKey(TplUser record);
}