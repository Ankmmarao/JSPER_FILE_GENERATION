package com.iispl.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.LogFactory;

public class TestLogging {

    public static void main(String[] args) {

//        System.out.println("Commons Logging test");
//
//        System.out.println(
//            LogFactory.class.getProtectionDomain()
//                .getCodeSource()
//                .getLocation()
//        );
//
//        System.out.println("LogFactory loaded successfully.");
//        
        Map<String,Object> parameters=new HashMap<>();
        
        
        JasperReportRunner.generateCSV(
                "reports/batch_report_summary.jrxml",
                "output/batch_report_summary.csv",
                parameters
        );
    }
}