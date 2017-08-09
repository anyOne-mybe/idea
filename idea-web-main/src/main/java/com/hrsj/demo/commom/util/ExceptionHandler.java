
package com.hrsj.demo.commom.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.hrsj.demo.commom.constants.ErrooCode;
import com.hrsj.demo.commom.exception.BaseBusinessException;
import com.hrsj.demo.commom.exception.BaseRuntimeException;
import com.hrsj.demo.domain.common.ServiceResponse;

public class ExceptionHandler
{

    private static final Log logger = LogFactory
            .getLog( ExceptionHandler.class );

    public static <T> void handleException( ServiceResponse<T> response,
            Exception e )
    {

        if ( e instanceof BaseRuntimeException )
        {
            BaseRuntimeException baseRuntimeException = (BaseRuntimeException)e;
            response.setStatus( baseRuntimeException.getStatus() );
            response.setMessage( baseRuntimeException.getMessage() );

        } else if ( e instanceof BaseBusinessException )
        {
            BaseBusinessException baseBusinessException = (BaseBusinessException)e;
            response.setStatus( baseBusinessException.getStatus() );
            response.setMessage( baseBusinessException.getMessage() );
        } else
        {
            response.setStatus( ErrooCode.System.CODE_UNKNOWN_ERROR );
            response.setMessage( ErrooCode.System.MSG_UNKNOWN_ERROR );
        }

        logger.error( "Catch system error :", e );
    }

}
