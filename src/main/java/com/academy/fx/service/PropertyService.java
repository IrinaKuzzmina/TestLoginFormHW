package com.academy.fx.service;

import java.io.IOException;
import java.util.Properties;

public class PropertyService {
    private static final String PROP_PATH = "prop/error.properties";

    private static PropertyService instance;
    private Properties properties;

    private PropertyService() {
        init();
    }

    private void init() {
        properties = new Properties();
        try {
            properties.load(PropertyService.class.getClassLoader().getResourceAsStream(PROP_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertyService getInstance() {
        synchronized (PropertyService.class) {
            if (instance == null) {
                instance = new PropertyService();
            }
        }

        return instance;
    }

    public String getError(ErrorKey errorKey) {
        return properties.getProperty(errorKey.getValue());
    }
}
