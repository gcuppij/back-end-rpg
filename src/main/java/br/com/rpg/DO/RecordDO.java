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
@Table(name = "record")
@XmlRootElement
public class RecordDO implements AbstractDO {

    private static final long serialVersionUID = -4428572147396075524L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer classId;

    @Column
    private Integer raceId;

    @Column
    private Integer money;

    @Column
    private String fixedItems;

    @XmlElement
    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @XmlElement
    public Integer getRaceId() {
        return raceId;
    }

    public void setRaceId(Integer raceId) {
        this.raceId = raceId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement
    public Integer getId() {
        return id;
    }

    @XmlElement
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @XmlElement
    public String getFixedItems() {
        return fixedItems;
    }

    public void setFixedItems(String fixedItems) {
        this.fixedItems = fixedItems;
    }

    @Override
    public String toString() {
        return "RecordDO [id=" + id + ", classId=" + classId + ", raceId=" + raceId + ", money=" + money
                + ", fixedItems=" + fixedItems + "]";
    }

}
