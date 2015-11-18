package br.com.rpg.services.beans;

public class RecordBean {

    private Integer playerId;
    private String className;
    private String classBonus;
    private String raceName;
    private String raceBonus;
    private Integer money;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getClassBonus() {
        return classBonus;
    }

    public void setClassBonus(String classBonus) {
        this.classBonus = classBonus;
    }

    public String getRaceBonus() {
        return raceBonus;
    }

    public void setRaceBonus(String raceBonus) {
        this.raceBonus = raceBonus;
    }

    @Override
    public String toString() {
        return "RecordBean [playerId=" + playerId + ", className=" + className + ", classBonus=" + classBonus
                + ", raceName=" + raceName + ", raceBonus=" + raceBonus + ", money=" + money + "]";
    }
}
