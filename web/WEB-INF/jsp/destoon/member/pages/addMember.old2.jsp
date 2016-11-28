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
        font-size: 20px;
        font-weight: bold;
        color: #101010;
    }

    .form-control
    {
        display: block;
        width: 80%;
        height: 80%;
        padding: 6px 12px;
        font-size: 14px;
        line-height: 1.42857143;
        color: #555;
        background-color: #fff;
        background-image: none;
        border: 1px solid #ccc;
        border-radius: 4px;
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
        -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
        -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
        transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
    }
</style>

<body id="body_addMember">
<div id="aa" class="easyui-accordion" style="width:100%;height:100%;">
    <div title="会员添加" data-options="iconCls:'icon-save'" style="padding:10px;">
        <table width="100%" border="1" bordercolor="#747474">

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

                //查询所有会员地区
                List<MemberPlace> memberPlaceList = hibernateSession
                        .createQuery("from MemberPlace ")
                        .list();
            %>
            <!-- 实现下拉框数据的第一种方法 -->

            <tr>
                <td id="_td">会员组<font id="star">*</font></td>
                <td>
                    <select id="memberGroup2" class="easyui-combobox" style="width:300px;">
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
                <td>
                    <input type="text" id="memberLoginName2" placeholder="会员登录名" class="form-control">
                </td>
            </tr>
            <tr>
                <td id="_td">昵称</td>
                <td>
                    <input type="text" id="memberNC2" placeholder="会员昵称" class="form-control">
                </td>
            </tr>
            <tr>
                <td id="_td">登录密码<font id="star">*</font></td>
                <td>
                    <input type="password" id="memberLoginPassword2" placeholder="会员登录密码" class="form-control">
                </td>
            </tr>
            <tr>
                <td id="_td">重复输入密码<font id="star">*</font></td>
                <td>
                    <input type="password" id="memberLoginSurePassword2" placeholder="重复输入密码" class="form-control">
                </td>
            </tr>
            <tr>
                <td id="_td">email<font id="star">*</font></td>
                <td>
                    <input type="text" id="memberEmail2" placeholder="会员邮箱" class="form-control">
                </td>
            </tr>
            <tr>
                <td id="_td">真实姓名<font id="star">*</font></td>
                <td>
                    <input type="text" id="memberRealName2" placeholder="会员真实姓名" class="form-control">
                </td>
            </tr>
            <tr>
                <td id="_td">性别<font id="star">*</font></td>
                <td>
                    <select id="memberGender2" class="easyui-combobox" style="width:200px;">
                        <option value="">男</option>
                        <option>女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td id="_td">所在地区<font id="star">*</font></td>
                <td>
                    <select id="memberPlace2" class="easyui-combobox" style="width:300px;">
                <%
                    int j = 0;

                    for (Iterator<MemberPlace> mIt = memberPlaceList.iterator(); mIt.hasNext(); j++)
                    {
                        MemberPlace memberPlace = mIt.next();

                        //language=html
                        out.println
                                (
                                        new StringBuilder()
                                                .append("<option value='")
                                                .append(j)
                                                .append("'>")
                                                .append(memberPlace.getMemberPlaceName())
                                                .append("</option>").toString()
                                );
                    }
                %>
                </select>
                </td>
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













