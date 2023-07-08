package top.swzhao.project.httpterminatorcore.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author swzhao
 * @data 2023/7/8 17:21
 * @Discreption <>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HttpTerminator {

    /**
     * 注入bean名称自定义
     * @return
     */
    String name() default "";


}
