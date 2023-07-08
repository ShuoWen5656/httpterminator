package top.swzhao.project.httpterminatorcore.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author swzhao
 * @data 2023/7/8 18:44
 * @Discreption <> 资源标识，拓展字段，用于客户端需要传入某些标识来唯一查询资源使用
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceId {
}
