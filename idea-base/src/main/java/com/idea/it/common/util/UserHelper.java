
package com.idea.it.common.util;

import javax.servlet.http.HttpSession;
import com.idea.it.core.context.manager.IdeaContextManager;
import com.idea.it.core.user.constants.UserToken;
import com.idea.it.core.user.domain.TplUser;

/**
 * @Description 用户工具类
 * @author guanhaobi
 * @date 2017年8月25日
 */
public class UserHelper
{
    public static TplUser getCurrentUser()
    {
        HttpSession session = IdeaContextManager.getRequest()
                .getSession( false );
        if ( null != session )
        {
            return (TplUser)session
                    .getAttribute( UserToken.USER_SESSION_TOKEN );
        }

        TplUser user = new TplUser();
        user.setId( 123456789L );

        return user;
    }

}
