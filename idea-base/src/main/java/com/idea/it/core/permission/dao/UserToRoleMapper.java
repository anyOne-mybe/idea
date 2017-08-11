package com.idea.it.core.permission.dao;

import com.idea.it.core.permission.domain.UserToRole;
import com.idea.it.core.permission.domain.UserToRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserToRoleMapper {
    int countByExample(UserToRoleExample example);

    int deleteByExample(UserToRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserToRole record);

    int insertSelective(UserToRole record);

    List<UserToRole> selectByExample(UserToRoleExample example);

    UserToRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserToRole record, @Param("example") UserToRoleExample example);

    int updateByExample(@Param("record") UserToRole record, @Param("example") UserToRoleExample example);

    int updateByPrimaryKeySelective(UserToRole record);

    int updateByPrimaryKey(UserToRole record);
}