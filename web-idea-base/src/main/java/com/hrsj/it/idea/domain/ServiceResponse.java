
package com.hrsj.it.idea.domain;

import java.io.Serializable;

public class ServiceResponse<T> implements Serializable
{
    private static final long serialVersionUID = 2887917607189489902L;
    private T data;
    private int status;
    private String message;

    public T getData()
    {
        return data;
    }

    public void setData( T data )
    {
        this.data = data;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus( int status )
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }

}
