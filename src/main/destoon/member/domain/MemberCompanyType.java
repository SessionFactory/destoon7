package member.domain;

import core.DestoonUtils7;
import core.SuperDestoonEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * 公司类型
 *
 * @author qinzhengying
 * @since 1.7 2016-11-13
 */
public class MemberCompanyType implements SuperDestoonEntity<Short>
{
    private static final long serialVersionUID = 1425144530612241568L;

    //region 主键
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

    //region 公司类型名称
    private String companyTypeName;

    public String getCompanyTypeName()
    {
        return companyTypeName;
    }

    public void setCompanyTypeName(String companyTypeName)
    {
        this.companyTypeName = companyTypeName;
    }
    //endregion

    //region 构造函数
    public MemberCompanyType()
    {
        DestoonUtils7.destPrint.prints("初始化会员组构造函数");
    }

    public MemberCompanyType(String companyTypeName)
    {
        DestoonUtils7.destPrint.prints("初始化会员组构造函数companyTypeName = " + companyTypeName);
        this.companyTypeName = companyTypeName;
    }
    //endregion

    //region toString()

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("MemberCompanyType{");
        sb.append("id=").append(id);
        sb.append(", companyTypeName='").append(companyTypeName).append('\'');
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