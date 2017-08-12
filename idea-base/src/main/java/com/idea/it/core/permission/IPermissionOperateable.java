
package com.idea.it.core.permission;

import com.idea.it.common.domain.ServiceResponse;
import com.idea.it.core.context.IIdeaServletHandler;

/**
 * 权限操作接口类,定义系统权限操作
 * 
 * @author ****
 * @date 2017年8月9日 新建
 */
public interface IPermissionOperateable extends IIdeaServletHandler
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
