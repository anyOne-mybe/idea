package com.idea.it.core.permission.dao;

import com.idea.it.core.permission.domain.User2Role;
import com.idea.it.core.permission.domain.User2RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface User2RoleMapper {
    int countByExample(User2RoleExample example);

    int deleteByExample(User2RoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User2Role record);

    int insertSelective(User2Role record);

    List<User2Role> selectByExample(User2RoleExample example);

    User2Role selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User2Role record, @Param("example") User2RoleExample example);

    int updateByExample(@Param("record") User2Role record, @Param("example") User2RoleExample example);

    int updateByPrimaryKeySelective(User2Role record);

    int updateByPrimaryKey(User2Role record);
}