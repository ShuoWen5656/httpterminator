package top.swzhao.project.httpterminator.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author swzhao
 * @data 2023/7/8 13:26
 * @Discreption <>
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Header {

    /**
     * 请求头key名称（必填）
     * @return
     */
    String name();


}
