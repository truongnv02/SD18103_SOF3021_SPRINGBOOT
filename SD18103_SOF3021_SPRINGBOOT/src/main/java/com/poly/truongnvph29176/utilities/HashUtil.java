package com.poly.truongnvph29176.utilities;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class HashUtil {
    public static String hash(String plain) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(plain, salt);
    }

    public static boolean verify(String plain, String hashed) {
        return BCrypt.checkpw(plain, hashed);
    }
}
