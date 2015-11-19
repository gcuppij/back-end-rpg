package br.com.rpg.utils;

import br.com.rpg.services.beans.UserBean;

public class TestUtils {

    private static final String USER = "user_test_junit";
    private static final String PASSWORD = "password_test_junit";
    private static final Integer COUNTRY = 1;
    
    public static final Integer USER_ID = 1;
    
    public static UserBean userBean() {
        UserBean userBean = new UserBean();
        userBean.setUserName(USER);
        userBean.setPassword(PASSWORD);
        userBean.setCountryId(COUNTRY);
        return userBean;
    }
}
