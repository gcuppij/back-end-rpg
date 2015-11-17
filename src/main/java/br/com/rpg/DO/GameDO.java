package br.com.rpg.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "game")
@XmlRootElement
public class GameDO implements AbstractDO {

    private static final long serialVersionUID = -823333315035140897L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    @Type(type = "text")
    private String description;

    @Column
    private Integer userId;

    @Column
    private Integer mapId;

    @Column
    private String token;

    @XmlElement
    public Integer getId() {
        return id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @XmlElement
    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
