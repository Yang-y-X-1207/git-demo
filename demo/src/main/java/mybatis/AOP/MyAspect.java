package mybatis.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Around("execution(* mybatis.service.userService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开始执行方法");
        Object result = joinPoint.proceed();
        System.out.println("方法执行完毕");
        return result;
    }
}
