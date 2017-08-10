
package com.hrsj.it.idea.core.permission.dao;

import com.hrsj.it.idea.core.permission.domain.IdeaResource;
import com.hrsj.it.idea.core.permission.domain.IdeaResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdeaResourceMapper
{
    int countByExample( IdeaResourceExample example );

    int deleteByExample( IdeaResourceExample example );

    int deleteByPrimaryKey( Integer id );

    int insert( IdeaResource record );

    int insertSelective( IdeaResource record );

    List<IdeaResource> selectByExample( IdeaResourceExample example );

    IdeaResource selectByPrimaryKey( Integer id );

    int updateByExampleSelective( @Param( "record" ) IdeaResource record,
            @Param( "example" ) IdeaResourceExample example );

    int updateByExample( @Param( "record" ) IdeaResource record,
            @Param( "example" ) IdeaResourceExample example );

    int updateByPrimaryKeySelective( IdeaResource record );

    int updateByPrimaryKey( IdeaResource record );
}