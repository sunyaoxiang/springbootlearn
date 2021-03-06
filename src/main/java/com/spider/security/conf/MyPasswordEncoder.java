package com.spider.security.conf;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by yaoxiang.sun on 2018/5/31.
 */

/**
 * 密码编码器,(部分版本不需要);
 * 解决"java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null""错误
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence arg0) {
        return arg0.toString();
    }

    @Override
    public boolean matches(CharSequence arg0, String arg1) {
        return arg1.equals(arg0.toString());
    }
}
