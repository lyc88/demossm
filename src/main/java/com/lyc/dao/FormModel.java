package com.lyc.dao;

import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by lyc on 2017/11/28.
 * email 984006207@qq.com
 */
@Target({ ElementType.PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface FormModel {
    String value()default "";
}
