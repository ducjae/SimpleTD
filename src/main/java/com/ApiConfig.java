package com;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiConfig {
    private static final String API_KEY;
    
    static {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            // 또는 클래스패스에서 로드: getClass().getClassLoader().getResourceAsStream("config.properties")
            prop.load(input);
            API_KEY = prop.getProperty("openai.api.key");
        } catch (IOException ex) {
            throw new RuntimeException("API 설정을 로드할 수 없습니다", ex);
        }
    }
    
    public static String getApiKey() {
        return API_KEY;
    }
}