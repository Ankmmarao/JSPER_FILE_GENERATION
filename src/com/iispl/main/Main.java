package com.iispl.main;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // =====================================================
        // PROCESSING DATE
        // =====================================================

        Date processingDate =
                Date.valueOf("2026-08-13");


        // =====================================================
        // PARAMETERS
        // =====================================================

        Map<String, Object> parameters =
                new HashMap<>();

        parameters.put(
                "P_PROCESSING_DATE",
                processingDate
        );


        // =====================================================
        // DAILY CHEQUE REPORT → CSV
        // =====================================================

        System.out.println();
        System.out.println("Generating CSV...");

        JasperReportRunner.generateCSV(
        		        "reports/daily_cheque_report.jrxml",
        		        "output/daily_cheque_report.csv",
        		        parameters
        );


        // =====================================================
        // COMPLETION MESSAGE
        // =====================================================

        System.out.println();
        System.out.println("======================================");
        System.out.println("CSV REPORT GENERATION COMPLETED");
        System.out.println("======================================");

        System.out.println();
        System.out.println(
                "Generated file:"
        );

        System.out.println(
                "CSV : output/daily_cheque_report.csv"
        );

        System.out.println(
                "======================================"
        );
    }
}