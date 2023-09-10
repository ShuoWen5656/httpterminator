package top.swzhao.project.httpterminator.test.annotations.rediskeydealannotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.swzhao.project.httpterminator.test.utils.RedisUtils;

import java.util.Map;
import java.util.Objects;

/**
 * @author swzhao
 * @data 2023/9/10 10:31
 * @Discreption <> 切面操作
 */
@Component
@Aspect
@Slf4j
public class RedisKeyDealAnnotationAspect {


    /**
     * update类型的操作需要写库之后，业务通过当前县城的threadlocal传进来进行更新
     **/
    private static final ThreadLocal<Map<String, String>> dealKV = new ThreadLocal<>();


    /**
     * 切面：使用{@link RedisKeyDealAnnotation} 进行注解的方法
     */
    @Pointcut(value = "@annotation(RedisKeyDealAnnotation)")
    public void keyDeal() {}


    @Around(value = "keyDeal() && @annotation(annotation)")
    public Object around(ProceedingJoinPoint joinPoint, RedisKeyDealAnnotation annotation) {
        Object res = null;
        try {
            // 获取注解中的各种参数
            String[] keys = annotation.keys();
            int dbIndex = annotation.dbIndex();
            int expire = annotation.expire();
            RedisKeyDealAnnotation.RedisKeyOpt opt = annotation.opt();
            // 目前默认只有删除功能，后期可以拓展
            switch (opt) {
                case DELETE:
                    RedisUtils.delList(dbIndex, keys);
                    break;
                default:
                    break;
            }
            // 执行目标方法
            res = joinPoint.proceed();
            // 结束之后检查是否需要处理dealKV
            if ((opt == RedisKeyDealAnnotation.RedisKeyOpt.UPDATE || opt == RedisKeyDealAnnotation.RedisKeyOpt.CREATE)
                    && Objects.nonNull(dealKV.get()) && !dealKV.get().isEmpty()) {
                Map<String, String> kv = dealKV.get();
                for (Map.Entry<String, String> entry : kv.entrySet()) {
                    RedisUtils.set(dbIndex, entry.getKey(), entry.getValue(), expire);
                }
            }
        } catch (Throwable throwable) {
            log.error(getClass().getSimpleName() + "," + Thread.currentThread().getStackTrace()[1].getMethodName()+"调用异常:", throwable);
        }
        return res;
    }




}
