package com.example.aop;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/05/12/14:37
 * @Description:
 */

// 运行时使用
@Retention(RetentionPolicy.RUNTIME)
// 注解用于方法
@Target({ElementType.METHOD})
// 注解包含在JavaDoc中
@Documented
public @interface WebLog {
    // 日志描述
    String value() default "";
}
