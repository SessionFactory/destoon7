package member.domain;

import core.DestoonUtils7;
import core.SuperDestoonEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * 会员组
 *
 * @author qinzhengying
 * @since 1.7 2016-11-13
 */
@SuppressWarnings("all")
public class MemberGroup implements SuperDestoonEntity<Short>
{
    private static final long serialVersionUID = 7480622835686606690L;

    //region 会员编号
    /**
     * 会员编号1, 2
     */
    private Short id;

    @Override
    public Short getId()
    {
        return id;
    }

    @Override
    public void setId(Short id)
    {
        this.id = id;
    }
    //endregion

    //region 会员组名称
    private String memberGroup;

    public String getMemberGroup()
    {
        return memberGroup;
    }

    public void setMemberGroup(String memberGroup)
    {
        this.memberGroup = memberGroup;
    }
    //endregion

    //region 构造函数
    public MemberGroup()
    {
        DestoonUtils7.destPrint.prints("初始化会员组构造函数");
    }

    public MemberGroup(String memberGroup)
    {
        DestoonUtils7.destPrint.prints("初始化会员组构造函数memberGroup = " + memberGroup);
        this.memberGroup = memberGroup;
    }
    //endregion

    //region toString()

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("MemberGroup{");
        sb.append("id=").append(id);
        sb.append(", memberGroup='").append(memberGroup).append('\'');
        sb.append('}');
        return sb.toString();
    }

    //endregion

    //region 与会员关联
    private Set<Member> memberSet = new HashSet<>();

    public Set<Member> getMemberSet()
    {
        return memberSet;
    }

    public void setMemberSet(Set<Member> memberSet)
    {
        this.memberSet = memberSet;
    }
    //endregion
}