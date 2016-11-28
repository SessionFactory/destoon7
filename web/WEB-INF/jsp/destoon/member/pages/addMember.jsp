<%@ page import="member.domain.MemberGroup" %>
<%@ page import="member.domain.MemberPlace" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--

            页面要素
            ---------------------
会员添加:
            会员组*---------------------combo
            会员登录名*-----------------text
            昵称-----------------------text
            登录密码*------------------text
            重复输入密码*--------------text
            email*--------------------text
            真实姓名*-----------------text
            性别*--------------------combo
            所在地区*-----------------combobox
            部门---------------------text
            职位---------------------text
            手机号码-----------------text
            qq---------------------text
公司资料:
            公司名称*---------------------text
            公司类型*---------------------combobox
            主营行业*---------------------text
            主要经营范围*-----------------text
            经营模式---------------------text
            公司规模---------------------text
            注册资本---------------------text
            公司成立年份*----------------datetimebox
            公司地址*---------------------text
            邮政编码---------------------text
            公司电话*---------------------text
            公司传真---------------------text
            公司email---------------------text
            公司网址销售的产品------------text
            采购的产品---------------------text
            公司介绍*---------------------text
--%>

<style type="text/css">
</style>

<body id="body_addMember">
<div id="aa" class="easyui-accordion" style="width:100%;height:100%;">
    <div title="会员添加" data-options="iconCls:'icon-save'" style="padding:10px;">

        <%
            //事先定义一些应用类型控件html语句
            /** 会员组 */
            StringBuilder memberGroup = new StringBuilder();
            /** 所在地区 */
            StringBuilder memberPlace = new StringBuilder();

            /** 定义spring变量 */
            SessionFactory hbSessionFactory = (SessionFactory) new
                    ClassPathXmlApplicationContext("applicationContext.xml")
                    .getBean("sessionFactory");
            Session hbSession = hbSessionFactory.openSession();

            List<MemberGroup> memberGroupList = hbSession
                    .createQuery("from MemberGroup ")
                    .list();

            int i = 0;

            for (Iterator<MemberGroup> it = memberGroupList.iterator(); it.hasNext(); i++)
            {
                MemberGroup mg = it.next();
                //language=html
                memberGroup.append("<option value='" + i + "'>" + mg.getMemberGroup() + "</option>");
            }

            i = 0;

            List<MemberPlace> memberPlaceList = hbSession
                    .createQuery("from MemberPlace ")
                    .list();

            for (Iterator<MemberPlace> it = memberPlaceList.iterator(); it.hasNext(); i++)
            {
                MemberPlace mp = it.next();
                //language=html
                memberGroup.append("<option value='" + i + "'>" + mp.getMemberPlaceName() + "</option>");
            }
        %>



    </div>

    <div title="公司资料" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">
    </div>
</div>

</body>













