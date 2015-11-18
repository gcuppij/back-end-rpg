package br.com.rpg.services.beans;

public class UserBean {

    private String userName;
    private String password;
    private Integer countryId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "UserBean [userName=" + userName + ", password=" + password + ", countryId=" + countryId + "]";
    }
}
