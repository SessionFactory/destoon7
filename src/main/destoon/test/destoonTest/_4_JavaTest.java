package destoonTest;

import member.domain.MemberPlace;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static core.DestoonUtils7.destPrint;
import static core.DestoonUtils7.printDataGrid;

@SuppressWarnings("all")
public class _4_JavaTest
{
    Session session = null;
    Transaction transaction = null;

    private final void sy(String[] str)
    {
        for (int i = 0; i < str.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(str[i]);
            session.save(memberPlace);
        }
    }

    @Test
    public void makeCode()
    {
        String[] s =
                  {
                            "_北京", "_上海", "_广州", "_深圳", "_天津", "_苏州", "_重庆", "_南京", "_杭州", "_大连", "_成都", "_武汉"
                  };
        for (int i = 0; i < s.length; i++)
        {
            System.out.println
                      (
                                "for (int i = 0; i < " + s[i] + ".length; i++)\n" +
                                          "        {\n" +
                                          "            MemberPlace memberPlace = new MemberPlace(" + s[i] + "[i]);\n" +
                                          "            session.save(memberPlace);\n" +
                                          "        }"
                      );
        }
    }

    @Test
    public void _make()
    {
        destPrint.prints
                  (
                            printDataGrid
                                      (
                                                "会员管理", "tb_member", "/destoon/member/listMember.com",
                                                1024, 800, true, true,
                                                new String[]
                                                          {
                                                                    "memberID", "memberName", "memberCompany",
                                                                    "memberGender", "memberGroup"
                                                          },
                                                new String[]
                                                          {
                                                                    "ID", "名称", "公司", "性别", "会员组"
                                                          },
                                                new Integer[]
                                                          {
                                                                    200, 300, 300, 200, 300
                                                          }
                                      )
                  );
    }
}

















