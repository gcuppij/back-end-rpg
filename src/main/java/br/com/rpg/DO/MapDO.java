package br.com.rpg.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "map")
public class MapDO implements AbstractDO {

    private static final long serialVersionUID = 6173015484447762437L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String picture;

    public Integer getId() {
        return id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "MapDO [id=" + id + ", picture=" + picture + "]";
    }

}
