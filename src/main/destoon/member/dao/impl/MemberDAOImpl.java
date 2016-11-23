package member.dao.impl;

import core.DestoonUtils7;
import member.dao.MemberDAO;
import member.domain.Member;
import member.domain.MemberCompanyType;
import member.domain.MemberGender;
import member.domain.MemberGroup;
import member.domain.MemberPlace;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import qin.javaee7.core.exceptions.JavaEE7Exception;
import qin.javaee7.core.hibernate.dao.impl.JavaEE7DAOSupportImpl;

import java.util.List;

import static core.DestoonUtils7.destPrint;
import static core.DestoonUtils7.getTime;

/**
 * 会员数据访问层实现
 *
 * @author qinzhengying
 * @since 1.7 2016-11-16
 */
@Repository(value = "destoon_memberDAO7")
@SuppressWarnings("all")
public class MemberDAOImpl
          extends JavaEE7DAOSupportImpl<Member, Long>
          implements MemberDAO
{
    private static final long serialVersionUID = 3923267808109654201L;

    //region 获取配置文件路径
    @Override
    public String getLog4jLocation()
    {
        return DestoonUtils7.log4jPath;
    }
    //endregion

    //region 获取实体类

    @Override
    public Class<Member> getEntityClass()
    {
        return Member.class;
    }

    //endregion

    //region 实现登录功能

    /**
     * 会员登录功能
     *
     * @param member 会员实体类
     * @return 是否登录成功或在验证过程中失败将失败信息传到前台页面
     * @throws JavaEE7Exception 抛出大异常
     */
    @Override
    public String doMemberLogin(Member member) throws JavaEE7Exception
    {
        String result = "";

        //编写hql语句做判断
        String memberLoginName = member.getMemberLoginName();
        String memberLoginPassword = member.getMemberLoginPassword();
        String memberEmail = member.getMemberEmail();

        //language=hql
        String queryString = "from Member m where " +
                  "m.memberLoginName=:memberLoginName " +
                  "and m.memberLoginPassword=:memberLoginPassword " +
                  "and m.memberEmail=:memberEmail";
        String[] paramNames = new String[]{"memberLoginName", "memberLoginPassword", "memberEmail"};
        Object[] values = new Object[]{memberLoginName, memberLoginPassword, memberEmail};

        List searchList = findByNamedParam(queryString, paramNames, values);

        if (searchList.size() > 0)
        {
            result = str_success;
        }
        else
        {
            result = str_failed;
        }

        return result;
    }

    //endregion

    //region 恢复数据

    @Transactional
    @Override
    public void iniMember()
    {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try
        {
            //首先恢复会员地区数据
            iniMemberPlace(session);
            //会员组
            iniMemberGroup(session);
            //公司类型
            iniMemberCompanyType(session);
            //最后恢复会员数据
            iniMemberData(session);

            transaction.commit();
        }
        catch (Exception ex)
        {
            destPrint.prints("数据恢复失败!");
        }
    }

    //region 恢复会员数据
    private final void iniMemberData(Session session)
    {
        Member m1 = new Member();
        //由于数据一直在变化, 所以根据指定地区来寻找其主键
        //台湾地区
        Integer mpInteger1 = (Integer) session
                  .createQuery("select m.id from MemberPlace m where m.memberPlaceName = '台湾'")
                  .list()
                  .get(0);
        //获取地区
        MemberPlace mp1 = (MemberPlace) session.get(MemberPlace.class, mpInteger1);
        //会员组为管理员
        Short mgShort1 = (Short) session
                  .createQuery("select m.id from MemberGroup m where m.memberGroup = '管理员'")
                  .list()
                  .get(0);
        MemberGroup mg1 = (MemberGroup) session.get(MemberGroup.class, mgShort1);
        //公司为央企
        Short mccShort1 = (Short) session
                  .createQuery("select m.id from MemberCompanyType m where m.companyTypeName = '央企'")
                  .list()
                  .get(0);
        MemberCompanyType mct1 = (MemberCompanyType) session.get(MemberCompanyType.class, mccShort1);
        //会员组
        m1.setMemberGroup(mg1);
        //会员登录名
        m1.setMemberLoginName("tongange");
        //登录密码
        m1.setMemberLoginPassword("tongange");
        //重复输入密码
        m1.setMemberLoginSurePassword("tongange");
        //Email
        m1.setMemberEmail("tongange@tongange.com");
        //真实姓名
        m1.setMemberRealName("童安格");
        //性别
        m1.setMemberGender(MemberGender.BOY);
        //所在地区
        m1.setMemberPlace(mp1);
        //公司名称
        m1.setMemberCompanyName("上海宝丽金唱片公司");
        //公司类型
        m1.setMemberCompanyType(mct1);
        //主营行业
        m1.setMemberCompanyMainProf("出唱片和专辑");
        //主要经营范围
        m1.setMemberCompanyScopeOfBusiness("出唱片and专辑");
        //公司成立年份
        m1.setMemberCompanyYearOfStart(getTime(1970, 1, 1));
        //公司地址
        m1.setMemberCompanyAddress("台湾忠孝东路");
        //公司电话
        m1.setMemberCompanyTelephone("1309495855");
        //公司介绍
        m1.setMemberCompanyIntroduction
                  (
                            new StringBuilder()
                                      .append("宝丽金（PolyGram）是1999年以前世界上最著名、规模最大的唱片公司，")
                                      .append("亦是到目前为止世界上最悠久的唱片公司，曾经拥有Deutsche Grammophon（DG）")
                                      .append("、DECCA、飞利浦等跨国唱片企业，以拥有高知名度歌手、")
                                      .append("艺术家和高质量的音乐质量而闻名全球。1999年，美国环球唱片集团收购了宝丽金。").toString()
                  );

        mp1.getMemberSet().add(m1);
        mg1.getMemberSet().add(m1);
        mct1.getMemberSet().add(m1);

        //----------------------------------------------------------------------------------------------------------------------

        Member m2 = new Member();
        //由于数据一直在变化, 所以根据指定地区来寻找其主键
        Integer mpInteger2 = (Integer) session
                  .createQuery("select m.id from MemberPlace m where m.memberPlaceName = '上海'")
                  .list()
                  .get(0);
        //获取地区
        MemberPlace mp2 = (MemberPlace) session.get(MemberPlace.class, mpInteger2);
        //会员组为管理员
        Short mgShort2 = (Short) session
                  .createQuery("select m.id from MemberGroup m where m.memberGroup = '普通会员'")
                  .list()
                  .get(0);
        MemberGroup mg2 = (MemberGroup) session.get(MemberGroup.class, mgShort2);
        //公司为央企
        Short mccShort2 = (Short) session
                  .createQuery("select m.id from MemberCompanyType m where m.companyTypeName = '国企'")
                  .list()
                  .get(0);
        MemberCompanyType mct2 = (MemberCompanyType) session.get(MemberCompanyType.class, mccShort2);
        //会员组
        m2.setMemberGroup(mg2);
        //会员登录名
        m2.setMemberLoginName("qinzhengying");
        //登录密码
        m2.setMemberLoginPassword("qinzhengying");
        //重复输入密码
        m2.setMemberLoginSurePassword("qinzhengying");
        //Email
        m2.setMemberEmail("qinzhengying@qinzhengying.com");
        //真实姓名
        m2.setMemberRealName("秦始皇");
        //性别
        m2.setMemberGender(MemberGender.BOY);
        //所在地区
        m2.setMemberPlace(mp2);
        //公司名称
        m2.setMemberCompanyName("上海严致信息技术有限公司");
        //公司类型
        m2.setMemberCompanyType(mct2);
        //主营行业
        m2.setMemberCompanyMainProf("软件公司");
        //主要经营范围
        m2.setMemberCompanyScopeOfBusiness("开发校园网");
        //公司成立年份
        m2.setMemberCompanyYearOfStart(getTime(2011, 5, 2));
        //公司地址
        m2.setMemberCompanyAddress("上海黄兴公园");
        //公司电话
        m2.setMemberCompanyTelephone("13840595854");
        //公司介绍
        m2.setMemberCompanyIntroduction
                  (
                            new StringBuilder()
                                      .append("上海彦致信息技术有限公司成立于2012年10月，是一家专注于高校、职业院校和基础教育信息化领域内的咨询、规划、建设和服务的专业软件公司。公司本着“优质、高效、贴心”的服务精神，以专业的团队、规范的流程、丰富的经验服务于教育行业客户。\n")
                                      .append(" \n")
                                      .append("上海彦致信息技术有限公司专注于高校、职业院校和基础教育信息化领域内的咨询、规划、建设和服务。公司本着“优质、高效、贴心”的服务精神，以专业的团队、规范的流程、丰富的经验服务于教育行业客户。彦致重视每个学校的差异性特点，为不同学校提供个性化的高级定制信息化服务。针对高校、中职、基础教育提供差异化的信息化建设解决方案。在高校我们的解决方案涵盖了基础平台、业务管理系统、互动学习系统、资源库系统、学生服务系统等管理和教学领域。在高职和中职类院校，我们提供全校数字化校园一体化解决方案，在基础教育，提供基于云计算的公共信息服务。彦致拥有行业经验丰富的技术、管理和服务团队，在教育信息化领域以“合作共赢、共同发展、开放共享”的心态与学校共同发展，共同探索中国教育发展方向，共同为中国教育的改革和发展作出贡献。").toString()
                  );

        mp2.getMemberSet().add(m2);
        mg2.getMemberSet().add(m2);
        mct2.getMemberSet().add(m2);

        session.save(m1);
        session.save(m2);
        session.update(mp1);
        session.update(mp2);
        session.update(mg1);
        session.update(mg2);
        session.update(mct1);
        session.update(mct2);
    }
    //endregion

    //region 恢复会员地区数据

    /**
     * 恢复会员地区数据
     */
    private final void iniMemberPlace(Session session)
    {
        //region 不知名城市保存

        //region 广东省
        //广东省
        String[] _广东省 =
                  {
                            "广州", "潮州", "东莞", "佛山", "惠州", "清远", "汕头", "深圳", "顺德", "湛江", "肇庆",
                            "中山", "珠海", "江门", "阳江", "韶关", "茂名", "梅州", "汕尾", "河源", "揭阳", "云浮",
                            "开平", "台山", "普宁", "南沙", "龙川", "鹤山"
                  };
        //endregion
        //region 江苏省
        //江苏省
        String[] _江苏省 =
                  {
                            "南京", "常熟", "常州", "昆山", "连云港", "南通", "苏州", "太仓", "无锡", "徐州", "扬州", "镇江", "淮安",
                            "盐城", "泰州", "宿迁", "张家港", "江阴", "丹阳", "溧阳", "泰兴", "宜兴", "靖江", "句容", "如皋",
                            "扬中", "高邮", "启东", "盱眙", "通州", "金湖"
                  };
        //endregion
        //region 浙江省
        //浙江省
        String[] _浙江省 =
                  {
                            "杭州", "宁波", "温州", "绍兴", "金华", "台州", "湖州", "嘉兴", "衢州", "丽水", "舟山", "义乌", "海宁", "玉环县", "平湖", "永康", "东阳", "嘉善", "余姚", "慈溪", "乐清", "永嘉", "桐乡",
                            "瑞安", "温岭", "上虞", "诸暨", "宁海", "三门", "德清", "象山", "方家山", "龙泉"};
        //endregion
        //region 安徽省
        //安徽省
        String[] _安徽省 =
                  {
                            "合肥", "安庆", "蚌埠", "芜湖", "淮南", "马鞍山", "淮北", "铜陵", "黄山", "滁州", "阜阳", "宿州", "六安", "亳州", "池州", "宣城", "巢湖", "凤阳", "广德", "宿松"
                  };
        //endregion
        //region 福建省
        //福建省
        String[] _福建省 =
                  {
                            "福州", "泉州", "厦门", "漳州", "莆田", "三明", "南平", "龙岩", "宁德", "泉港区", "福安", "晋江"};
        //endregion
        //region 甘肃省
        //甘肃省
        String[] _甘肃省 =
                  {
                            "兰州", "嘉峪关", "酒泉", "金昌", "白银", "天水", "张掖", "武威", "定西", "陇南", "平凉", "庆阳", "临夏", "甘南"
                  };
        //endregion
        //region 广西
        //广西
        String[] _广西 =
                  {
                            "南宁", "北海", "桂林", "柳州", "玉林", "梧州", "崇左", "来宾", "防城港", "百色", "钦州", "贺州", "河池", "贵港"
                  };
        //endregion
        //region 贵州省
        //贵州省
        String[] _贵州省 =
                  {
                            "贵阳", "遵义", "六盘水", "安顺", "毕节", "铜仁", "黔西南", "黔东南", "黔南"
                  };
        //endregion
        //region 海南省
        //海南省
        String[] _海南省 =
                  {
                            "海口", "三亚", "三沙", "文昌", "琼海", "万宁", "儋州", "东方", "五指山", "定安", "屯昌", "澄迈", "临高", "琼中", "保亭", "白沙", "昌江", "乐东", "陵水"
                  };
        //endregion
        //region 河北省
        //河北省
        String[] _河北省 =
                  {
                            "石家庄", "保定", "承德", "邯郸", "廊坊", "秦皇岛", "唐山", "张家口", "邢台", "沧州", "衡水", "燕郊", "固安", "遵化", "香河", "三河"
                  };
        //endregion
        //region 河南省
        //河南省
        String[] _河南省 =
                  {
                            "郑州", "开封", "洛阳", "商丘", "安阳", "平顶山", "新乡", "焦作", "濮阳", "许昌", "漯河", "三门峡", "鹤壁", "周口", "驻马店", "南阳", "信阳", "济源", "西平", "长葛"
                  };
        //endregion
        //region 黑龙江省
        //黑龙江省
        String[] _黑龙江省 =
                  {
                            "哈尔滨", "大庆", "佳木斯", "牡丹江", "齐齐哈尔", "鸡西", "鹤岗", "双鸭山", "伊春", "七台河", "黑河", "绥化", "大兴安岭", "安达", "双城", "尚志", "绥芬河", "肇东"
                  };
        //endregion
        //region 湖北省
        //湖北省
        String[] _湖北省 =
                  {
                            "武汉", "十堰", "襄阳", "宜昌", "潜江", "荆门", "荆州", "黄石", "鄂州", "黄冈", "孝感", "咸宁", "随州", "仙桃", "天门", "神农架", "恩施", "公安", "武穴", "宜城"
                  };
        //endregion
        //region 湖南省
        //湖南省
        String[] _湖南省 =
                  {
                            "长沙", "湘潭", "株洲", "常德", "衡阳", "益阳", "郴州", "岳阳", "邵阳", "张家界", "娄底", "永州", "怀化", "湘西"
                  };
        //endregion
        //region 吉林省
        //吉林省
        String[] _吉林省 =
                  {
                            "长春", "吉林市", "四平", "辽源", "通化", "白山", "松原", "白城", "延吉", "延边", "公主岭"
                  };
        //endregion
        //region 江西省
        //江西省
        String[] _江西省 =
                  {
                            "南昌", "九江", "赣州", "宜春", "吉安", "上饶", "抚州", "景德镇", "萍乡", "新余", "鹰潭"
                  };
        //endregion
        //region 辽宁省
        //辽宁省
        String[] _辽宁省 =
                  {
                            "沈阳", "鞍山", "大连", "葫芦岛", "抚顺", "本溪", "丹东", "锦州", "营口", "阜新", "辽阳", "盘锦", "铁岭", "朝阳", "兴城", "海城", "昌图", "开原"
                  };
        //endregion
        //region 内蒙古
        //内蒙古
        String[] _内蒙古 =
                  {
                            "呼和浩特", "包头", "赤峰", "鄂尔多斯", "乌海", "通辽", "呼伦贝尔", "巴彦淖尔", "乌兰察布", "兴安盟", "锡林郭勒盟", "阿拉善盟", "乌审旗", "满洲里"
                  };
        //endregion
        //region 宁夏
        //宁夏
        String[] _宁夏 =
                  {
                            "银川", "石嘴山", "吴忠", "固原", "中卫"
                  };
        //endregion
        //region 青海省
        //青海省
        String[] _青海省 =
                  {
                            "西宁", "海东", "海西", "海北", "黄南", "海南", "果洛", "玉树"
                  };
        //endregion
        //region 山东省
        //山东省
        String[] _山东省 =
                  {
                            "济南", "德州", "东营", "济宁", "临沂", "青岛", "日照", "泰安", "威海", "潍坊", "烟台", "淄博", "枣庄", "滨州", "聊城", "菏泽", "莱芜", "荣成", "黄岛", "乳山", "城阳", "即墨", "肥城", "兖州", "海阳",
                            "胶州", "胶南", "平度", "莱西"
                  };
        //endregion
        //region 山西省
        //山西省
        String[] _山西省 =
                  {
                            "太原", "大同", "临汾", "运城", "长治", "阳泉", "晋城", "朔州", "晋中", "忻州", "吕梁", "永济", "和顺"
                  };
        //endregion
        //region 陕西省
        //陕西省
        String[] _陕西省 =
                  {
                            "西安", "宝鸡", "咸阳", "铜川", "渭南", "汉中", "安康", "商洛", "延安", "榆林", "杨凌", "兴平"
                  };
        //endregion
        //region 四川省
        //四川省
        String[] _四川省 =
                  {
                            "成都", "乐山", "泸州", "绵阳", "内江", "宜宾", "自贡", "攀枝花", "德阳", "广元", "遂宁", "南充", "眉山", "广安", "达州", "雅安", "巴中", "资阳", "西昌", "甘孜", "阿坝", "凉山", "峨眉",
                            "简阳"
                  };
        //endregion
        //region 西藏
        //西藏
        String[] _西藏 =
                  {
                            "拉萨", "日喀则", "林芝", "山南", "昌都", "那曲", "阿里"
                  };
        //endregion
        //region 新疆
        //新疆
        String[] _新疆 =
                  {
                            "乌鲁木齐", "喀什", "克拉玛依", "伊犁", "阿克苏", "哈密", "石河子", "阿拉尔", "五家渠", "图木舒克", "昌吉", "阿勒泰", "吐鲁番", "塔城", "和田", "巴音郭楞", "博尔塔拉", "奎屯市", "乌苏", "克州"
                  };
        //endregion
        //region 云南省
        //云南省
        String[] _云南省 =
                  {
                            "昆明", "大理", "丽江", "玉溪", "曲靖", "保山", "昭通", "普洱", "临沧", "红河", "文山", "西双版纳", "德宏", "楚雄", "怒江", "迪庆", "思茅"
                  };
        //endregion

        for (int i = 0; i < _广东省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_广东省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _江苏省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_江苏省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _浙江省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_浙江省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _安徽省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_安徽省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _福建省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_福建省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _甘肃省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_甘肃省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _广西.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_广西[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _贵州省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_贵州省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _海南省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_海南省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _河北省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_河北省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _河南省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_河南省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _黑龙江省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_黑龙江省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _湖北省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_湖北省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _湖南省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_湖南省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _吉林省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_吉林省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _江西省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_江西省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _辽宁省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_辽宁省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _内蒙古.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_内蒙古[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _宁夏.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_宁夏[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _青海省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_青海省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _山东省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_山东省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _山西省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_山西省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _陕西省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_陕西省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _四川省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_四川省[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _西藏.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_西藏[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _新疆.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_新疆[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _云南省.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_云南省[i]);
            session.save(memberPlace);
        }
        //endregion

        //region 知名城市
        String[] _北京 =
                  {
                            "东城区", "西城区", "朝阳区", "海淀区", "石景山", "门头沟", "丰台区", "房山区", "大兴区", "通州区", "顺义区", "平谷区", "昌平区", "怀柔区", "延庆县", "密云县"
                  };
        String[] _上海 =
                  {
                            "浦东新区", "徐汇区", "长宁区", "普陀区", "闸北区", "虹口区", "杨浦区", "黄浦区", "静安区", "宝山区", "闵行区", "嘉定区", "金山区", "松江区", "青浦区", "奉贤区", "崇明县"
                  };
        String[] _广州 =
                  {

                            "白云区", "天河区", "越秀区", "海珠区", "黄埔区", "荔湾区", "番禺区", "花都区", "萝岗区", "南沙区", "从化区", "增城区"
                  };
        String[] _深圳 =
                  {

                            "罗湖区", "福田区", "南山区", "宝安区", "龙岗区", "盐田区", "光明新区", "坪山新区", "大鹏新区", "龙华新区"
                  };
        String[] _天津 =
                  {
                            "和平区", "河东区", "河西区", "南开区", "河北区", "红桥区", "塘沽区", "汉沽区", "大港区", "东丽区", "西青区", "津南区", "北辰区", "武清区", "宝坻区", "宁河县", "静海县", "蓟　县", "开发区", "滨海区"
                  };
        String[] _苏州 =
                  {
                            "金阊区", "沧浪区", "平江区", "工业园", "高新区", "吴中区", "相城区", "张家港", "常熟市", "太仓市", "昆山市", "吴江市", "虎丘区", "玉山镇", "巴城镇", "周市镇", "陆家镇", "花桥镇", "淀山湖", "张浦镇", "周庄镇", "千灯镇", "锦溪镇", "开发区",
                  };
        String[] _重庆 =
                  {
                            "渝中区", "江北区", "南岸区", "沙坪坝", "九龙坡", "大渡口", "北碚区", "巴南区", "渝北区", "永川区", "涪陵区", "合川区", "江津区", "长寿区", "南川区", "万州区", "黔江区", "綦江区", "潼南县", "铜梁区", "大足区", "荣昌县", "璧山区", "垫江县", "武隆县", "丰都县", "城口县", "梁平县", "开县", "巫溪县",
                            "巫山县", "奉节县", "云阳县", "忠县", "石柱", "彭水县", "酉阳县", "石柱县", "秀山县"
                  };
        String[] _南京 =
                  {
                            "玄武区", "白下区", "秦淮区", "建邺区", "鼓楼区", "下关区", "浦口区", "六合区", "栖霞区", "雨花台", "江宁区", "溧水县", "高淳县", "大厂区"
                  };
        String[] _杭州 =
                  {
                            "海口", "三亚", "三沙", "文昌", "琼海", "万宁", "儋州", "东方", "五指山", "定安", "屯昌", "澄迈", "临高", "琼中", "保亭", "白沙", "昌江", "乐东", "陵水"
                  };
        String[] _大连 =
                  {
                            "西岗区", "中山区", "沙河口", "甘井子", "旅顺口", "金州区", "瓦房店", "普兰店", "庄河市", "普湾区", "长海县", "新区", "开发区"
                  };
        String[] _成都 =
                  {
                            "成华区", "武侯区", "青羊区", "锦江区", "金牛区", "龙泉驿", "青白江", "新都区", "双流县", "郫县", "温江区", "大邑县", "金堂县", "蒲江县", "新津县", "温江区", "高新区", "高新西", "都江堰", "彭州市", "邛崃市", "崇州市"
                  };
        String[] _武汉 =
                  {
                            "江岸区", "江汉区", "硚口区", "汉阳区", "武昌区", "青山区", "洪山区", "蔡甸区", "江夏区", "黄陂区", "新洲区", "东西湖", "汉南区", "开发区"
                  };

        for (int i = 0; i < _北京.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_北京[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _上海.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_上海[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _广州.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_广州[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _深圳.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_深圳[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _天津.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_天津[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _苏州.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_苏州[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _重庆.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_重庆[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _南京.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_南京[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _杭州.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_杭州[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _大连.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_大连[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _成都.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_成都[i]);
            session.save(memberPlace);
        }
        for (int i = 0; i < _武汉.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(_武汉[i]);
            session.save(memberPlace);
        }
        //endregion

        //region 城市名称
        String[] cityNames =
                  {
                            "台湾", "北京", "上海", "广州", "深圳", "天津", "苏州", "重庆", "南京", "杭州", "大连", "成都", "武汉", "广东省", "江苏省", "浙江省", "安徽省", "福建省", "甘肃省", "广西", "贵州省", "海南省", "河北省", "河南省", "黑龙江省", "湖北省", "湖南省", "吉林省", "江西省",
                            "辽宁省", "内蒙古", "宁夏", "青海省", "山东省", "山西省", "陕西省", "四川省", "西藏", "新疆", "云南省"
                  };

        for (int i = 0; i < cityNames.length; i++)
        {
            MemberPlace memberPlace = new MemberPlace(cityNames[i]);
            session.save(memberPlace);
        }
        //endregion
    }
    //endregion

    //region 会员组保存

    /**
     * 会员组保存
     *
     * @param session <code>Hibernate Session</code>缓存
     */
    private final void iniMemberGroup(Session session)
    {
        String[] memberGroupNames =
                  {
                            "普通会员", "VIP会员", "管理员"
                  };

        for (int i = 0; i < memberGroupNames.length; i++)
        {
            MemberGroup memberGroup = new MemberGroup(memberGroupNames[i]);
            session.save(memberGroup);
        }
    }
    //endregion

    //region 公司类型

    /**
     * 公司类型
     *
     * @param session
     */
    private final void iniMemberCompanyType(Session session)
    {
        String[] memberCompanytypes =
                  {
                            "私有企业", "国企", "央企", "股份制企业"
                  };

        for (int i = 0; i < memberCompanytypes.length; i++)
        {
            MemberCompanyType memberCompanyType = new MemberCompanyType(memberCompanytypes[i]);
            session.save(memberCompanyType);
        }
    }
    //endregion

    //endregion

    //region 根据登录名查找会员

    @Override
    public Member findMember(String loginName)
    {
        Member member = (Member) getSessionFactory()
                  .openSession()
                  .createQuery
                            (
                                      new StringBuilder()
                                                .append("from Member m where m.memberLoginName='")
                                                .append(loginName)
                                                .append("'").toString()
                            )
                  .list()
                  .get(0);

        return member;
    }

    //endregion
}





















