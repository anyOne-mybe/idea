
package com.idea.it.core.permission;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idea.it.common.domain.ServiceResponse;

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

    void handleIdeaPremission( HttpServletRequest request,
            HttpServletResponse response, String appName ) throws IOException;

}
