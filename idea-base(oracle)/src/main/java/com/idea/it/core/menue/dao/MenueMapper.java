package com.idea.it.core.menue.dao;

import com.idea.it.core.menue.domain.Menue;
import com.idea.it.core.menue.domain.MenueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenueMapper {
    int countByExample(MenueExample example);

    int deleteByExample(MenueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Menue record);

    int insertSelective(Menue record);

    List<Menue> selectByExample(MenueExample example);

    Menue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Menue record, @Param("example") MenueExample example);

    int updateByExample(@Param("record") Menue record, @Param("example") MenueExample example);

    int updateByPrimaryKeySelective(Menue record);

    int updateByPrimaryKey(Menue record);
}