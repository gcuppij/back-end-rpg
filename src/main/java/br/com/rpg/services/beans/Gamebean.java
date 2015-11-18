package br.com.rpg.services.beans;

public class Gamebean {
    
    private Integer userId;
    private String name;
    private String description;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Gamebean [userId=" + userId + ", name=" + name + ", description=" + description + "]";
    }

}
