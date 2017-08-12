
package com.idea.it.core.environment.support;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.idea.it.common.util.UserHelper;
import com.idea.it.core.environment.IEnvironmentOperatable;
import com.idea.it.core.environment.domain.WorkspaceVO;
import com.idea.it.core.menue.IMenueOperatable;
import com.idea.it.core.menue.vo.MenueVO;
import com.idea.it.core.user.domain.TplUser;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月12日 新建
 */
@Named
public class EnvironmentBuilder implements IEnvironmentOperatable
{

    @Inject
    private IMenueOperatable menueOperator;

    @Override
    public void handleRequest( HttpServletRequest request,
            HttpServletResponse response, String appName ) throws IOException
    {
        WorkspaceVO workspaceVO = getWrokspaceVO( appName );

        Gson gson = new Gson();
        String jsonStr = gson.toJson( workspaceVO );

        response.setContentType( "application/json" );

        response.getWriter().write( jsonStr );
    }

    private WorkspaceVO getWrokspaceVO( String appName )
    {
        WorkspaceVO workspaceVO = new WorkspaceVO();
        List<MenueVO> menueVOs = menueOperator.queryMenues( appName );

        TplUser user = UserHelper.getCurrentUser();
        workspaceVO.setAppName( appName );
        workspaceVO.setMenueNodes( menueVOs );
        workspaceVO.setUser( user );

        return workspaceVO;
    }

}
