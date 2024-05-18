package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/05/12/14:40
 * @Description:
 */
@Component
@Aspect
public class WebLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    /**
     * 以自定义@WebLog注解为切点
     **/
    @Pointcut("@annotation(com.example.aop.WebLog)")
    public void webLog() {
        // 该方法无需实现，注解即可
    }

    /**
     * 切点之前
     **/
    @Before("webLog()")
    public void Before(JoinPoint joinPoint) throws ClassNotFoundException {
        // 得到HttpServletRequest对象
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes != null) {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            logger.info("============= 请求开始 ==============");
            // 获取WebLog注解信息
            String webLogInfo = getWebLogInfo(joinPoint);
            logger.info("请求地址 : " + request.getRequestURL().toString());
            logger.info("请求方式 : " + request.getMethod());
            logger.info("请求类名 : " + joinPoint.getTarget().getClass().getName());
            logger.info("请求方法名 : " + joinPoint.getSignature().getName());
            logger.info("请求参数 : " + webLogInfo);
            logger.info("请求用户 : " + request.getRemoteUser());
        } else {
            logger.error("请求获取失败");
        }
    }

    /**
     * 切点之后
     **/
    @After("webLog()")
    public void after() {
        logger.info("============= 请求结束 ==============");
    }

    /**
     * 切点返回内容之后
     **/
    @AfterReturning("webLog()")
    public void afterReturning() {
        logger.info("============= 请求内容返回 ==============");
    }

    /**
     * 切点抛出异常之后
     **/
    @AfterThrowing("webLog()")
    public void afterThrowing() {
        logger.info("============= 请求抛出异常 ==============");
    }

    /**
     * 切点环绕
     **/
    @Around("webLog()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("============= 请求环绕开始 ==============");
        long startTime = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        // 打印出参
        logger.info("请求返回值 : " + proceed);
        long endTime = System.currentTimeMillis();
        logger.info("请求耗时 : " + (endTime - startTime) + "ms");
        logger.info("============= 请求环绕结束 ==============");
        return proceed;
    }

    /**
     * 获取web日志注解信息
     **/
    public String getWebLogInfo(JoinPoint joinPoint) throws ClassNotFoundException {
        // 获取切入点的目标类
        String className = joinPoint.getTarget().getClass().getName();
        Class<?> aClass = Class.forName(className);
        // 获取切入方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取切入方法参数
        Object[] args = joinPoint.getArgs();
        // 获取目标类的所有方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            // 方法名相同、包含目标注解、方法参数个数相同（避免重载）
            if (method.getName().equals(methodName)
                    && method.isAnnotationPresent(WebLog.class)
                    && method.getParameterTypes().length == args.length) {
                return method.getAnnotation(WebLog.class).value();
            }
        }
        return "为获取到注解方法信息，请检查注解是否正确配置日志注解信息";
    }

}
