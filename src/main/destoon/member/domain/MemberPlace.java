package member.domain;

import core.SuperDestoonEntity;

import java.util.HashSet;
import java.util.Set;

import static core.DestoonUtils7.destPrint;

/**
 * 会员所在地区
 *
 * @author qinzhengying
 * @since 1.7 2016-11-13
 */
@SuppressWarnings("all")
public class MemberPlace implements SuperDestoonEntity<Integer>
{
    private static final long serialVersionUID = -2270693547512520161L;

    //region 主键
    private Integer id;

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public void setId(Integer id)
    {
        this.id = id;
    }
    //endregion

    //region 地区名称
    private String memberPlaceName;

    public String getMemberPlaceName()
    {
        return memberPlaceName;
    }

    public void setMemberPlaceName(String memberPlaceName)
    {
        this.memberPlaceName = memberPlaceName;
    }
    //endregion

    //region 构造函数
    public MemberPlace()
    {
        destPrint.prints("初始化会员所在地区实体类");
    }

    public MemberPlace(String memberPlaceName)
    {
        destPrint.prints("初始化会员所在地区实体类:memberPlaceName = " + memberPlaceName);
        this.memberPlaceName = memberPlaceName;
    }
    //endregion

    //region toString()

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("MemberPlace{");
        sb.append("id=").append(id);
        sb.append(", memberPlaceName='").append(memberPlaceName).append('\'');
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