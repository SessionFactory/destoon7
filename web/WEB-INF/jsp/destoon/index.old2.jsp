<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <jsp:include page="/include/include_easyui15.jsp"></jsp:include>
    <script type="text/javascript" src="<c:url value="/WEB-INF/jsp/destoon/member/js/member.index.js"/> "></script>
    <link rel="stylesheet" href="<c:url value="/WEB-INF/jsp/destoon/member/css/addMember.css"/> ">
</head>

<%--<script type="text/javascript">
    $(function ()
        {
            //region 初始化会员表格
            $('#tb_memberDetails').datagrid
            (
                {
                    toolbar: '#toolbar_member',
                    title: '会员管理',
                    rownumbers: true,
                    width: 1500,
                    height: 200,
                    pagination: true,
                    columns://
                        [
                            [
                                {field: 'memberID', title: 'ID', width: 200, align: 'center'},
                                {field: 'memberName', title: '名称', width: 300, align: 'center'},
                                {field: 'memberCompany', title: '公司', width: 200, align: 'center'},
                                {field: 'memberGender', title: '性别', width: 200, align: 'center'},
                                {field: 'memberGroup', title: '会员组', width: 300, align: 'center'}
                            ]
                        ],
                    //单选
                    singleSelect: true
                }
            );
            //endregion
        }
    );

    //region 初始化会员信息表格
    /** 初始化会员信息表格 */
    function iniMemberTable()
    {
        $('#tb_memberDetails').datagrid
        (
            {
                url: '/destoon/member/listMember.com'
            }
        );
    }
    //endregion

    function iniMemberData()
    {
        $.ajax
        (
            {
                url: "/destoon/member/iniMemberData.com",
                method: 'POST',
                success: function (msg)
                {
                    alert("数据恢复成功!");
                }
            }
        );
    }

    //region 显示详细信息
    /**
     * 显示详细信息
     */
    function showMemberDetails()
    {
        //必须选中datagrid中的一行数据才能查询详细信息
        //首先判断是否选中
        var row = $('#tb_memberDetails').datagrid('getSelected');

        //没有选中
        if (row == null)
        {
            $.messager.alert('错误', '请先选中表格中的任意一条数据再查看详细信息');
        }
        else
        {
            //获取选中的id
            var id = row.memberID;
            console.log(id);

            //显示详细信息
            window.location.href = "/destoon/showDetails.com?memberID=" + id;
        }
    }
    //endregion
</script>--%>

<body class="easyui-layout">
<div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
    <ul class="easyui-tree">
        <li>
            <span>会员管理</span>
            <ul>
                <li><a id="addMember">添加会员</a></li>
                <li><a id="listMember" onclick="iniMemberTable()">会员列表</a></li>
                <li><a id="addMemberGroup">会员组添加</a></li>
                <li><a id="managerMemberGroup">会员组管理</a></li>
                <li><a id="examineMember">会员审核</a></li>
                <li><a id="iniMemberData" onclick="iniMemberData()">恢复会员数据</a></li>
            </ul>
        </li>
        <li>
            <span>公司管理</span>
            <ul>
                <li><a id="companyList">公司列表</a></li>
                <li><a id="companyClassify">行业分类</a></li>
                <li><a id="companyNews">公司新闻</a></li>
                <li><a id="iniCompanyData" onclick="iniMemberData()">恢复公司数据</a></li>
            </ul>
        </li>
    </ul>
</div>
<div data-options="region:'center',title:'主页'" style="padding:5px;background:#eee;">

    <div id="tt" class="easyui-tabs" style="width:100%;height:100%">
        <div title="添加会员" style="padding:20px;display:none;">
            <jsp:include page="member/pages/addMember.jsp"></jsp:include>
        </div>
        <div title="会员列表" data-options="closable:false" style="overflow:auto;padding:20px;display:none;">
            <table id="tb_memberDetails"></table>
        </div>
        <div title="公司列表" data-options="iconCls:'icon-reload',closable:false" style="padding:20px;display:none;">
            tab3
        </div>
        <div title="修改会员" data-options="iconCls:'icon-edit',closable:false" style="padding:20px;display:none;">
            tab3
        </div>
    </div>
</div>

<!-- toolbar -->
<div id="toolbar_member">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-help'" onclick="showMemberDetails()">详细信息</a>
</div>
<!-- toolbar -->

</body>

</html>
















