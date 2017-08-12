
package com.idea.it.core.menue;

import java.util.List;

import com.idea.it.core.context.IIdeaServletHandler;
import com.idea.it.core.menue.vo.MenueVO;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月11日 新建
 */
public interface IMenueOperatable extends IIdeaServletHandler
{

    /**
     * 查询菜单栏目
     * 
     * @param appName
     * @return
     */
    List<MenueVO> queryMenues( String appName );
}
