package com.security;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class passwordUtils {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int SALT_LEN = 16;
    private static final int ITERATIONS = 100_000;
    private static final int KEY_LENGTH = 256;

    public static String generateSalt() {
        byte[] salt = new byte[SALT_LEN];
        RANDOM.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashPassword(char[] password, String base64salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = Base64.getDecoder().decode(base64salt);
        KeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = f.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }

    public static boolean verify(char[] attemptedPassword, String storedHash, String storedSalt) throws Exception {
        String attemptedHash = hashPassword(attemptedPassword, storedSalt);
        return slowEquals(Base64.getDecoder().decode(storedHash), Base64.getDecoder().decode(attemptedHash));
    }

    private static boolean slowEquals(byte[] a, byte[] b) {
        if (a.length != b.length)
            return false;
        int diff = 0;
        for (int i = 0; i < a.length; i++)
            diff |= a[i] ^ b[i];
        return diff == 0;
    }

}
