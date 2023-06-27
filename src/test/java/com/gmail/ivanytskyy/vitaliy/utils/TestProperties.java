package com.gmail.ivanytskyy.vitaliy.utils;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 25/06/2023
 */
public final class TestProperties {
    private static TestProperties instance = null;
    private static final String PATH_TO_PROPERTIES;
    static {
        PATH_TO_PROPERTIES = new File(
                "src" + File.separator
                        + "test" + File.separator
                        + "resources" + File.separator
                        + "test.properties")
                .getAbsolutePath();
    }
    private final Properties properties;
    private TestProperties() throws IOException {
        properties = new Properties();
        properties.load(new FileReader(PATH_TO_PROPERTIES));
    }
    public static TestProperties getInstance() throws IOException {
        if(instance == null){
            instance = new TestProperties();
        }
        return instance;
    }
    public String getProperty(String propertyName){
        return Objects.requireNonNull(this.properties.getProperty(propertyName),
                "Property " + propertyName + " isn't exist");
    }
    public void setProperty(String key, String value) throws IOException {
        properties.setProperty(key, value);
        properties.store(new FileWriter(PATH_TO_PROPERTIES), null);
    }
}