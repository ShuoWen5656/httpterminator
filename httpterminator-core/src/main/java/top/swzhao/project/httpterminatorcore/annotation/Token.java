package top.swzhao.project.httpterminatorcore.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author swzhao
 * @data 2023/7/8 18:48
 * @Discreption <> 默认请求头key X-Auth-Token 自动填装
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {


    /**
     * 请求头token的key值
     * @return
     */
    String name() default "X-Auth-Token";

}
