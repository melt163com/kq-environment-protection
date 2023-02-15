package com.demo.comment;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * todo:跳过验证，通常是入口方法上用这个，比如登录接口
 * @author 15015
 * @Auther: TongDeYi
 * @Date: 2022/05/12/10:49
 * @Description:
 *
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
