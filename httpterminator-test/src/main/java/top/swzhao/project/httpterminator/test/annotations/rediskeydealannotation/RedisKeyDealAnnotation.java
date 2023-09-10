package top.swzhao.project.httpterminator.test.annotations.rediskeydealannotation;

import java.lang.annotation.*;

/**
 * @author swzhao
 * @data 2023/9/10 10:11
 * @Discreption <> 通用redisKey处理注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RedisKeyDealAnnotation {

    /**
     * 需要处理的redisKey列表
     * @return
     */
    String[] keys() default {};

    /**
     * 操作 - 默认是删除这个key
     * @return
     */
    RedisKeyOpt opt() default RedisKeyOpt.DELETE;

    /**
     * 执行的dbindex
     * @return
     */
    int dbIndex() default 0;

    /**
     * 设置和更新后的key时间默认10(min)
     * @return
     */
    int expire() default 60*10;

    /**
     * redisKey操作
     */
    enum RedisKeyOpt{
        DELETE,
        UPDATE,
        CREATE;
    }

}

