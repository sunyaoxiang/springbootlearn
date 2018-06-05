package com.reportcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by yaoxiang.sun on 2018/5/10.
 */
@Component
public class SystemConfig {

    private static Properties properties;

    public SystemConfig() {
        try {
            Resource resource = new ClassPathResource("./application.properties");
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static String getUploadDir() {
//        String key = "spring.uploaddir";
//        return properties == null ? null : properties.getProperty(key);
//    }

    public static String getCheckDataDir() {
        String key = "spring.check_data_dir";
        return properties == null ? null : properties.getProperty(key);
    }

    @Value("${spring.uploaddir}")
    private static String getUpLoadDirs;

    @Autowired
    private Environment env;

//    public static void main(String[] args) {
//        File directory = new File("");//设定为当前文件夹
//        try{
//            System.out.println(directory.getCanonicalPath());//获取标准的路径
//            System.out.println(directory.getAbsolutePath());//获取绝对路径
//        }catch(IOException e){}
//        System.out.println(new SystemConfig().getCheckDataDir());
//        SystemConfig systemConfig = new SystemConfig();
//        System.out.println(systemConfig.env.getProperty("spring.check_data_dir"));
//    }
}
