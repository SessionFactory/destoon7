package intecptor;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Method;

@Repository
public class MyAfterReturningAdvice implements AfterReturningAdvice
{
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable
    {
        System.out.println("in afterReturning");
    }
}