<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style type="text/css">
    #tb_memberDetails
    {
        color: #006699;
    }

    #_panel, #_panel2
    {
        font-family: 微软雅黑;
        font-size: 16px;
    }
</style>

<script type="text/javascript">
    $(function ()
        {
            //region 初始化面板
            $('#_panel').panel
            (
                {
                    //最大化和最小化
                    minimizable: true,
                    maximizable: true,
                    //可折叠
                    collapsible: true
                }
            );

            $('#_panel2').panel
            (
                {
                    //最大化和最小化
                    minimizable: true,
                    maximizable: true,
                    //可折叠
                    collapsible: false
                }
            );

            $('#_panel3').panel
            (
                {
                    //最大化和最小化
                    minimizable: true,
                    maximizable: true,
                    //可折叠
                    collapsible: false
                }
            );
            //endregion
        }
    );
</script>

<div id="_bigDIV">
    <br>
    <div class="easyui-panel" id="_panel" title="会员资料" style="width:100%;">
        <table width="100%" border="1" bordercolor="#663300"
               style="background-color:#F0F2F7; font-family:微软雅黑;">
            <tr>
                <td rowspan="7" style="width: 300px;">
                    <img src="/images/1.jpg" alt="" style="width: 300px;">
                </td>
                <td id="tb_memberDetails">会员名</td>
                <td>
                    <font style="color: #2e004b;"></font>
                </td>
                <td id="tb_memberDetails">会员真实姓名</td>
                <td>
                    <font style="color: #000000;"></font>
                </td>
            </tr>
            <tr>
                <td id="tb_memberDetails">会员登录名</td>
                <td>
                    <font style="color: #761c19;"></font>
                </td>
                <td id="tb_memberDetails">会员性别</td>
                <td>
                    <font style="color: #31708f;"></font>
                </td>
            </tr>
            <tr>
                <td id="tb_memberDetails">会员昵称</td>
                <td>
                    <font style="color: #063c03;"></font>
                </td>
                <td id="tb_memberDetails">会员所在地区</td>
                <td>
                    <font style="color: #da0007;"></font>
                </td>
            </tr>
            <tr>
                <td id="tb_memberDetails">会员email</td>
                <td>
                    <font style="color: #f05f7e;"></font>
                </td>
                <td id="tb_memberDetails">会员所在部门</td>
                <td>
                    <font style="color: #134C10;"></font>
                </td>
            </tr>
            <tr>
                <td id="tb_memberDetails">会员qq</td>
                <td>
                    <font style="color: #ce187e;"></font>
                </td>
                <td id="tb_memberDetails">会员最后一次登录时间</td>
                <td>
                    <font style="color: #e68900;"></font>
                </td>
            </tr>
        </table>
    </div>

    <div class="easyui-panel" id="_panel2" title="公司资料" style="width:100%;">
        <table width="100%" bordercolor="#663300" border="1"
               style="background-color:#F0F2F7; font-family:微软雅黑;">
            <tr>
                <td id="tb_memberDetails">公司主页</td>
                <td>
                    <font style="color: blue;"></font>
                </td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="tb_memberDetails">公司名</td>
                <td>&nbsp;</td>
                <td id="tb_memberDetails">主营范围</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="tb_memberDetails">经营模式</td>
                <td>&nbsp;</td>
                <td id="tb_memberDetails">公司规模</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="tb_memberDetails">注册资本</td>
                <td>&nbsp;</td>
                <td id="tb_memberDetails">公司所在地</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="tb_memberDetails">成立年份</td>
                <td>&nbsp;</td>
                <td id="tb_memberDetails">采购的产品</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td id="tb_memberDetails">销售的产品</td>
                <td>&nbsp;</td>
                <td id="tb_memberDetails">公司类型</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </div>

    <div class="easyui-panel" id="_panel3" title="联系方式" style="width:100%;">
        <table width="100%" border="1" bordercolor="#9933FF"
               style="background-color:#F0F2F7; font-family:微软雅黑;">
            <tr>
                <td id="tb_memberDetails">姓名</td>
                <td>name</td>
                <td id="tb_memberDetails">手机</td>
                <td>mobile</td>
            </tr>
            <tr>
                <td id="tb_memberDetails">部门</td>
                <td>department</td>
                <td id="tb_memberDetails">职位</td>
                <td>job</td>
            </tr>
            <tr>
                <td id="tb_memberDetails">电话</td>
                <td>phone</td>
                <td id="tb_memberDetails">传真</td>
                <td>fax</td>
            </tr>
            <tr>
                <td id="tb_memberDetails">email</td>
                <td>email</td>
                <td id="tb_memberDetails">qq</td>
                <td>qq</td>
            </tr>
            <tr>
                <td id="tb_memberDetails">邮编</td>
                <td>zipcode</td>
            </tr>
        </table>
    </div>
    <br>
</div>






