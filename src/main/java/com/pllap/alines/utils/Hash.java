/*
 * Author : Hyeokwoo Kwon
 * Filename : Hash.java
 * Desc :
 */

package com.pllap.alines.utils;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;

public class Hash {
    public static String sha256(String string) {
        String result = null;
        try {
            byte[] randomBytes = new byte[32];
            ThreadLocalRandom.current().nextBytes(randomBytes);
            byte[] stringBytes = string.getBytes(StandardCharsets.UTF_8);
            byte[] hashBytes = new byte[randomBytes.length + stringBytes.length];

            System.arraycopy(randomBytes, 0, hashBytes, 0, randomBytes.length);
            System.arraycopy(stringBytes, 0, hashBytes, randomBytes.length, stringBytes.length);

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(hashBytes);
            result = new String(Hex.encodeHex(messageDigest.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
