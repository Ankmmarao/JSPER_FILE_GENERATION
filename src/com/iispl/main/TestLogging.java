package com.iispl.main;

import org.apache.commons.logging.LogFactory;

public class TestLogging {

    public static void main(String[] args) {

        System.out.println("Commons Logging test");

        System.out.println(
            LogFactory.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
        );

        System.out.println("LogFactory loaded successfully.");
    }
}