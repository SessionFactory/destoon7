package core;

import qin.javaee7.core.JavaEE7BaseSupport;
import qin.javaee7.core.JavaEE7Print;

import java.util.Calendar;
import java.util.Date;

/**
 * Destoon工具类
 *
 * @author qinzhengying
 * @since 1.7 2016-11-13
 */
@SuppressWarnings("all")
public final class DestoonUtils7 implements JavaEE7BaseSupport
{
    private static final long serialVersionUID = -7562706837625275482L;

    public static final String log4jPath = "D:\\idea2016WK\\destoon7\\src\\resources\\log4j.properties";

    /**
     * 配置文件路径
     */
    public static final JavaEE7Print destPrint = new JavaEE7Print(log4jPath);

    /**
     * 单例模式
     */
    private DestoonUtils7()
    {

    }

    //region 获取时间
    public static Date getTime(int year, int month, int day)
    {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        return c.getTime();
    }
    //endregion

    //region 自动生成easyui-datagrid代码

    /**
     * 生成easyui-datagrid的网页代码
     *
     * @param table_id      表格id
     * @param url           需要执行的url
     * @param width         表格宽度
     * @param height        表格高度
     * @param is_rownumbers 是否要显示行号
     * @param is_pagination 是否要启用分页
     * @param column_field  列名
     * @param column_title  列标题
     * @param column_width  列宽
     */
    public static String printDataGrid
    (
              String table_title, String table_id, String url, Integer width, Integer height,
              boolean is_rownumbers, boolean is_pagination, String[] column_field,
              String[] column_title, Integer[] column_width
    )
    {
        //标准的datagrid设置:
        StringBuilder sb = new StringBuilder();

        sb.append("$('#")
                  .append(table_id)
                  .append("').datagrid\n")
                  .append("(\n")
                  .append("    {\n")
                  .append("        title: '" + table_title + "',\n")
                  .append("        url: '" + url + "',\n")
                  .append("        rownumbers: ")
                  .append(is_rownumbers)
                  .append(",\n").append("        width: ")
                  .append(width)
                  .append(",\n")
                  .append("        height: ")
                  .append(height)
                  .append(",\n")
                  .append("        pagination: ")
                  .append(is_pagination)
                  .append(",\n")
                  .append("        columns://\n")
                  .append("            [\n")
                  .append("                [\n");

        for (int i = 0; i < column_field.length; i++)
        {
            sb.append("                    {field: '")
                      .append(column_field[i])
                      .append("', title: '")
                      .append(column_title[i])
                      .append("', width: ")
                      .append(column_width[i])
                      .append(", align: 'center'},\n");
        }

        sb.append("                ]\n")
                  .append("            ]\n")
                  .append("    }\n")
                  .append(")");

        return sb.toString();
    }
    //endregion
}