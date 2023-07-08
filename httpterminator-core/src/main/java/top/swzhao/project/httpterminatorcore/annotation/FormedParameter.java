package top.swzhao.project.httpterminatorcore.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author swzhao
 * @data 2023/7/8 13:24
 * @Discreption <>
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface FormedParameter {


    /**
     * 表单变量名称（必填）
     * @return
     */
    String name();


}
