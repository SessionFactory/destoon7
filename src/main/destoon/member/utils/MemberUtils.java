package member.utils;

import member.domain.Member;
import qin.javaee7.core.JavaEE7BaseSupport;

/**
 * destoon会员工具类
 *
 * @author qinzhengying
 * @since 1.7 2016-11-16
 */
@SuppressWarnings("all")
public class MemberUtils implements JavaEE7BaseSupport
{
    //region 检查用户是否可以登录

    /**
     * 会员工具类(检查会员里的字段是否符合要求)
     *
     * @param member
     * @return
     */
    public static String checkMember(Member member)
    {
        String memberName = member.getMemberLoginName();
        String memberLoginPassword = member.getMemberLoginPassword();
        String memberEmail = member.getMemberEmail();

        boolean checkName = memberName.matches("[0-9]*");
        boolean checkEmail_endWith = memberEmail.endsWith("@");
        boolean checkEmail_isContains = memberEmail.contains("@");

        String msg = "";

        if (checkName)
        {
            msg = "用户名不能全部为空!";
        }
        else
        {
            msg = str_success;
        }
        if (!checkEmail_isContains)
        {
            msg = "邮箱中必须有@!";
        }
        else
        {
            msg = str_success;
        }

        return msg;
    }
    //endregion
}










