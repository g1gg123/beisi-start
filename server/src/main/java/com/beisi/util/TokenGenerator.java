package com.beisi.util;

import java.util.UUID;

public class TokenGenerator {
    // 利用UUID生成token
    public static String generateToken(String username) {
        return UUID.randomUUID().toString();
    }
}
