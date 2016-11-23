package destoonTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _1_MakeTable
{
    protected SessionFactory sessionFactory = (SessionFactory) new
              ClassPathXmlApplicationContext("applicationContext.xml")
              .getBean("sessionFactory");

    protected Session session = sessionFactory.openSession();


    @Test
    public void make()
    {
        //System.out.println(sessionFactory);
        session
                  .createSQLQuery("drop database destoon7")
                  .executeUpdate();
        session
                  .createSQLQuery("create database destoon7 default charset utf8")
                  .executeUpdate();
        session.beginTransaction().commit();

    }
    //drop database destoon7; create database destoon7 default charset utf8;
}