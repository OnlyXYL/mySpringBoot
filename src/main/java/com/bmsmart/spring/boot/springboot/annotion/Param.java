package com.bmsmart.spring.boot.springboot.annotion;

import java.lang.annotation.*;

/**
 * @author Mikan
 * @date 2015-08-04 23:39
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Param {
    String value();
}