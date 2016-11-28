<%@ page import="member.domain.MemberGroup" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
<style type="text/css">
    #body_addMember
    {
        font-family: 微软雅黑;
        font-size: 16px;
    }

    #star
    {
        font-size: 16px;
        color: red;
        font-weight: bold;
    }

    #_td
    {
        width: 180px;
    }
</style>--%>

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

<body id="body_addMember">
<div id="aa" class="easyui-accordion" style="width:100%;height:100%;">
    <div title="会员添加" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
        <table width="100%" border="1" bordercolor="#3366FF">

            <!-- 实现下拉框数据的第一种方法 -->
            <%
                //将名字加上前缀hibernate这样将会与jsp里原有的变量进行区分
                SessionFactory hibernateSessionFactory = (SessionFactory) new
                        ClassPathXmlApplicationContext("applicationContext.xml")
                        .getBean("sessionFactory");
                Session hibernateSession = hibernateSessionFactory.openSession();

                //查询所有会员组
                List<MemberGroup> memberGroupList = hibernateSession
                        .createQuery("from MemberGroup ")
                        .list();
            %>
            <!-- 实现下拉框数据的第一种方法 -->

            <tr>
                <td id="_td">会员组<font id="star">*</font></td>
                <td>
                    <select id="cc" class="easyui-combobox" style="width:300px;">
                        <%
                            int i = 0;

                            for (Iterator<MemberGroup> it = memberGroupList.iterator(); it.hasNext(); i++)
                            {
                                MemberGroup memberGroup = it.next();

                                //language=html
                                out.println
                                        (
                                                new StringBuilder()
                                                        .append("<option value='")
                                                        .append(i)
                                                        .append("'>")
                                                        .append(memberGroup.getMemberGroup())
                                                        .append("</option>").toString()
                                        );
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td id="_td">会员登录名<font id="star">*</font></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="_td">昵称</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="_td">登录密码<font id="star">*</font></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="_td">重复输入密码<font id="star">*</font></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="_td">email<font id="star">*</font></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="_td">真实姓名<font id="star">*</font></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="_td">性别<font id="star">*</font></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="_td">所在地区<font id="star">*</font></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="_td">部门</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="_td">职位</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="_td">手机号码</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="_td">qq</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </div>

    <div title="公司资料" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">

    </div>
</div>

</body>













