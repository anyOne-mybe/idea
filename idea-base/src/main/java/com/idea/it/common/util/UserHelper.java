
package com.idea.it.common.util;
/**  
* 类说明   
*  
* @author ****  
* @date 2017年8月11日  新建  
*/

import javax.servlet.http.HttpSession;
import com.idea.it.core.context.manager.IdeaContextManager;
import com.idea.it.core.user.constants.UserToken;
import com.idea.it.core.user.domain.TplUser;

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
        user.setUserId( 123456789L );

        return user;
    }

}
