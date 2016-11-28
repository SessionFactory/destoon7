<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <script type="text/javascript" src="<c:url value="/jsLib/jQuery/jquery-1.11.3/jquery.js"/> "></script>
</head>

<!-- 定义基本变量 -->
<script type="text/javascript">
    var destoonBasePath = "/destoon/";
</script>

<%-- 模板代码 --%>

<%--
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>

<%
    /** Session工厂 */
    SessionFactory hbSessionFactory = (SessionFactory) new
            ClassPathXmlApplicationContext("applicationContext.xml")
            .getBean("sessionFactory");
    /** 开启Session */
    Session hbSession = hbSessionFactory.openSession();

%>
--%>
