package com.iispl.main;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

  
        Date processingDate =Date.valueOf("2026-08-13");


        Map<String, Object> parameters = new HashMap<>();

        parameters.put( "P_PROCESSING_DATE", processingDate);

      
        parameters.put("P_STATUS","REJECTED");
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            System.out.println();
            System.out.println("================================================");
            System.out.println("       CHEQUE PROCESSING REPORT SYSTEM");
            System.out.println("================================================");

            System.out.println("1. Member 1 - Daily Cheque Processing Report");
            System.out.println("2. Member 2 - Rejected Cheque Report");
            System.out.println("3. Member 3 - MICR Repair Report");
            System.out.println("4. Member 4 - High Value Cheque Report");
            System.out.println("5. Member 5 - Batch Processing Summary");
            System.out.println("6. Member 6 - Bank-wise Processing Summary");
            System.out.println("0. Exit");

            System.out.println("================================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            System.out.println();

            switch (choice) {

                case 1:

                    System.out.println( "Generating Daily Cheque Processing Report...");

                    JasperReportRunner.generateCSV("reports/daily_cheque_report.jrxml", "output/daily_cheque_report.csv",parameters);

                    System.out.println("Daily Cheque Processing Report generated successfully.");

                    System.out.println("Output: output/daily_cheque_report.csv");

                    break;



                case 2:

                    System.out.println(
                            "Generating Rejected Cheque Report..."
                    );

                    JasperReportRunner.generateCSV(
                            "reports/rejected_cheque_report.jrxml",
                            "output/rejected_cheque_report.csv",
                            parameters
                    );

                    System.out.println(
                            "Rejected Cheque Report generated successfully."
                    );

                    System.out.println(
                            "Output: output/rejected_cheque_report.csv"
                    );

                    break;


                case 3:

                    System.out.println(
                            "Generating MICR Repair Report..."
                    );

                    JasperReportRunner.generateCSV(
                            "reports/micr_repair_report.jrxml",
                            "output/micr_repair_report.csv",
                            parameters
                    );

                    System.out.println(
                            "MICR Repair Report generated successfully."
                    );

                    System.out.println(
                            "Output: output/micr_repair_report.csv"
                    );

                    break;



                case 4:

                    System.out.println(
                            "Generating High Value Cheque Report..."
                    );

                    JasperReportRunner.generateCSV(
                            "reports/high_value_report.jrxml",
                            "output/high_value_report.csv",
                            parameters
                    );

                    System.out.println(
                            "High Value Cheque Report generated successfully."
                    );

                    System.out.println(
                            "Output: output/high_value_report.csv"
                    );

                    break;


            
                case 5:

                    System.out.println(
                            "Generating Batch Processing Summary..."
                    );

                    JasperReportRunner.generateCSV(
                            "reports/batch_report_summary.jrxml",
                            "output/batch_summary_report.csv",
                            parameters
                    );

                    System.out.println(
                            "Batch Processing Summary generated successfully."
                    );

                    System.out.println(
                            "Output: output/batch_summary_report.csv"
                    );

                    break;



                case 6:

                    System.out.println(
                            "Generating Bank-wise Processing Summary..."
                    );

                    JasperReportRunner.generateCSV(
                            "reports/bank_summary_report.jrxml",
                            "output/bank_summary_report.csv",
                            parameters
                    );

                    System.out.println(
                            "Bank-wise Processing Summary generated successfully."
                    );

                    System.out.println(
                            "Output: output/bank_summary_report.csv"
                    );

                    break;



                case 7:
                	
                	
                	  System.out.println(
                              "Generating Bank-wise Daily Processing Summary..."
                      );

                      JasperReportRunner.generateCSV(
                              "reports/cts_daily_operations_dashboard.jrxml",
                              "output/cts_daily_operations_dashboard.jrxml.csv",
                              parameters
                      );

                      System.out.println(
                              "Bank-wise Processing Summary generated successfully."
                      );

                      System.out.println(
                              "Output: output/cts_daily_operations_dashboard.jrxml.csv"
                      );

                    break;


                default:

                    System.out.println(
                            "Invalid choice. Please select 0 to 6."
                    );
            }

        } while (choice != 0);

        scanner.close();

        System.out.println();
        System.out.println("================================================");
        System.out.println("        REPORT SYSTEM CLOSED");
        System.out.println("================================================");
    }
}