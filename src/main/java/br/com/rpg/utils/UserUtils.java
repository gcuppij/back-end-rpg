package br.com.rpg.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class UserUtils {

    public static String generatePassword(String login, String password) {
        try {
            String word = login + password;
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(word.getBytes(), 0, word.length());
            return new BigInteger(1, digest.digest()).toString(16);
        } catch (Exception e) {
            return "";
        }
    }
}
