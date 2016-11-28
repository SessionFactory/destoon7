package member.controller;

import core.DestoonUtils7;
import member.domain.Member;
import member.service.MemberService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import qin.javaee7.core.hibernate.controller.JavaEE7BaseController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static core.DestoonUtils7.destPrint;
import static member.utils.MemberUtils.checkMember;

/**
 * 会员控制层
 *
 * @author qinzhengying
 * @since 1.7 2016-11-17
 */
@Controller(value = "destoon_memberController7")
@Scope("prototype")
@RequestMapping(value = "/destoon/member")
@SuppressWarnings("all")
public class MemberController extends JavaEE7BaseController
{
    private static final long serialVersionUID = -8146144960418768806L;

    //region 获取本地配置文件路径

    @Override
    public String getLog4jLocaction()
    {
        return DestoonUtils7.log4jPath;
    }

    //endregion

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

    //region 返回登录主页面

    /**
     * 返回登录主页面
     *
     * @return 主页面
     */
    @RequestMapping(value = "/login")
    @Override
    public ModelAndView doMainView()
    {
        return new ModelAndView("/destoon/member/login");
    }

    //endregion

    //region 实现登录

    /**
     * 实现登录
     *
     * @param member   会员实体类
     * @param response 回复
     * @param request  请求
     */
    @RequestMapping(value = "/doLogin")
    public Object doLogin(Member member, HttpServletResponse response, HttpServletRequest request)
    {
        String msg = "";

        try
        {
            Member vo = new Member();

            //region 判断接收的member
            String memberLoginName = member.getMemberLoginName().trim();
            String memberLoginPassword = member.getMemberLoginPassword().trim();
            String memberEmail = member.getMemberEmail().trim();
            vo.setMemberLoginName(memberLoginName);
            vo.setMemberLoginPassword(memberLoginPassword);
            vo.setMemberEmail(memberEmail);
            //检查会员
            String checkMember = checkMember(vo);
            //endregion

            if (checkMember == str_success)
            {
                //实现登录功能
                String ajaxMsg = memberService.doMemberLogin(vo);
                //记录登录时间
                String loginTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                returnJson(ajaxMsg, response);
                actionFlag = true;
                return ajaxMsg;
            }
            else
            {
                returnJson(checkMember, response);
                return str_failed;
            }
        }
        catch (Exception ex)
        {
            actionFlag = false;
            return ex;
        }
        finally
        {
            doCheck(actionFlag);
        }
    }
    //endregion

    //region 登录成功后返回index

    /**
     * 登录成功后返回index页面
     *
     * @return 返回的页面
     */
    @RequestMapping(value = "/index")
    @Deprecated
    public ModelAndView index()
    {
        destPrint.prints("in index");
        return null;
        //return new ModelAndView("/destoon/member/index");
    }
    //endregion

    //region 恢复会员表中数据

    /**
     * 恢复会员表中数据
     */
    @RequestMapping(value = "/iniMemberData")
    public void iniMemberData(HttpServletResponse response)
    {
        try
        {
            memberService.iniMember();
            returnJson(str_success, response);
        }
        catch (Exception ex)
        {
            destPrint.prints("恢复数据失败!" + ex);
        }
    }
    //endregion

    //region 会员管理功能

    //region 显示会员

    /**
     * 显示会员<br>
     * 显示会员页面需要输出的信息<br>
     * ID, 名称, 公司, 性别, 会员组, 操作
     *
     * @param response 写入页面数据
     */
    @RequestMapping(value = "/listMember")
    public void listMember(HttpServletResponse response)
    {
        List<Member> memberList = null;

        try
        {
            memberList = memberService.findMember();

            JSONArray jsonArray = new JSONArray();
            //map
            JSONObject object = new JSONObject();

            for (Iterator<Member> mIt = memberList.iterator(); mIt.hasNext(); )
            {
                Member member = mIt.next();

                //ID
                object.put("memberID", member.getId());
                //名称
                object.put("memberName", member.getMemberLoginName());
                //公司
                object.put("memberCompany", member.getMemberCompanyName());
                //性别
                object.put("memberGender", member.getMemberGender().toString());
                //会员组
                object.put("memberGroup", member.getMemberGroup().getMemberGroup());

                jsonArray.add(object);
            }

            String baseStr = "{\"total\":" + memberList.size() + ",\"rows\":";
            baseStr = baseStr + jsonArray.toString() + "}";
            returnJson(baseStr, response);

            actionFlag = true;
        }
        catch (Exception ex)
        {
            actionFlag = false;
        }
        finally
        {
            doCheck(actionFlag);
        }
    }
    //endregion

    //region 新增会员
    //endregion

    //endregion
}

//region objectPut公司
                /*
                //名称
                String memberCompanyName = member.getMemberCompanyName();
                //类型
                String memberCompanyType = member.getMemberCompanyType().getCompanyTypeName();
                //主营行业
                String memberCompanyMainProf = member.getMemberCompanyMainProf();
                //规模
                String memberCompanySize = member.getMemberCompanySize();
                //成立年份
                String memberCompanyYearOfStart = member.getMemberCompanyYearOfStart().toString();
                //地址
                String memberCompanyAddress = member.getMemberCompanyAddress();
                //电话
                String memberCompanyTelephone = member.getMemberCompanyTelephone();
                //介绍
                String memberCompanyIntroduction = member.getMemberCompanyIntroduction();

                //language=html
                String html_company = new StringBuilder()
                          .append("<style type=\"text/css\">\n")
                          .append("    #_myDiv1\n")
                          .append("    {\n")
                          .append("        font-family: 微软雅黑;\n")
                          .append("        font-size: 16px;\n")
                          .append("    }\n")
                          .append("\n")
                          .append("    #_companyFont\n")
                          .append("    {\n")
                          .append("        color: black;\n")
                          .append("    }\n")
                          .append("</style>\n")
                          .append("\n")
                          .append("<div id=\"_myDiv1\">\n")
                          .append("    <font id=\"_companyFont\">公司名称:</font>\n")
                          .append("    <font style=\"color: red;\">")
                          .append(memberCompanyName)
                          .append("</font>\n")
                          .append("    <br>\n")
                          .append("    <font id=\"_companyFont\">公司类型:</font>\n")
                          .append("    <font style=\"color: #ac2925; \">")
                          .append(memberCompanyType)
                          .append("</font>\n")
                          .append("    <br>\n")
                          .append("    <font id=\"_companyFont\">主营行业:</font>\n")
                          .append("    <font style=\"color: #b11111; \">")
                          .append(memberCompanyMainProf)
                          .append("</font>\n")
                          .append("    <br>\n")
                          .append("    <font id=\"_companyFont\">规模:</font>\n")
                          .append("    <font style=\"color: #ce187e; \">")
                          .append(memberCompanySize)
                          .append("</font>\n")
                          .append("    <br>\n")
                          .append("    <font id=\"_companyFont\">成立年份:</font>\n")
                          .append("    <font style=\"color: #db0706; \">")
                          .append(memberCompanyYearOfStart)
                          .append("</font>\n")
                          .append("    <br>\n")
                          .append("    <font id=\"_companyFont\">地址:</font>\n")
                          .append("    <font style=\"color: #e02020; \">")
                          .append(memberCompanyAddress)
                          .append("</font>\n")
                          .append("    <br>\n")
                          .append("    <font id=\"_companyFont\">电话:</font>\n")
                          .append("    <font style=\"color: #fa700b; \">")
                          .append(memberCompanyTelephone)
                          .append("</font>\n")
                          .append("    <br>\n")
                          .append("    <font id=\"_companyFont\">介绍:</font>\n")
                          .append("    <font style=\"color: darkmagenta; \">")
                          .append(memberCompanyIntroduction)
                          .append("</font>\n")
                          .append("    <br>\n")
                          .append("</div>").toString();
                */
//endregion














