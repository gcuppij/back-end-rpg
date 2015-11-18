package br.com.rpg.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Calendar;

public class UserUtils {

    public static String generateMD5(String name) {
        try {
            String word = name + Calendar.getInstance().getTime();
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(word.getBytes(), 0, word.length());
            return new BigInteger(1, digest.digest()).toString(16);
        } catch (Exception e) {
            return "";
        }
    }
}
