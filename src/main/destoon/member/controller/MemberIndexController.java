package member.controller;

import member.domain.Member;
import member.service.MemberService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import qin.javaee7.core.hibernate.controller.JavaEE7BaseController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.DestoonUtils7.destPrint;

/**
 * 返回会员主页控制层
 *
 * @author qinzhengying
 * @since 1.7 2016-11-19
 */
@Controller(value = "destoon_indexController7")
@Scope("prototype")
@RequestMapping(value = "/destoon")
@SuppressWarnings("all")
public class MemberIndexController extends JavaEE7BaseController
{
    private static final long serialVersionUID = -2625435698263840423L;

    //region 注入服务层
    private MemberService memberService;

    public MemberService getMemberService()
    {
        return memberService;
    }

    @Resource
    public void setMemberService(MemberService memberService)
    {
        this.memberService = memberService;
    }
    //endregion

    //region 登录成功后返回index

    /**
     * 登录成功后返回index页面
     *
     * @return 返回的页面
     */
    @RequestMapping(value = "/index")
    public Object index(HttpServletRequest request, HttpServletResponse response)
    {
        //2
        destPrint.prints("in index");

        Object lastLoginTime = request.getParameter("lastLoginTime");

        if (lastLoginTime != null)
        {
            //returnJson(str_success, response);
            request.setAttribute("lastLoginTime", lastLoginTime.toString().trim());
            return new ModelAndView("/destoon/index");
        }
        else
        {
            returnJson("请先登录系统!", response);
            return "请先登录!";
        }
    }
    //endregion

    //region 显示详细信息

    /**
     * 显示详细信息
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/showMemberDetails")
    public void showMemberDetails(HttpServletRequest request, HttpServletResponse response)
    {
        Long memberID = Long.valueOf(request.getParameter("memberID").trim());
        Member member = memberService.findMember(memberID);

        //language=HTML
        String html = "    <br>\n" +
                  "    <div class=\"easyui-panel\" id=\"_panel\" title=\"会员资料\" style=\"width:100%;\">\n" +
                  "        <table width=\"100%\" border=\"1\" bordercolor=\"#663300\"\n" +
                  "               style=\"background-color:#F0F2F7; font-family:微软雅黑;\">\n" +
                  "            <tr>\n" +
                  "                <td rowspan=\"7\" style=\"width: 300px;\">\n" +
                  "                    <img src=\"/images/1.jpg\" alt=\"\" style=\"width: 300px;\">\n" +
                  "                </td>\n" +
                  "                <td id=\"tb_memberDetails\">会员名</td>\n" +
                  "                <td>\n" +
                  "                    <font style=\"color: #2e004b;\">"+member.getMemberName()+"</font>\n" +
                  "                </td>\n" +
                  "                <td id=\"tb_memberDetails\">会员真实姓名</td>\n" +
                  "                <td>\n" +
                  "                    <font style=\"color: #000000;\">"+member.getMemberRealName()+"</font>\n" +
                  "                </td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">会员登录名</td>\n" +
                  "                <td>\n" +
                  "                    <font style=\"color: #761c19;\">"+member.getMemberLoginName()+"</font>\n" +
                  "                </td>\n" +
                  "                <td id=\"tb_memberDetails\">会员性别</td>\n" +
                  "                <td>\n" +
                  "                    <font style=\"color: #31708f;\">"+member.getMemberGender().toString()+"</font>\n" +
                  "                </td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">会员昵称</td>\n" +
                  "                <td>\n" +
                  "                    <font style=\"color: #063c03;\">"+member.getMemberName()+"</font>\n" +
                  "                </td>\n" +
                  "                <td id=\"tb_memberDetails\">会员所在地区</td>\n" +
                  "                <td>\n" +
                  "                    <font style=\"color: #da0007;\">"+member.getMemberPlace().getMemberPlaceName()+"</font>\n" +
                  "                </td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">会员email</td>\n" +
                  "                <td>\n" +
                  "                    <font style=\"color: #f05f7e;\">"+member.getMemberEmail()+"</font>\n" +
                  "                </td>\n" +
                  "                <td id=\"tb_memberDetails\">会员所在部门</td>\n" +
                  "                <td>\n" +
                  "                    <font style=\"color: #134C10;\">"+member.getMemberDepartment()+"</font>\n" +
                  "                </td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">会员qq</td>\n" +
                  "                <td>\n" +
                  "                    <font style=\"color: #ce187e;\">"+member.getMemberQQ()+"</font>\n" +
                  "                </td>\n" +
                  "            </tr>\n" +
                  "        </table>\n" +
                  "    </div>\n" +
                  "\n" +
                  "    <div class=\"easyui-panel\" id=\"_panel2\" title=\"公司资料\" style=\"width:100%;\">\n" +
                  "        <table width=\"100%\" bordercolor=\"#663300\" border=\"1\"\n" +
                  "               style=\"background-color:#F0F2F7; font-family:微软雅黑;\">\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">公司主页</td>\n" +
                  "                <td>\n" +
                  "                    <font style=\"color: blue;\"></font>\n" +
                  "                </td>\n" +
                  "                <td>&nbsp;</td>\n" +
                  "                <td>&nbsp;</td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">公司名</td>\n" +
                  "                <td>"+member.getMemberCompanyName()+"</td>\n" +
                  "                <td id=\"tb_memberDetails\">主营范围</td>\n" +
                  "                <td>"+member.getMemberCompanyScopeOfBusiness()+"</td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">经营模式</td>\n" +
                  "                <td>"+member.getMemberCompanyMode()+"</td>\n" +
                  "                <td id=\"tb_memberDetails\">公司规模</td>\n" +
                  "                <td>&nbsp;</td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">注册资本</td>\n" +
                  "                <td>"+member.getMemberCompanySize()+"</td>\n" +
                  "                <td id=\"tb_memberDetails\">公司所在地</td>\n" +
                  "                <td>"+member.getMemberPlace()+"</td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">成立年份</td>\n" +
                  "                <td>"+member.getMemberCompanyYearOfStart().toString()+"</td>\n" +
                  "                <td id=\"tb_memberDetails\">采购的产品</td>\n" +
                  "                <td>"+member.getMemberCompanyBuysProduct()+"</td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">销售的产品</td>\n" +
                  "                <td>"+member.getMemberCompanySalesProduct()+"</td>\n" +
                  "                <td id=\"tb_memberDetails\">公司类型</td>\n" +
                  "                <td>&nbsp;</td>\n" +
                  "            </tr>\n" +
                  "        </table>\n" +
                  "    </div>\n" +
                  "\n" +
                  "    <div class=\"easyui-panel\" id=\"_panel3\" title=\"联系方式\" style=\"width:100%;\">\n" +
                  "        <table width=\"100%\" border=\"1\" bordercolor=\"#9933FF\"\n" +
                  "               style=\"background-color:#F0F2F7; font-family:微软雅黑;\">\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">姓名</td>\n" +
                  "                <td>name</td>\n" +
                  "                <td id=\"tb_memberDetails\">手机</td>\n" +
                  "                <td>mobile</td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">部门</td>\n" +
                  "                <td>department</td>\n" +
                  "                <td id=\"tb_memberDetails\">职位</td>\n" +
                  "                <td>job</td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">电话</td>\n" +
                  "                <td>phone</td>\n" +
                  "                <td id=\"tb_memberDetails\">传真</td>\n" +
                  "                <td>fax</td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">email</td>\n" +
                  "                <td>email</td>\n" +
                  "                <td id=\"tb_memberDetails\">qq</td>\n" +
                  "                <td>qq</td>\n" +
                  "            </tr>\n" +
                  "            <tr>\n" +
                  "                <td id=\"tb_memberDetails\">邮编</td>\n" +
                  "                <td>zipcode</td>\n" +
                  "            </tr>\n" +
                  "        </table>\n" +
                  "    </div>\n" +
                  "    <br>";

        returnJson(html, response);
    }
    //endregion
}














