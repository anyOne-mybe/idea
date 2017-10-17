
package com.idea.it.core.menue.data.impl;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import com.idea.it.core.menue.dao.MenueMapper;
import com.idea.it.core.menue.data.IMenueData;
import com.idea.it.core.menue.domain.Menue;
import com.idea.it.core.menue.domain.MenueExample;
import com.idea.it.core.menue.domain.MenueExample.Criteria;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月11日 新建
 */
@Named
public class MenueDataImpl implements IMenueData
{
    @Inject
    private MenueMapper menueMapper;

    @Override
    public List<Menue> queryMenues( String appName )
    {
        MenueExample example = new MenueExample();
        Criteria criteria = example.createCriteria();
        criteria.andAppNameEqualTo( appName );
        example.setOrderByClause( "sort asc" );

        return menueMapper.selectByExample( example );
    }

}
