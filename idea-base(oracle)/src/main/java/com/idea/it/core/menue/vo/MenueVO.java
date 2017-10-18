
package com.idea.it.core.menue.vo;

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

    private Long pId;

    private String hash;

    private int sort;

    public MenueVO()
    {

    }

    public MenueVO( Menue menue )
    {
        this.id = menue.getId();
        this.name = menue.getName();
        this.pId = menue.getParentId();
        this.hash = menue.getUrl();
        this.sort = menue.getSort();
        // this.children = new ArrayList<MenueVO>();
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

    public Long getpId()
    {
        return pId;
    }

    public void setpId( Long pId )
    {
        this.pId = pId;
    }

    public String getHash()
    {
        return hash;
    }

    public void setHash( String hash )
    {
        this.hash = hash;
    }

    public int getSort()
    {
        return sort;
    }

    public void setSort( int sort )
    {
        this.sort = sort;
    }

}
