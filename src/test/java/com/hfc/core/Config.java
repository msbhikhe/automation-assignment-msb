package com.hfc.core;

import java.io.*;
import java.util.Properties;

public class Config {
    private static Properties props;

    static {
        props = new Properties();
        try {
            props.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties"));
        }catch (FileNotFoundException e){
            System.out.println("Config properties not found");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String getProperty(String propertyName) {
        return props.getProperty(propertyName);
    }
}
