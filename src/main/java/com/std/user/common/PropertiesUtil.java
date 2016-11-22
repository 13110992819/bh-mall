package com.std.user.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties props = null;

    public static void init(String configFile) {
        props = new Properties();
        try {
            InputStream in = PropertiesUtil.class
                .getResourceAsStream(configFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            props.load(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (props == null) {
            // throw new Exception("配置文件初始化失败");
        }
        return props.getProperty(key);
    }

    public static final class Config {
        public static String SMS_URL = props.getProperty("SMS_URL");

        public static String COMPANY_MOBILE = props
            .getProperty("COMPANY_MOBILE");

        public static String USER_URL = props.getProperty("USER_URL");

        public static String ACCOUNT_URL = props.getProperty("ACCOUNT_URL");

        public static String FORUM_URL = props.getProperty("FORUM_URL");

        public static String NOTOP_HPJFROLECODE = props
            .getProperty("NOTOP_HPJFROLECODE");

        public static String NOTOP_JFROLECODE = props
            .getProperty("NOTOP_JFROLECODE");

        public static String SJROLECODE = props.getProperty("SJROLECODE");

        public static String SMS_CHANNEL = props.getProperty("SMS_CHANNEL");

        public static String APP_KEY = props.getProperty("APP_KEY");

        public static String MASTER_SECRET = props.getProperty("MASTER_SECRET");

        public static String APNS_PRODUCTION = props
            .getProperty("APNS_PRODUCTION");
    }
}
