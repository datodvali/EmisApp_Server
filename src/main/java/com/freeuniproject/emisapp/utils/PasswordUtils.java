package com.freeuniproject.emisapp.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtils {

    // Salt generation method (you should use a unique salt per user)
    public static String generateSalt() {
        // TODO not really all that random
        return "random_salt";
    }

    // Hash the password with the salt
    public static String hashPassword(String password, String salt) {
        String saltedPassword = salt + password;
        byte[] hash = DigestUtils.sha256(saltedPassword); // You can use other algorithms too
        return Hex.encodeHexString(hash);
    }

    // Verify the entered password against the stored hash
    public static boolean verifyPassword(String storedHash, String salt, String enteredPassword) {
        String hashedEnteredPassword = hashPassword(enteredPassword, salt);
        return storedHash.equals(hashedEnteredPassword);
    }
}
