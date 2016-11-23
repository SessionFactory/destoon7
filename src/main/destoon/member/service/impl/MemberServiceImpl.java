package member.service.impl;

import core.DestoonUtils7;
import member.dao.MemberDAO;
import member.domain.Member;
import member.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qin.javaee7.core.exceptions.CollectionEmptyException;
import qin.javaee7.core.exceptions.JavaEE7Exception;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员服务层实现
 *
 * @author qinzhengying
 * @since 1.7 2016-11-17
 */
@Service("destoon_memberService7")
@Transactional
@SuppressWarnings("all")
public class MemberServiceImpl implements MemberService
{
    private static final long serialVersionUID = -6544956225992258787L;

    //region 注入会员数据访问层
    /**
     * 注入会员数据访问层
     */
    private MemberDAO memberDAO;

    public MemberDAO getMemberDAO()
    {
        return memberDAO;
    }

    @Resource
    public void setMemberDAO(MemberDAO memberDAO)
    {
        this.memberDAO = memberDAO;
    }
    //endregion

    //region 登录

    /**
     * 会员登录功能
     *
     * @param member 会员实体类
     * @return 是否登录成功或在验证过程中失败将失败信息传到前台页面
     * @throws JavaEE7Exception 抛出大异常
     */
    @Override
    public String doMemberLogin(Member member) throws JavaEE7Exception
    {
        return memberDAO.doMemberLogin(member);
    }
    //endregion

    //region 恢复会员数据
    @Override
    public void iniMember()
    {
        memberDAO.iniMember();
    }
    //endregion

    //region 查询所有会员数据

    @Override
    public List<Member> findMember() throws JavaEE7Exception
    {
        List<Member> result = memberDAO.loadAll(Member.class);

        if (result.size() == 0 || result == null)
        {
            throw new CollectionEmptyException();
        }
        else
        {
            return result;
        }
    }

    //endregion

    //region 根据登录名查找会员

    @Override
    public Member findMember(String loginName)
    {
        return memberDAO.findMember(loginName);
    }

    //endregion

    //region 根据主键查找会员

    @Override
    public Member findMember(Long memberId)
    {
        try
        {
            return (Member) memberDAO.get(Member.class, memberId);
        }
        catch (Exception ex)
        {
            DestoonUtils7.destPrint.prints("MemberServiceImpl Exception:" + ex);
            return null;
        }
    }

    //endregion
}