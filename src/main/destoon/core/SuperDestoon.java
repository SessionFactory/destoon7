package core;

import qin.javaee7.core.hibernate.SuperEntity7;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("all")
@Entity
@Table(name = "destoon_super")
public class SuperDestoon implements SuperEntity7<Integer>
{
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
}