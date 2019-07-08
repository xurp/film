package com.geekq.guns.core.intercept;

import com.geekq.guns.core.base.controller.BaseController;
import com.geekq.guns.core.util.HttpSessionHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 静态调用session的拦截器
 *
 * @author fengshuonan
 * @date 2016年11月13日 下午10:15:42
 */
@Aspect
@Component
public class SessionHolderInterceptor extends BaseController {

    @Pointcut("execution(* com.geekq.guns.*..controller.*.*(..))")
    public void cutService() {
    }

    @Around("cutService()")
    public Object sessionKit(ProceedingJoinPoint point) throws Throwable {
    	// [注]:HttpSessionHolder用ThreadLocal做非Controller中获取当前session的工具类,这里估计就是每个方法都把session存一遍
    	// [注]:与其说是标准拦截器,不如说是一个AOP
        HttpSessionHolder.put(super.getHttpServletRequest().getSession());
        try {
            return point.proceed();
        } finally {
        	// [注]:但这里,每次都把ThreadLocal的session清空了.应该是这样的:首先执行point.proceed(),然后清空HttpSessionHolder,然后return执行结果
            HttpSessionHolder.remove();
        }
    }
}
