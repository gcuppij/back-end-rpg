package br.com.rpg.utils;

import br.com.rpg.services.beans.UserBean;

public class TestUtils {

    private static final Integer CREATE_COUNTRY = 1;
    private static final String CREATE_USER_LOGIN = "create_user_test_junit";
    private static final String CREATE_USER_PASSWORD = "create_password_test_junit";

    public static final Integer USER_ID = 1;
    public static final String USER_LOGIN = "user_test_junit";
    public static final String USER_PASSWORD = "password_test_junit";

    public static UserBean userBean() {
        UserBean userBean = new UserBean();
        userBean.setUserName(CREATE_USER_LOGIN);
        userBean.setPassword(CREATE_USER_PASSWORD);
        userBean.setCountryId(CREATE_COUNTRY);
        return userBean;
    }
}
