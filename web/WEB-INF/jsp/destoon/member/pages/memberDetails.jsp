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
</div>






