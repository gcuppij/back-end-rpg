package br.com.rpg.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "race")
public class RaceDO implements AbstractDO {

    private static final long serialVersionUID = 5784059310905674157L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String bonus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RaceDO [id=" + id + ", name=" + name + ", bonus=" + bonus + "]";
    }

}
