package com.iispl.main;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    
        Date processingDate =
                Date.valueOf("2026-08-13");


        Scanner scanner = new Scanner(System.in);


        while (true) {

         
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
            System.out.println("7. CTS Daily Operations Dashboard");
            System.out.println("8. Generate ALL Reports");
            System.out.println("0. Exit");
            System.out.println("================================================");

            System.out.print("Enter your choice: ");

            int choice;

            try {

                choice = Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (Exception e) {

                System.out.println(
                        "Invalid choice."
                );

                continue;
            }


            // =================================================
            // EXIT
            // =================================================

            if (choice == 0) {

                System.out.println(
                        "Exiting..."
                );

                break;
            }


            // =================================================
            // PARAMETERS
            // =================================================

            Map<String, Object> parameters =
                    new HashMap<>();

            parameters.put(
                    "P_PROCESSING_DATE",
                    processingDate
            );


            // =================================================
            // OPTION 1
            // DAILY CHEQUE REPORT
            // =================================================

            if (choice == 1) {

                System.out.println();
                System.out.println(
                        "Generating Daily Cheque Processing Report..."
                );

                JasperReportRunner.generatePDF(
                        "reports/daily_cheque_report.jrxml",
                        "output/daily_cheque_report.pdf",
                        parameters
                );

                System.out.println();
                System.out.println(
                        "PDF : output/daily_cheque_report.pdf"
                );
            }


            // =================================================
            // OPTION 2
            // REJECTED CHEQUE REPORT
            // =================================================

            else if (choice == 2) {

                System.out.println();
                System.out.println(
                        "Generating Rejected Cheque Report..."
                );


                Map<String, Object> rejectedParameters =
                        new HashMap<>();


                rejectedParameters.put(
                        "P_STATUS",
                        "REJECTED"
                );


                JasperReportRunner.generatePDF(
                        "reports/rejected_cheque_report.jrxml",
                        "output/rejected_cheque_report.pdf",
                        rejectedParameters
                );


                System.out.println();
                System.out.println(
                        "PDF : output/rejected_cheque_report.pdf"
                );
            }


            // =================================================
            // OPTION 3
            // MICR REPAIR REPORT
            // =================================================

            else if (choice == 3) {

                System.out.println();
                System.out.println(
                        "Generating MICR Repair Report..."
                );


                JasperReportRunner.generatePDF(
                        "reports/micr_repair_report.jrxml",
                        "output/micr_repair_report.pdf",
                        new HashMap<>()
                );


                System.out.println();
                System.out.println(
                        "PDF : output/micr_repair_report.pdf"
                );
            }


            // =================================================
            // OPTION 4
            // HIGH VALUE CHEQUE REPORT
            // amount >= 200000
            // =================================================

            else if (choice == 4) {

                System.out.println();
                System.out.println(
                        "Generating High Value Cheque Report..."
                );


                JasperReportRunner.generatePDF(
                        "reports/high_value_report.jrxml",
                        "output/high_value_report.pdf",
                        new HashMap<>()
                );


                System.out.println();
                System.out.println(
                        "PDF : output/high_value_report.pdf"
                );
            }


            // =================================================
            // OPTION 5
            // BATCH PROCESSING SUMMARY
            // =================================================

            else if (choice == 5) {

                System.out.println();
                System.out.println(
                        "Generating Batch Processing Summary..."
                );


                JasperReportRunner.generatePDF(
                        "reports/batch_summary_report.jrxml",
                        "output/batch_summary_report.pdf",
                        new HashMap<>()
                );


                System.out.println();
                System.out.println(
                        "PDF : output/batch_report_summary.pdf"
                );
            }


            // =================================================
            // OPTION 6
            // BANK-WISE PROCESSING SUMMARY
            // =================================================

            else if (choice == 6) {

                System.out.println();
                System.out.println(
                        "Generating Bank-wise Processing Summary..."
                );


                JasperReportRunner.generatePDF(
                        "reports/bank_summary_report.jrxml",
                        "output/bank_summary_report.pdf",
                        new HashMap<>()
                );


                System.out.println();
                System.out.println(
                        "PDF : output/bank_summary_report.pdf"
                );
            }


            // =================================================
            // OPTION 7
            // CTS DAILY OPERATIONS DASHBOARD
            // =================================================

            else if (choice == 7) {

                System.out.println();
                System.out.println(
                        "Generating CTS Daily Operations Dashboard..."
                );


                JasperReportRunner.generatePDF(
                        "reports/cts_daily_operations_dashboard.jrxml",
                        "output/CTS_Daily_Operations_Dashboard.pdf",
                        parameters
                );


                System.out.println();
                System.out.println(
                        "PDF : output/CTS_Daily_Operations_Dashboard.pdf"
                );
            }


            // =================================================
            // OPTION 8
            // GENERATE ALL SIX REPORTS + DASHBOARD
            // =================================================

            else if (choice == 8) {

                System.out.println();
                System.out.println(
                        "=============================================="
                );

                System.out.println(
                        "GENERATING ALL CTS REPORTS"
                );

                System.out.println(
                        "=============================================="
                );


                // -------------------------------------------------
                // 1. DAILY CHEQUE
                // -------------------------------------------------

                System.out.println();
                System.out.println(
                        "1. Daily Cheque Processing Report"
                );


                JasperReportRunner.generatePDF(
                        "reports/daily_cheque_report.jrxml",
                        "output/daily_cheque_report.pdf",
                        parameters
                );


                // -------------------------------------------------
                // 2. REJECTED CHEQUE
                // -------------------------------------------------

                System.out.println();
                System.out.println(
                        "2. Rejected Cheque Report"
                );


                Map<String, Object> rejectedParameters =
                        new HashMap<>();


                rejectedParameters.put(
                        "P_STATUS",
                        "REJECTED"
                );


                JasperReportRunner.generatePDF(
                        "reports/rejected_cheque_report.jrxml",
                        "output/rejected_cheque_report.pdf",
                        rejectedParameters
                );


                // -------------------------------------------------
                // 3. MICR REPAIR
                // -------------------------------------------------

                System.out.println();
                System.out.println(
                        "3. MICR Repair Report"
                );


                JasperReportRunner.generatePDF(
                        "reports/micr_repair_report.jrxml",
                        "output/micr_repair_report.pdf",
                        new HashMap<>()
                );


                // -------------------------------------------------
                // 4. HIGH VALUE
                // -------------------------------------------------

                System.out.println();
                System.out.println(
                        "4. High Value Cheque Report"
                );


                JasperReportRunner.generatePDF(
                        "reports/high_value_report.jrxml",
                        "output/high_value_report.pdf",
                        new HashMap<>()
                );


                // -------------------------------------------------
                // 5. BATCH SUMMARY
                // -------------------------------------------------

                System.out.println();
                System.out.println(
                        "5. Batch Processing Summary"
                );


                JasperReportRunner.generatePDF(
                        "reports/batch_summary_report.jrxml",
                        "output/batch_summary_report.pdf",
                        new HashMap<>()
                );


                // -------------------------------------------------
                // 6. BANK SUMMARY
                // -------------------------------------------------

                System.out.println();
                System.out.println(
                        "6. Bank-wise Processing Summary"
                );


                JasperReportRunner.generatePDF(
                        "reports/bank_summary_report.jrxml",
                        "output/bank_summary_report.pdf",
                        new HashMap<>()
                );


                // -------------------------------------------------
                // 7. DASHBOARD
                // -------------------------------------------------

                System.out.println();
                System.out.println(
                        "7. CTS Daily Operations Dashboard"
                );


                JasperReportRunner.generatePDF(
                        "reports/cts_daily_operations_dashboard.jrxml",
                        "output/CTS_Daily_Operations_Dashboard.pdf",
                        parameters
                );


                // -------------------------------------------------
                // COMPLETION
                // -------------------------------------------------

                System.out.println();
                System.out.println(
                        "=============================================="
                );

                System.out.println(
                        "ALL REPORTS GENERATED SUCCESSFULLY"
                );

                System.out.println(
                        "=============================================="
                );

                System.out.println();
                System.out.println(
                        "Output files:"
                );

                System.out.println(
                        "1. output/daily_cheque_report.pdf"
                );

                System.out.println(
                        "2. output/rejected_cheque_report.pdf"
                );

                System.out.println(
                        "3. output/micr_repair_report.pdf"
                );

                System.out.println(
                        "4. output/high_value_report.pdf"
                );

                System.out.println(
                        "5. output/batch_summary_report.pdf"
                );

                System.out.println(
                        "6. output/bank_summary_report.pdf"
                );

                System.out.println(
                        "7. output/CTS_Daily_Operations_Dashboard.pdf"
                );
            }


            // =================================================
            // INVALID OPTION
            // =================================================

            else {

                System.out.println();
                System.out.println(
                        "Invalid choice. Please select 0-8."
                );
            }
        }


        scanner.close();
    }
}