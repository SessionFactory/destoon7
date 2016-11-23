package intecptor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest
{
    private ApplicationContext applicationContext = new
              ClassPathXmlApplicationContext("classpath:spring.xml");

    @Test
    public void aop1()
    {
        SayService sayService = (SayService) applicationContext.getBean("proxyFactoryBean");
        sayService.s1();
    }
}