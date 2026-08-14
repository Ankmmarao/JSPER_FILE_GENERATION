package com.iispl.main;

import java.io.File;
import java.sql.Connection;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.export.SimpleCsvExporterConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

public class JasperReportRunner {

    // =========================================================
    // CSV REPORT GENERATION
    // =========================================================

    public static void generateCSV(
            String jrxmlPath,
            String outputPath,
            Map<String, Object> parameters) {

        try {

            // Check JRXML file
            File jrxmlFile = new File(jrxmlPath);

            if (!jrxmlFile.exists()) {
                throw new Exception(
                        "JRXML file not found: "
                                + jrxmlFile.getAbsolutePath()
                );
            }

            // Create output directory
            File outputFile = new File(outputPath);
            File parent = outputFile.getParentFile();

            if (parent != null && !parent.exists()) {
                if (!parent.mkdirs() && !parent.exists()) {
                    throw new Exception(
                            "Unable to create output directory: "
                                    + parent.getAbsolutePath()
                    );
                }
            }

            System.out.println("Compiling JRXML...");

            // Compile JRXML
            JasperReport report =
                    JasperCompileManager.compileReport(
                            jrxmlFile.getAbsolutePath()
                    );

            System.out.println("JRXML compiled successfully.");

            // Database connection
            try (Connection connection =
                         DBConnection.getDataSource().getConnection()) {

                System.out.println(
                        "Database connection established."
                );

                // Fill report
                JasperPrint print =
                        JasperFillManager.fillReport(
                                report,
                                parameters,
                                connection
                        );

                System.out.println(
                        "Report filled successfully."
                );

                // CSV exporter
                JRCsvExporter exporter =
                        new JRCsvExporter();

                exporter.setExporterInput(
                        new SimpleExporterInput(print)
                );

                exporter.setExporterOutput(
                        new SimpleWriterExporterOutput(
                                outputPath
                        )
                );

                // CSV configuration
                SimpleCsvExporterConfiguration configuration =
                        new SimpleCsvExporterConfiguration();

                exporter.setConfiguration(
                        configuration
                );

                // Export CSV
                exporter.exportReport();

                System.out.println(
                        "CSV created successfully:"
                );

                System.out.println(
                        new File(outputPath)
                                .getAbsolutePath()
                );
            }

        } catch (Exception e) {

            System.err.println(
                    "CSV generation failed: "
                            + e.getMessage()
            );

            e.printStackTrace();
        }
    }

//pdf generation
 public static void generatePDF(
         String jrxmlPath,
         String outputPath,
         Map<String, Object> parameters) {

	 
     try {

         // Check JRXML file
         File jrxmlFile = new File(jrxmlPath);

         if (!jrxmlFile.exists()) {
             throw new Exception(
                     "JRXML file not found: "
                             + jrxmlFile.getAbsolutePath()
             );
         }

         // Create output directory
         File outputFile = new File(outputPath);
         File parent = outputFile.getParentFile();

         if (parent != null && !parent.exists()) {
             if (!parent.mkdirs() && !parent.exists()) {
                 throw new Exception(
                         "Unable to create output directory: "
                                 + parent.getAbsolutePath()
                 );
             }
         }

         System.out.println("Compiling JRXML...");

         // Compile JRXML
         JasperReport report =
                 JasperCompileManager.compileReport(
                         jrxmlFile.getAbsolutePath()
                 );

         System.out.println(
                 "JRXML compiled successfully."
         );

         // Database connection
         try (Connection connection =
                      DBConnection.getDataSource().getConnection()) {

             System.out.println(
                     "Database connection established."
             );

             // Fill report
             JasperPrint print =
                     JasperFillManager.fillReport(
                             report,
                             parameters,
                             connection
                     );

             System.out.println(
                     "Report filled successfully."
             );
             JasperExportManager.exportReportToPdfFile(
                     print,
                     outputFile.getAbsolutePath()
             );

             System.out.println(
                     "PDF created successfully:"
             );

             System.out.println(
                     outputFile.getAbsolutePath()
             );
         }

     } catch (Exception e) {

         System.err.println(
                 "PDF generation failed: "
                         + e.getMessage()
         );

         e.printStackTrace();
     }
 }

    
    
    
    
    

}