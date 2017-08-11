
package com.idea.it.core.permission.data.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.util.CollectionUtils;

import com.idea.it.core.permission.constant.ServiceType;
import com.idea.it.core.permission.dao.ResourceVOMapper;
import com.idea.it.core.permission.data.IResourceData;
import com.idea.it.core.permission.domain.ResourceVO;
import com.idea.it.core.permission.domain.ResourceVOExample;
import com.idea.it.core.permission.domain.ResourceVOExample.Criteria;

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
    private ResourceVOMapper resourceVOMapper;

    @Override
    public ResourceVO queryResoure( String resoucreCode, String resourceType,
            String operationCode, String appName )
    {
        ResourceVOExample example = new ResourceVOExample();
        Criteria criteria = example.createCriteria();
        criteria.andResourceCodeEqualTo( resoucreCode );
        criteria.andResourceTypeEqualTo( resourceType );
        criteria.andOperationCodeEqualTo( operationCode );
        criteria.andAppNameEqualTo( appName );

        List<ResourceVO> datas = resourceVOMapper.selectByExample( example );
        if ( !CollectionUtils.isEmpty( datas ) )
        {
            return datas.get( 0 );
        }

        return null;
    }

    @Override
    public void updateResource( ResourceVO resource )
    {
        ResourceVOExample example = new ResourceVOExample();
        Criteria criteria = example.createCriteria();
        criteria.andResourceCodeEqualTo( resource.getResourceCode() );
        criteria.andResourceTypeEqualTo( ServiceType.SERVICE );
        criteria.andOperationCodeEqualTo( resource.getOperationCode() );

        resourceVOMapper.updateByExample( resource, example );
    }

    @Override
    public void insert( ResourceVO resource )
    {
        resourceVOMapper.insert( resource );
    }

    @Override
    public void deleteApplicationResourceByServiceType( String resourceType,
            String appName )
    {
        ResourceVOExample example = new ResourceVOExample();
        Criteria criteria = example.createCriteria();
        criteria.andResourceTypeEqualTo( resourceType );
        criteria.andAppNameEqualTo( appName );

        resourceVOMapper.deleteByExample( example );
    }

    @Override
    public void disableApplicationResourceByServiceType( String resourceType,
            String appName )
    {
        ResourceVOExample example = new ResourceVOExample();
        Criteria criteria = example.createCriteria();
        criteria.andResourceTypeEqualTo( resourceType );
        criteria.andAppNameEqualTo( appName );

        List<ResourceVO> resources = resourceVOMapper
                .selectByExample( example );
        Date currentTime = new Date();

        for ( ResourceVO resourceVO : resources )
        {
            resourceVO.setAvailable( false );
            resourceVO.setUpdateTime( currentTime );
            resourceVOMapper.updateByPrimaryKey( resourceVO );
        }
    }

    @Override
    public void deleteDisableApplicationResourceByServiceType(
            String resourceType, String appName )
    {
        ResourceVOExample example = new ResourceVOExample();
        Criteria criteria = example.createCriteria();
        criteria.andResourceTypeEqualTo( resourceType );
        criteria.andAppNameEqualTo( appName );
        criteria.andAvailableEqualTo( false );

        resourceVOMapper.deleteByExample( example );
    }

}
