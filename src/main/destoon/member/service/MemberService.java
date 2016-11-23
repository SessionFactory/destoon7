package member.service;

import member.domain.Member;
import qin.javaee7.core.JavaEE7BaseSupport;
import qin.javaee7.core.exceptions.JavaEE7Exception;

import java.util.List;

/**
 * 会员服务层
 *
 * @author qinzhengying
 * @since 1.7 2016-11-17
 */
@SuppressWarnings("all")
public interface MemberService extends JavaEE7BaseSupport
{
    //region 实现登录功能

    /**
     * 会员登录功能
     *
     * @param member 会员实体类
     * @return 是否登录成功或在验证过程中失败将失败信息传到前台页面
     * @throws JavaEE7Exception 抛出大异常
     */
    String doMemberLogin(Member member) throws JavaEE7Exception;
    //endregion

    //region 恢复会员数据

    /**
     * 恢复会员数据
     */
    void iniMember();
    //endregion

    //region 查询所有会员

    /**
     * 查询所有会员
     *
     * @return
     * @throws JavaEE7Exception
     */
    List<Member> findMember() throws JavaEE7Exception;
    //endregion

    //region 根据登录名查找会员
    Member findMember(String loginName);
    //endregion

    //region 根据主键查找会员

    /**
     * 根据主键查找会员
     *
     * @param memberId 会员主键
     * @return 返回查找到的会员实体类
     */
    Member findMember(Long memberId);
    //endregion
}