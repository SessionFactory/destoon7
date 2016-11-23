package intecptor;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class SayServiceImpl implements SayService
{
    @Override
    public void sayHello()
    {
        System.out.println(SessionFactory.class.getCanonicalName());
    }

    @Override
    public String s1()
    {
        return "s1";
    }
}