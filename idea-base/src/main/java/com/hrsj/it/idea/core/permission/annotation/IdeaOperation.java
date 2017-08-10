
package com.hrsj.it.idea.core.permission.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.hrsj.it.idea.core.permission.enume.Policy;

/**
 * Idea方法定义注解
 * 
 * @author guan
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.METHOD )
public @interface IdeaOperation
{

    Policy policy();

    String code();

    String desc();
}
