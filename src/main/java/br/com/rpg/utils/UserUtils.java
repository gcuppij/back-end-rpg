package br.com.rpg.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class UserUtils {

    public static String generateMD5(String name) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(name.getBytes(), 0, name.length());
            return new BigInteger(1, m.digest()).toString(16);
        } catch (Exception e) {
            return "";
        }
    }
}
