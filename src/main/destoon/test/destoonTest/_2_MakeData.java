package destoonTest;

import member.domain.Member;
import member.domain.MemberCompanyType;
import member.domain.MemberGender;
import member.domain.MemberGroup;
import member.domain.MemberPlace;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static core.DestoonUtils7.getTime;

@SuppressWarnings("all")
public class _2_MakeData
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
        //公司类型
        MemberCompanyType m1 = new MemberCompanyType("央企");
        MemberCompanyType m2 = new MemberCompanyType("政府企业");
        MemberCompanyType m3 = new MemberCompanyType("股份制企业");
        MemberCompanyType m4 = new MemberCompanyType("国企");
        MemberCompanyType m5 = new MemberCompanyType("私人企业");
        //会员组
        MemberGroup m6 = new MemberGroup("企业会员");
        MemberGroup m7 = new MemberGroup("个人会员");
        //会员所在地
        String[] places =
                  {
                            "广东省", "江苏省", "浙江省", "安徽省", "福建省", "甘肃省",
                            "广西", "贵州省", "海南省", "河北省", "河南省", "黑龙江省",
                            "湖北省", "湖南省", "吉林省", "江西省", "辽宁省", "内蒙古",
                            "宁夏", "青海省", "山东省", "山西省", "陕西省", "四川省",
                            "西藏", "新疆", "云南省", "台湾", "上海"
                  };

        session.save(m1);
        session.save(m2);
        session.save(m3);
        session.save(m4);
        session.save(m5);
        session.save(m6);
        session.save(m7);

        for (int i = 0; i < places.length; i++)
        {
            MemberPlace m8 = new MemberPlace(places[i]);
            session.save(m8);
        }

        session.beginTransaction().commit();
    }

    @Test
    public void save2()
    {
        //会员基本信息:[管理员]
        Member member = new Member();
        //会员组*
        //企业会员
        MemberGroup memberGroup = (MemberGroup) session.get(MemberGroup.class, new Short("1"));
        member.setMemberGroup(memberGroup);
        //会员登录名*
        member.setMemberLoginName("tongange");
        //昵称
        member.setMemberName("童安格");
        //登录密码*
        member.setMemberLoginPassword("tongange");
        //重复输入密码*
        member.setMemberLoginSurePassword("tongange");
        //Email*
        member.setMemberEmail("tongange@tongange.com");
        //真实姓名*
        member.setMemberRealName("童安格");
        //性别*
        member.setMemberGender(MemberGender.BOY);
        //所在地区*
        //29, 台湾
        MemberPlace memberPlace = (MemberPlace) session.get(MemberPlace.class, new Integer(29));
        member.setMemberPlace(memberPlace);
        //部门
        member.setMemberDepartment("唱歌部");
        //qq
        member.setMemberQQ(937184305l);
        //公司名称*
        member.setMemberCompanyName("上海宝丽金唱片有限公司");
        //公司类型*
        //1. 央企
        MemberCompanyType memberCompanyType = (MemberCompanyType) session.get(MemberCompanyType.class, new Short("1"));
        member.setMemberCompanyType(memberCompanyType);
        //主营行业*
        member.setMemberCompanyMainProf("唱片公司");
        //主要经营范围*
        member.setMemberCompanyScopeOfBusiness("卖唱片");
        //经营模式
        //公司规模
        member.setMemberCompanySize("10000人");
        //公司成立年份*
        member.setMemberCompanyYearOfStart(getTime(1980, 1, 1));
        //公司地址*
        member.setMemberCompanyAddress("台湾忠孝东路");
        //邮政编码
        member.setMemberCompanyZipCode(200445l);
        //公司电话*
        member.setMemberCompanyTelephone("021-13094834049");
        //公司传真
        member.setMemberCompanyFax("021-");
        //公司email
        member.setMemberEmail("tongange@tongange.com");
        //公司网址
        member.setMemberCompanyNetWork("http://www.tongange.com");
        //销售的产品
        //采购的产品
        //公司介绍*
        member.setMemberCompanyIntroduction
                  (
                            new StringBuilder()
                                      .append("1972年，Deutsche GrammophonGesellschaft(DGG)与Philips Phonograhische Industry(PPI)宣告合并")
                                      .append("，取名为“Poly－GramInternational”(宝丽金国际有限公司)，")
                                      .append("即“Polydor”的“poly”与“Phonogram”的“Gram”合成，总部设在英国伦敦。")
                                      .append("至此，宝丽金公司正式成立。\n")
                                      .append("两大公司合并的宝丽金集团于70年代协助飞利浦创造了卡带，")
                                      .append("80年代又创造了CD激光唱片，在业务上有了飞速的发展，并且将英国迪卡(Decca)公司并入该集团。")
                                      .append("迪卡唱片公司创建于1929年，但是早在1914年，一家留声机公司就以“迪卡”命名，")
                                      .append("后来这家公司扩展为迪卡唱片公司。至二战前，迪卡公司不仅兼并了一些公司，")
                                      .append("并且拥有了一批优秀的录音师，其中包括广大爱乐者们所熟悉的威尔金森(KennethWilkinson)。")
                                      .append("由于迪卡公司不断研制开发并推出新的录音技术，使其在录音制作方面始终处于世界前列。")
                                      .append("如“全频段录音”(ffrr)、“全频段立体声”(ffss)等。1957年，迪卡公司还取得了“Argo”商标，")
                                      .append("专门出版古典唱片。").toString()
                  );
        //会员资料是否完整
        member.setMemberIsCompleted(true);

        memberGroup.getMemberSet().add(member);
        memberCompanyType.getMemberSet().add(member);
        memberPlace.getMemberSet().add(member);

        session.save(member);

        session.update(memberGroup);
        session.update(memberCompanyType);
        session.update(memberPlace);

        session.beginTransaction().commit();
    }

    @Test
    public void deleteData()
    {
        Member member = (Member) session.get(Member.class, new Long("1"));
        session.delete(member);
        session.beginTransaction().commit();
    }
}

















