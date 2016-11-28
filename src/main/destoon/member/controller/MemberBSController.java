package member.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import qin.javaee7.core.hibernate.controller.JavaEE7BaseController;

/**
 * Bootstrap版会员控制层实现
 *
 * @author qinzhengying
 * @since 1.7 2016/11/27
 */
@Controller(value = "memberController27")
@Scope("prototype")
@RequestMapping(value = "/destoon/bs")
@SuppressWarnings("all")
public class MemberBSController extends JavaEE7BaseController
{
    private static final long serialVersionUID = -359069223829388413L;

    //region 返回bootstrap版会员主页

    /**
     * 返回bootstrap版会员主页
     *
     * @return
     */
    @RequestMapping(value = "/memberIndex")
    @Override
    public ModelAndView doMainView()
    {
        return new ModelAndView("/destoon/bs/memberIndex");
    }
    //endregion
}