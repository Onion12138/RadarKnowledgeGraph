package com.ecnu.onion.knowledge.util;

import java.util.UUID;

/**
 * @author onion
 * @date 2020/12/4 -9:33 上午
 */
public class KeyUtil {
    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
