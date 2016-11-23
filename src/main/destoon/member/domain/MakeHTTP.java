package member.domain;

import core.DestoonUtils7;
import core.SuperDestoonEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 生成首页实体类
 *
 * @author qinzhengying
 * @since 1.8 2016-11-16
 */
@Entity
@Table(name = "destoon_http")
@SuppressWarnings("all")
public class MakeHTTP implements SuperDestoonEntity<Integer>
{
    private static final long serialVersionUID = 444876116519260001L;

    //region 主键
    private Integer id;

    @Id
    @GeneratedValue
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

    //region 网站标题
    private String httpTitle;

    @Column(length = 30)
    public String getHttpTitle()
    {
        return httpTitle;
    }

    public void setHttpTitle(String httpTitle)
    {
        this.httpTitle = httpTitle;
    }
    //endregion

    //region 版权信息
    private String httpCopyRight;

    @Column(length = 5000)
    public String getHttpCopyRight()
    {
        return httpCopyRight;
    }

    public void setHttpCopyRight(String httpCopyRight)
    {
        this.httpCopyRight = httpCopyRight;
    }
    //endregion

    //region 构造函数
    public MakeHTTP()
    {
        DestoonUtils7.destPrint.prints("初始化首页实体类");
    }

    public MakeHTTP(String httpCopyRight, String httpTitle)
    {
        DestoonUtils7.destPrint.prints("初始化首页实体类:httpCopyRight = " + httpCopyRight +
                                                 "       &&httpTitle = " + httpTitle);
        this.httpCopyRight = httpCopyRight;
        this.httpTitle = httpTitle;
    }
    //endregion
}