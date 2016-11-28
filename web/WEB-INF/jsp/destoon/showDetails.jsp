<%@ page import="member.domain.Member" %>
<%@ page import="member.domain.MemberGender" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <jsp:include page="/include/include_bootstrap.jsp"></jsp:include>
</head>

<style type="text/css">
    #_body
    {
        font-family: 微软雅黑;
    }

    #_td
    {
        color: darkred;
        font-size: 30px;
        width: 200px;
        font-weight: bold;
    }
</style>

<%
    Member member = (Member) request.getAttribute("member");
    //id                           | bigint(20)    | NO   | PRI | 编号
    //memberLoginName              | varchar(255)  | NO   |     | 登录名
    //memberName                   | varchar(255)  | YES  |     | 姓名
    //memberEmail                  | varchar(255)  | NO   |     | 邮箱
    //memberRealName               | varchar(255)  | NO   |     | 真实姓名
    //memberGender                 | varchar(255)  | NO   |     | 性别
    //memberDepartment             | varchar(255)  | YES  |     | 部门
    //memberQQ                     | bigint(20)    | YES  |     | qq号

    //字段不能显示为NULL
    Long id = member.getId();
    String memberLoginName = member.getMemberLoginName();
    Object memberName = member.getMemberName();
    if (memberName == null) memberName = memberLoginName;
    String memberEmail = member.getMemberEmail();
    String memberRealName = member.getMemberRealName();
    String memberGender = "";
    MemberGender gender = member.getMemberGender();
    if (gender.equals(gender.BOY))
    {
        memberGender = "男";
    }
    else
    {
        memberGender = "女";
    }
    Object memberDepartment = member.getMemberDepartment();
    if (memberDepartment == null) memberDepartment = memberLoginName + "所在部门为空!";
    Object memberQQ = member.getMemberQQ();
    if (memberQQ == null) memberQQ = memberLoginName + "没有注册过qq号!";
%>

<body style="width: 100%; height: 100%;" id="_body">
<br><br>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        会员基本资料
                    </h3>
                </div>
                <div class="panel-body">
                </div>
            </div>
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        会员公司资料
                    </h3>
                </div>
                <div class="panel-body">
                    Panel content
                </div>
                <div class="panel-footer">
                    Panel footer
                </div>
            </div>
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        会员其他关联资料
                    </h3>
                </div>
                <div class="panel-body">
                    Panel content
                </div>
                <div class="panel-footer">
                    Panel footer
                </div>
            </div>
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        会员剩余资料
                    </h3>
                </div>
                <div class="panel-body">
                    Panel content
                </div>
                <div class="panel-footer">
                    Panel footer
                </div>
            </div>
        </div>
    </div>
</div>
</body>
