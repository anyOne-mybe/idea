
package com.idea.it.core.environment.domain;

import java.io.Serializable;
import java.util.List;
import com.idea.it.core.menue.vo.MenueVO;
import com.idea.it.core.user.domain.TplUser;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月12日 新建
 */
public class WorkspaceVO implements Serializable
{

    private static final long serialVersionUID = 3099581945213071929L;

    private String contextPath;
    private String appName;

    private TplUser user;

    private List<MenueVO> menueNodes;

    public String getContextPath()
    {
        return contextPath;
    }

    public void setContextPath( String contextPath )
    {
        this.contextPath = contextPath;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName( String appName )
    {
        this.appName = appName;
    }

    public TplUser getUser()
    {
        return user;
    }

    public void setUser( TplUser user )
    {
        this.user = user;
    }

    public List<MenueVO> getMenueNodes()
    {
        return menueNodes;
    }

    public void setMenueNodes( List<MenueVO> menueNodes )
    {
        this.menueNodes = menueNodes;
    }

}
