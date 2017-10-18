
package com.idea.it.core.menue.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.idea.it.core.menue.IMenueOperatable;
import com.idea.it.core.menue.data.IMenueData;
import com.idea.it.core.menue.domain.Menue;
import com.idea.it.core.menue.vo.MenueVO;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月11日 新建
 */
@Named
public class MenueOperationImpl implements IMenueOperatable
{
    @Inject
    private IMenueData menueData;

    @Override
    public void handleRequest( HttpServletRequest request,
            HttpServletResponse response, String appName ) throws IOException
    {
        String operateType = request.getParameter( "operateType" );
        if ( StringUtils.equals( "query", operateType ) )
        {
            // 查询菜单
            List<MenueVO> menueVOs = queryMenues( appName );

            Gson gson = new Gson();
            String menueJsonStr = gson.toJson( menueVOs );
            response.getWriter().write( menueJsonStr );

            return;
        }

    }

    @Override
    public List<MenueVO> queryMenues( String appName )
    {
        List<Menue> menues = queryMenueByApplication( appName );
        // todo增加权限过滤

        // 菜单树
        List<MenueVO> menueVOs = treeMenues( menues );

        return menueVOs;
    }

    private List<Menue> queryMenueByApplication( String appName )
    {
        return menueData.queryMenues( appName );
    }

    private List<MenueVO> treeMenues( List<Menue> menues )
    {
        MenueVO menueVO = null;
        List<MenueVO> menueVOs = new ArrayList<MenueVO>();

        for ( Menue menue : menues )
        {
            menueVO = new MenueVO( menue );

            menueVOs.add( menueVO );
        }

        return menueVOs;
    }

}
