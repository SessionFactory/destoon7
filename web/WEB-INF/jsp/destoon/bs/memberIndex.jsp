<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- include -->
<%@ page import="member.domain.Member" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<!-- include -->

<!DOCTYPE html>

<html>
<head>
    <jsp:include page="/include/include_bootstrap.jsp"></jsp:include>
</head>

<style type="text/css">
</style>

<div class="container" id="_container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                    <a class="navbar-brand" href="#">Brand</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">Link</a>
                        </li>
                        <li>
                            <a href="#">Link</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">Action</a>
                                </li>
                                <li>
                                    <a href="#">Another action</a>
                                </li>
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">Separated link</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">One more separated link</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control"/>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">Link</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">Action</a>
                                </li>
                                <li>
                                    <a href="#">Another action</a>
                                </li>
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">Separated link</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>

    <center>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="carousel slide" id="carousel-342663">
                    <ol class="carousel-indicators">
                        <li class="active" data-slide-to="0" data-target="#carousel-342663">
                        </li>
                        <li data-slide-to="1" data-target="#carousel-342663">
                        </li>
                        <li data-slide-to="2" data-target="#carousel-342663">
                        </li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="item active">
                            <img alt="" src="/images/1.jpg"/>
                        </div>
                        <div class="item">
                            <img alt="" src="/images/3.jpg"/>
                        </div>
                        <div class="item">
                            <img alt="" src="/images/2.jpg"/>
                        </div>
                    </div>
                    <a class="left carousel-control" href="#carousel-342663" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-342663" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                </div>
            </div>
        </div>
    </center>

    <br>

    <div class="row clearfix">
        <!-- 列表组 -->
        <div class="col-md-6 column" style="width: 20%;">
            <div class="list-group">
                <a href="#" class="list-group-item active">导航栏</a>
                <div class="list-group-item">
                    <a href="" style="color: darkblue;"> 增加会员信息</a>
                </div>
                <div class="list-group-item">
                    <a href="" style="color: mediumblue;">删除会员信息</a>
                </div>
                <div class="list-group-item">
                    <a href="" style="color: firebrick;">修改会员信息</a>
                </div>
                <div class="list-group-item">
                    <a href="" style="color: #ac2925;">查询会员信息</a>
                </div>
            </div>
        </div>
        <!-- 列表组end -->
        <div class="col-md-6 column" style="width: 80%;">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        会员精简信息
                    </h3>
                </div>
                <div class="panel-body">
                    <!-- 表格中显示的元素 -->

                    <!--
                            会员ID, 会员名称, 公司, 性别, 会员组
                    -->
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>会员ID</th>
                            <th>会员名称</th>
                            <th>公司</th>
                            <th>性别</th>
                            <th>会员组</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <!-- 显示信息的第一种方法:直接输入java代码 -->
                        <%
                            /** Session工厂 */
                            SessionFactory hbSessionFactory = (SessionFactory) new
                                    ClassPathXmlApplicationContext("applicationContext.xml")
                                    .getBean("sessionFactory");
                            /** 开启Session */
                            Session hbSession = hbSessionFactory.openSession();

                            /** 查询会员表所有信息 */
                            List<Member> memberList = hbSession
                                    .createQuery("from Member ")
                                    .list();

                            StringBuilder sb = new StringBuilder();

                            //迭代
                            for (Iterator<Member> it = memberList.iterator(); it.hasNext(); )
                            {
                                Member member = it.next();

                                //start
                                sb.append("<tr class=\"active\">");

                                //会员ID
                                sb.append("    <td style='color: #0052A3;'>").append(member.getId()).append("</td>");
                                //会员名称
                                sb.append("    <td style='color: mediumblue;'>").append(member.getMemberName()).append("</td>");
                                //公司
                                sb.append("    <td style='color: #c7254e;'>").append(member.getMemberCompanyName()).append("</td>");
                                //性别
                                sb.append("    <td style='color: tomato;'>").append(member.getMemberGender()).append("</td>");
                                //会员组
                                sb.append("    <td style='color: royalblue;'>").append(member.getMemberGroup().getMemberGroup()).append("</td>");
                                //操作
                                sb.append("    <td style='color: magenta;'>").append("相关操作").append("</td>");
                                //结尾
                                sb.append("</tr>");
                            }

                            out.println(sb.toString());
                        %>
                        <!-- 显示信息的第一种方法:直接输入java代码 -->
                        </tbody>
                    </table>

                    <!-- 表格中显示的元素 -->
                </div>
            </div>
        </div>
    </div>
</div>

<br><br><br>
<br><br><br>
<br><br><br>
<br><br><br>
<br><br><br>

</html>