package com.springframework.stereotype;

import java.lang.annotation.*;
/**
 * @author wuxx
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
