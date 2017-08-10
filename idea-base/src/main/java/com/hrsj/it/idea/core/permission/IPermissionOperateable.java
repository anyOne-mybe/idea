
package com.hrsj.it.idea.core.permission;

import com.hrsj.it.idea.domain.ServiceResponse;

/**
 * 权限操作接口类,定义系统权限操作
 * 
 * @author ****
 * @date 2017年8月9日 新建
 */
public interface IPermissionOperateable
{

    /**
     * 同步系统权限
     * 
     * @return
     */
    ServiceResponse<Boolean> syncIdeaPermission();

    /**
     * 删除失效的权限
     * 
     * @return
     */
    ServiceResponse<Boolean> deleteUnUsedPermission();

}
