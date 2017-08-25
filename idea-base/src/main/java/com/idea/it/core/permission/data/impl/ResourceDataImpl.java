
package com.idea.it.core.permission.data.impl;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.util.CollectionUtils;
import com.idea.it.core.permission.constant.ServiceType;
import com.idea.it.core.permission.dao.ResourceMapper;
import com.idea.it.core.permission.data.IResourceData;
import com.idea.it.core.permission.domain.Resource;
import com.idea.it.core.permission.domain.ResourceExample;
import com.idea.it.core.permission.domain.ResourceExample.Criteria;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月10日 新建
 */
@Named
public class ResourceDataImpl implements IResourceData
{
    @Inject
    private ResourceMapper ResourceMapper;

    @Override
    public Resource queryResoure( String resoucreCode, String resourceType,
            String operationCode, String appName )
    {
        ResourceExample example = new ResourceExample();
        Criteria criteria = example.createCriteria();
        criteria.andResourceCodeEqualTo( resoucreCode );
        criteria.andTypeEqualTo( resourceType );
        criteria.andOperateCodeEqualTo( operationCode );
        criteria.andAppNameEqualTo( appName );

        List<Resource> datas = ResourceMapper.selectByExample( example );
        if ( !CollectionUtils.isEmpty( datas ) )
        {
            return datas.get( 0 );
        }

        return null;
    }

    @Override
    public void updateResource( Resource resource )
    {
        ResourceExample example = new ResourceExample();
        Criteria criteria = example.createCriteria();
        criteria.andResourceCodeEqualTo( resource.getResourceCode() );
        criteria.andTypeEqualTo( ServiceType.SERVICE );
        criteria.andOperateCodeEqualTo( resource.getOperateCode() );

        ResourceMapper.updateByExample( resource, example );
    }

    @Override
    public void insert( Resource resource )
    {
        ResourceMapper.insert( resource );
    }

    @Override
    public void deleteApplicationResourceByServiceType( String resourceType,
            String appName )
    {
        ResourceExample example = new ResourceExample();
        Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo( resourceType );
        criteria.andAppNameEqualTo( appName );

        ResourceMapper.deleteByExample( example );
    }

    @Override
    public void disableApplicationResourceByServiceType( String resourceType,
            String appName )
    {
        ResourceExample example = new ResourceExample();
        Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo( resourceType );
        criteria.andAppNameEqualTo( appName );

        List<Resource> resources = ResourceMapper.selectByExample( example );
        Date currentTime = new Date();

        for ( Resource Resource : resources )
        {
            Resource.setAvailable( false );
            Resource.setUpdateDate( currentTime );
            ResourceMapper.updateByPrimaryKey( Resource );
        }
    }

    @Override
    public void deleteDisableApplicationResourceByServiceType(
            String resourceType, String appName )
    {
        ResourceExample example = new ResourceExample();
        Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo( resourceType );
        criteria.andAppNameEqualTo( appName );
        criteria.andAvailableEqualTo( false );

        ResourceMapper.deleteByExample( example );
    }

}
