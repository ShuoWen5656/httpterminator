package top.swzhao.project.httpterminator.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author swzhao
 * @data 2023/7/8 18:51
 * @Discreption <> 请求中 http://...?parma1=xxx&param2=xxx
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface UrlParam {

    /**
     * urlparamkey(必填)
     * @return
     */
    String name();


}

