package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Author: huangbin
 * @Description: 日志注解
 * @Date: Created in 2018/07/05
 * @Modified By:
 */

@Target(ElementType.METHOD)

public @interface MyLog {
    String requestUrl();
}
