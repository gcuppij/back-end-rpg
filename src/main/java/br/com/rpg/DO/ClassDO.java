package br.com.rpg.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "class")
@XmlRootElement
public class ClassDO implements AbstractDO {

    private static final long serialVersionUID = -4361999059890598512L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String bonus;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ClassDO [id=" + id + ", name=" + name + ", bonus=" + bonus + "]";
    }

}
