package destoonTest;

import member.dao.MemberDAO;
import member.domain.MakeHTTP;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class _3_MakeHTTPTest
{
    protected SessionFactory sessionFactory = (SessionFactory) new
              ClassPathXmlApplicationContext("applicationContext.xml")
              .getBean("sessionFactory");

    protected Session session = sessionFactory.openSession();

    /**
     * 测试级联
     */
    @Test
    public void save1()
    {
        MakeHTTP[] m =
                  {
                            new MakeHTTP("童安格版权所有", "童安格"),
                            new MakeHTTP("周治平版权所有", "周治平"),
                            new MakeHTTP("周华健版权所有", "风雨无阻"),
                            new MakeHTTP("张学友版权所有", "一路上有你"),
                            new MakeHTTP("刘德华版权所有", "天意"),
                  };

        for (int i = 0; i < m.length; i++)
        {
            session.save(m[i]);
        }

        //session.beginTransaction().commit();
    }

    @Test
    public void save2()
    {
        MemberDAO memberDAO = (MemberDAO) new
                  ClassPathXmlApplicationContext("applicationContext.xml")
                  .getBean("destoon_memberDAO7");
        memberDAO.iniMember();
    }
}

















