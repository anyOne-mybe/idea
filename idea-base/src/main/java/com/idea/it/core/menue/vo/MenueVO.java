
package com.idea.it.core.menue.vo;

import java.util.ArrayList;
import java.util.List;

import com.idea.it.core.menue.domain.Menue;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月11日 新建
 */
public class MenueVO
{

    private Long id;

    private String name;

    private Long parentId;

    private String url;

    private List<MenueVO> children;

    public MenueVO()
    {

    }

    public MenueVO( Menue menue )
    {
        this.id = menue.getId();
        this.name = menue.getName();
        this.parentId = menue.getParentId();
        this.url = menue.getUrl();
        this.children = new ArrayList<MenueVO>();
    }

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId( Long parentId )
    {
        this.parentId = parentId;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl( String url )
    {
        this.url = url;
    }

    public List<MenueVO> getChildren()
    {
        return children;
    }

    public void setChildren( List<MenueVO> children )
    {
        this.children = children;
    }

}
