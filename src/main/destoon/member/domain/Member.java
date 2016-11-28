package member.domain;

import core.DestoonUtils7;
import core.SuperDestoonEntity;

import java.util.Date;

@SuppressWarnings("all")
public class Member implements SuperDestoonEntity<Long>
{
    private static final long serialVersionUID = -6457825251365013719L;

    //region 构造函数
    public Member()
    {
        DestoonUtils7.destPrint.prints("初始化会员构造函数");
    }

    /*
    memberCompanyIntroduction
    memberCompanyTelephone
    memberCompanyAddress
    memberCompanyYearOfStart
    memberCompanyScopeOfBusiness
    memberCompanyMainProf
    memberCompanyName
    memberGender
    memberRealName
    memberEmail
    memberLoginSurePassword
    memberLoginPassword
    memberLoginName
     */

    /**
     * @param memberLoginName
     * @param memberLoginPassword
     * @param memberLoginSurePassword
     * @param memberEmail
     * @param memberRealName
     * @param memberGender
     * @param memberCompanyName
     * @param memberCompanyMainProf
     * @param memberCompanyScopeOfBusiness
     * @param memberCompanyYearOfStart
     * @param memberCompanyAddress
     * @param memberCompanyTelephone
     * @param memberCompanyIntroduction
     */
    public Member(String memberLoginName, String memberLoginPassword, String memberLoginSurePassword,
                  String memberEmail, String memberRealName, MemberGender memberGender,
                  String memberCompanyName, String memberCompanyMainProf,
                  String memberCompanyScopeOfBusiness, Date memberCompanyYearOfStart,
                  String memberCompanyAddress, String memberCompanyTelephone, String memberCompanyIntroduction)
    {
        this.memberLoginName = memberLoginName;
        this.memberLoginPassword = memberLoginPassword;
        this.memberLoginSurePassword = memberLoginSurePassword;
        this.memberEmail = memberEmail;
        this.memberRealName = memberRealName;
        this.memberGender = memberGender;
        this.memberCompanyName = memberCompanyName;
        this.memberCompanyMainProf = memberCompanyMainProf;
        this.memberCompanyScopeOfBusiness = memberCompanyScopeOfBusiness;
        this.memberCompanyYearOfStart = memberCompanyYearOfStart;
        this.memberCompanyAddress = memberCompanyAddress;
        this.memberCompanyTelephone = memberCompanyTelephone;
        this.memberCompanyIntroduction = memberCompanyIntroduction;
    }
    //endregion

    //region 主键
    private Long id;

    @Override
    public Long getId()
    {
        return id;
    }

    @Override
    public void setId(Long id)
    {
        this.id = id;
    }
    //endregion

    //region 会员组
    /**
     * 会员组
     */
    private MemberGroup memberGroup;

    public MemberGroup getMemberGroup()
    {
        return memberGroup;
    }

    public void setMemberGroup(MemberGroup memberGroup)
    {
        this.memberGroup = memberGroup;
    }
    //endregion

    //region 会员登录名
    /**
     * 会员登录名
     */
    private String memberLoginName;

    public String getMemberLoginName()
    {
        return memberLoginName;
    }

    public void setMemberLoginName(String memberLoginName)
    {
        this.memberLoginName = memberLoginName;
    }
    //endregion

    //region 昵称
    /**
     * 昵称
     */
    private String memberName;

    public String getMemberName()
    {
        return memberName;
    }

    public void setMemberName(String memberName)
    {
        this.memberName = memberName;
    }
    //endregion

    //region 登录密码
    /**
     * 登录密码
     */
    private String memberLoginPassword;

    public String getMemberLoginPassword()
    {
        return memberLoginPassword;
    }

    public void setMemberLoginPassword(String memberLoginPassword)
    {
        this.memberLoginPassword = memberLoginPassword;
    }
    //endregion

    //region 重复输入密码
    /**
     * 重复输入密码
     */
    private String memberLoginSurePassword;

    public String getMemberLoginSurePassword()
    {
        return memberLoginSurePassword;
    }

    public void setMemberLoginSurePassword(String memberLoginSurePassword)
    {
        this.memberLoginSurePassword = memberLoginSurePassword;
    }
    //endregion

    //region Email
    /**
     * Email
     */
    private String memberEmail;

    public String getMemberEmail()
    {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail)
    {
        this.memberEmail = memberEmail;
    }
    //endregion

    //region 真实姓名
    /**
     * 真实姓名
     */
    private String memberRealName;

    public String getMemberRealName()
    {
        return memberRealName;
    }

    public void setMemberRealName(String memberRealName)
    {
        this.memberRealName = memberRealName;
    }
    //endregion

    //region 性别
    /**
     * 性别
     */
    private MemberGender memberGender;

    public MemberGender getMemberGender()
    {
        return memberGender;
    }

    public void setMemberGender(MemberGender memberGender)
    {
        this.memberGender = memberGender;
    }
    //endregion

    //region 所在地区
    /**
     * 所在地区
     */
    private MemberPlace memberPlace;

    public MemberPlace getMemberPlace()
    {
        return memberPlace;
    }

    public void setMemberPlace(MemberPlace memberPlace)
    {
        this.memberPlace = memberPlace;
    }
    //endregion

    //region 部门
    /**
     * 部门
     */
    private String memberDepartment;

    public String getMemberDepartment()
    {
        return memberDepartment;
    }

    public void setMemberDepartment(String memberDepartment)
    {
        this.memberDepartment = memberDepartment;
    }
    //endregion

    //region qq
    /**
     * qq
     */
    private Long memberQQ;

    public Long getMemberQQ()
    {
        return memberQQ;
    }

    public void setMemberQQ(Long memberQQ)
    {
        this.memberQQ = memberQQ;
    }
    //endregion

    //region 公司名称
    /**
     * 公司名称
     */
    private String memberCompanyName;

    public String getMemberCompanyName()
    {
        return memberCompanyName;
    }

    public void setMemberCompanyName(String memberCompanyName)
    {
        this.memberCompanyName = memberCompanyName;
    }
    //endregion

    //region 公司类型
    /**
     * 公司类型
     */
    private MemberCompanyType memberCompanyType;

    public MemberCompanyType getMemberCompanyType()
    {
        return memberCompanyType;
    }

    public void setMemberCompanyType(MemberCompanyType memberCompanyType)
    {
        this.memberCompanyType = memberCompanyType;
    }
    //endregion

    //region 形象图片
    /**
     * 形象图片
     */
    private String memberCompanyImage;

    public String getMemberCompanyImage()
    {
        return memberCompanyImage;
    }

    public void setMemberCompanyImage(String memberCompanyImage)
    {
        this.memberCompanyImage = memberCompanyImage;
    }
    //endregion

    //region 主营行业
    /**
     * 主营行业
     */
    private String memberCompanyMainProf;

    public String getMemberCompanyMainProf()
    {
        return memberCompanyMainProf;
    }

    public void setMemberCompanyMainProf(String memberCompanyMainProf)
    {
        this.memberCompanyMainProf = memberCompanyMainProf;
    }
    //endregion

    //region 主要经营范围
    /**
     * 主要经营范围
     */
    private String memberCompanyScopeOfBusiness;

    public String getMemberCompanyScopeOfBusiness()
    {
        return memberCompanyScopeOfBusiness;
    }

    public void setMemberCompanyScopeOfBusiness(String memberCompanyScopeOfBusiness)
    {
        this.memberCompanyScopeOfBusiness = memberCompanyScopeOfBusiness;
    }
    //endregion

    //region 经营模式
    /**
     * 经营模式
     */
    private String memberCompanyMode;

    public String getMemberCompanyMode()
    {
        return memberCompanyMode;
    }

    public void setMemberCompanyMode(String memberCompanyMode)
    {
        this.memberCompanyMode = memberCompanyMode;
    }
    //endregion

    //region 公司规模
    /**
     * 公司规模
     */
    private String memberCompanySize;

    public String getMemberCompanySize()
    {
        return memberCompanySize;
    }

    public void setMemberCompanySize(String memberCompanySize)
    {
        this.memberCompanySize = memberCompanySize;
    }
    //endregion

    //region 注册资本
    /**
     * 注册资本
     */
    private Long memberCompanyRegisterMoney;

    public Long getMemberCompanyRegisterMoney()
    {
        return memberCompanyRegisterMoney;
    }

    public void setMemberCompanyRegisterMoney(Long memberCompanyRegisterMoney)
    {
        this.memberCompanyRegisterMoney = memberCompanyRegisterMoney;
    }
    //endregion

    //region 公司成立年份
    /**
     * 公司成立年份
     */
    private Date memberCompanyYearOfStart;

    public Date getMemberCompanyYearOfStart()
    {
        return memberCompanyYearOfStart;
    }

    public void setMemberCompanyYearOfStart(Date memberCompanyYearOfStart)
    {
        this.memberCompanyYearOfStart = memberCompanyYearOfStart;
    }
    //endregion

    //region 公司地址
    /**
     * 公司地址
     */
    private String memberCompanyAddress;

    public String getMemberCompanyAddress()
    {
        return memberCompanyAddress;
    }

    public void setMemberCompanyAddress(String memberCompanyAddress)
    {
        this.memberCompanyAddress = memberCompanyAddress;
    }
    //endregion

    //region 邮政编码
    /**
     * 邮政编码
     */
    private Long memberCompanyZipCode;

    public Long getMemberCompanyZipCode()
    {
        return memberCompanyZipCode;
    }

    public void setMemberCompanyZipCode(Long memberCompanyZipCode)
    {
        this.memberCompanyZipCode = memberCompanyZipCode;
    }
    //endregion

    //region 公司电话
    /**
     * 公司电话
     */
    private String memberCompanyTelephone;

    public String getMemberCompanyTelephone()
    {
        return memberCompanyTelephone;
    }

    public void setMemberCompanyTelephone(String memberCompanyTelephone)
    {
        this.memberCompanyTelephone = memberCompanyTelephone;
    }
    //endregion

    //region 公司传真
    /**
     * 公司传真
     */
    private String memberCompanyFax;

    public String getMemberCompanyFax()
    {
        return memberCompanyFax;
    }

    public void setMemberCompanyFax(String memberCompanyFax)
    {
        this.memberCompanyFax = memberCompanyFax;
    }
    //endregion

    //region 公司email
    /**
     * 公司email
     */
    private String memberCompanyEmail;

    public String getMemberCompanyEmail()
    {
        return memberCompanyEmail;
    }

    public void setMemberCompanyEmail(String memberCompanyEmail)
    {
        this.memberCompanyEmail = memberCompanyEmail;
    }
    //endregion

    //region 公司网址
    /**
     * 公司网址
     */
    private String memberCompanyNetWork;

    public String getMemberCompanyNetWork()
    {
        return memberCompanyNetWork;
    }

    public void setMemberCompanyNetWork(String memberCompanyNetWork)
    {
        this.memberCompanyNetWork = memberCompanyNetWork;
    }
    //endregion

    //region 销售的产品
    /**
     * 销售的产品
     */
    private String memberCompanySalesProduct;

    public String getMemberCompanySalesProduct()
    {
        return memberCompanySalesProduct;
    }

    public void setMemberCompanySalesProduct(String memberCompanySalesProduct)
    {
        this.memberCompanySalesProduct = memberCompanySalesProduct;
    }
    //endregion

    //region 采购的产品
    /**
     * 采购的产品
     */
    private String memberCompanyBuysProduct;

    public String getMemberCompanyBuysProduct()
    {
        return memberCompanyBuysProduct;
    }

    public void setMemberCompanyBuysProduct(String memberCompanyBuysProduct)
    {
        this.memberCompanyBuysProduct = memberCompanyBuysProduct;
    }
    //endregion

    //region 公司介绍
    /**
     * 公司介绍
     */
    private String memberCompanyIntroduction;

    public String getMemberCompanyIntroduction()
    {
        return memberCompanyIntroduction;
    }

    public void setMemberCompanyIntroduction(String memberCompanyIntroduction)
    {
        this.memberCompanyIntroduction = memberCompanyIntroduction;
    }
    //endregion

    //region 会员资料是否完整
    /**
     * 会员资料是否完整
     */
    private Boolean memberIsCompleted;

    public Boolean getMemberIsCompleted()
    {
        return memberIsCompleted;
    }

    public void setMemberIsCompleted(Boolean memberIsCompleted)
    {
        this.memberIsCompleted = memberIsCompleted;
    }
    //endregion

    //region toString()

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Member{");
        sb.append("id=").append(id);
        sb.append(", memberLoginName='").append(memberLoginName).append('\'');
        sb.append(", memberName='").append(memberName).append('\'');
        sb.append(", memberLoginPassword='").append(memberLoginPassword).append('\'');
        sb.append(", memberLoginSurePassword='").append(memberLoginSurePassword).append('\'');
        sb.append(", memberEmail='").append(memberEmail).append('\'');
        sb.append(", memberRealName='").append(memberRealName).append('\'');
        sb.append(", memberGender=").append(memberGender);
        sb.append(", memberDepartment='").append(memberDepartment).append('\'');
        sb.append(", memberQQ=").append(memberQQ);
        sb.append(", memberCompanyName='").append(memberCompanyName).append('\'');
        sb.append(", memberCompanyImage='").append(memberCompanyImage).append('\'');
        sb.append(", memberCompanyMainProf='").append(memberCompanyMainProf).append('\'');
        sb.append(", memberCompanyScopeOfBusiness='").append(memberCompanyScopeOfBusiness).append('\'');
        sb.append(", memberCompanyMode='").append(memberCompanyMode).append('\'');
        sb.append(", memberCompanySize='").append(memberCompanySize).append('\'');
        sb.append(", memberCompanyRegisterMoney=").append(memberCompanyRegisterMoney);
        sb.append(", memberCompanyYearOfStart=").append(memberCompanyYearOfStart);
        sb.append(", memberCompanyAddress='").append(memberCompanyAddress).append('\'');
        sb.append(", memberCompanyZipCode=").append(memberCompanyZipCode);
        sb.append(", memberCompanyTelephone='").append(memberCompanyTelephone).append('\'');
        sb.append(", memberCompanyFax='").append(memberCompanyFax).append('\'');
        sb.append(", memberCompanyEmail='").append(memberCompanyEmail).append('\'');
        sb.append(", memberCompanyNetWork='").append(memberCompanyNetWork).append('\'');
        sb.append(", memberCompanySalesProduct='").append(memberCompanySalesProduct).append('\'');
        sb.append(", memberCompanyBuysProduct='").append(memberCompanyBuysProduct).append('\'');
        sb.append(", memberCompanyIntroduction='").append(memberCompanyIntroduction).append('\'');
        sb.append(", memberIsCompleted=").append(memberIsCompleted);
        sb.append('}');
        return sb.toString();
    }

    //endregion
}