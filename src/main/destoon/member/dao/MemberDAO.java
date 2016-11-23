package member.dao;

import member.domain.Member;
import qin.javaee7.core.exceptions.JavaEE7Exception;
import qin.javaee7.core.hibernate.dao.JavaEE7DAOSupport;

/**
 * 会员数据访问层
 *
 * @author qinzhengying
 * @since 1.7 2016-11-16
 */
@SuppressWarnings("all")
public interface MemberDAO extends JavaEE7DAOSupport<Member, Long>
{
    //region 获取会员实体类

    /**
     * 获取会员实体类
     *
     * @return 返回的是会员实体类对象
     */
    @Override
    Class<Member> getEntityClass();
    //endregion

    //region 获取destoon的日志配置文件路径

    /**
     * 获取destoon的日志配置文件路径
     *
     * @return 获取到的配置文件路径
     */
    @Override
    String getLog4jLocation();
    //endregion

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

    //region 根据登录名查找会员

    /**
     * 根据登录名查找会员
     *
     * @param loginName 登录名称
     * @return 会员结果
     */
    @Deprecated
    Member findMember(String loginName);
    //endregion
}