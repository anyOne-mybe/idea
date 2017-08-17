
package com.hrsj.demo.action.book;

import java.io.Serializable;
import java.util.List;

/**
 * 类说明
 * 
 * @author ****
 * @date 2017年8月17日 新建
 */
public class Book implements Serializable
{

    private static final long serialVersionUID = -7088968064196442226L;

    private String name;
    private String author;
    private List<String> prices;

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor( String author )
    {
        this.author = author;
    }

    public List<String> getPrices()
    {
        return prices;
    }

    public void setPrices( List<String> prices )
    {
        this.prices = prices;
    }

}
