
package com.hrsj.it.idea.core.permission.data;
/**  
* 类说明   
*  
* @author ****  
* @date 2017年8月10日  新建  
*/

import com.hrsj.it.idea.core.permission.domain.ResourceVO;

public interface IResourceData
{

    /**
     * 根据资源编码查找资源
     * 
     * @param resoucreCode
     * @param resourceType
     * @param operationCode
     * @param appName
     * @return
     */

    ResourceVO queryResoure( String resoucreCode, String resourceType,
            String operationCode, String appName );

    /**
     * 更新资源
     * 
     * @param resource
     */
    void updateResource( ResourceVO resource );

    /**
     * 插入资源
     * 
     * @param resource
     */
    void insert( ResourceVO resource );

    /**
     * 删除系统某种资源
     * 
     * @param resourceType
     * @param appName
     */
    void deleteApplicationResourceByServiceType( String resourceType,
            String appName );

    /**
     * 失效系统某种资源
     * 
     * @param resourceType
     * @param appName
     */
    void disableApplicationResourceByServiceType( String resourceType,
            String appName );

    /**
     * 删除失效的资源
     * 
     * @param resourceType
     * @param appName
     */
    void deleteDisableApplicationResourceByServiceType( String resourceType,
            String appName );
}
