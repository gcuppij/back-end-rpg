package br.com.rpg.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class PlayerDO implements AbstractDO {

    private static final long serialVersionUID = -5608512093361227877L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer recordId;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private Integer userId;

    @Column
    private Integer gameId;

    public Integer getId() {
        return id;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PlayerDO [id=" + id + ", recordId=" + recordId + ", name=" + name + ", age=" + age + ", userId="
                + userId + ", gameId=" + gameId + "]";
    }

}
