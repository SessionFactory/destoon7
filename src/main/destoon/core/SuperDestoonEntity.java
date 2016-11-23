package core;

import qin.javaee7.core.JavaEE7BaseSupport;
import qin.javaee7.core.hibernate.SuperEntity7;

import java.io.Serializable;

/**
 * destoon超级实体类
 *
 * @param <T> 任意实体类型(必须是Serializable的子类)
 * @author qinzhengying
 * @since 1.7 2016-11-13
 */
public interface SuperDestoonEntity<T extends Serializable>
          extends SuperEntity7<T>, JavaEE7BaseSupport
{
    /**
     * 获取我的主键
     *
     * @return
     */
    @Override
    T getId();

    /**
     * 设置我的主键
     *
     * @param t
     */
    @Override
    void setId(T t);
}