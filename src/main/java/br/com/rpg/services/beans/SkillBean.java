package br.com.rpg.services.beans;

public class SkillBean {

    private Integer recordId;
    private String name;
    private Integer point;

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

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "SkillBean [recordId=" + recordId + ", name=" + name + ", point=" + point + "]";
    }
}
