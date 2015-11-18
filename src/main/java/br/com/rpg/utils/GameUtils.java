package br.com.rpg.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class GameUtils {

    public static String generateToken(Integer id, String name) {
        try {
            String s = id + name;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(), 0, s.length());
            return new BigInteger(1, m.digest()).toString(16);
        } catch (Exception e) {
            return "";
        }
    }
}
