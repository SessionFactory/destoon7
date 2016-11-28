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
     * @return
     */
    @RequestMapping(value = "/showDetails")
    public ModelAndView showDetails(HttpServletRequest request, HttpServletResponse response)
    {
        Member member = memberService.findMember(Long.valueOf(request.getParameter("memberID").trim()));

        request.setAttribute("member", member);

        return new ModelAndView("/destoon/showDetails");
    }
    //endregion
}











