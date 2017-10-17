
package com.idea.it.core.menue.data;
/**  
* 类说明   
*  
* @author ****  
* @date 2017年8月11日  新建  
*/

import java.util.List;

import com.idea.it.core.menue.domain.Menue;

public interface IMenueData
{
    /**
     * 根据应用名查询菜单
     * 
     * @param appName
     * @return
     */
    List<Menue> queryMenues( String appName );
}
