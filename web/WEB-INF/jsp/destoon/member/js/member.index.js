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