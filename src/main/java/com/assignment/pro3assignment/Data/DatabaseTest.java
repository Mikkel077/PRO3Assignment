package com.assignment.pro3assignment.Data;

import com.assignment.pro3assignment.Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTest {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/pro3assignment"; // Your target database
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "mikkel";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            System.out.println("Connection successful!");

            // Set your animal reference
            String animalRef = "animal1"; // Example animal reference

            // Directly construct the query using the animalRef variable
                String query = "SELECT ref_to_animals FROM public.product WHERE product_reg = '" + animalRef + "'";

            System.out.println("Executing query: " + query);
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Query executed successfully.");

            // Check if results were returned
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No results returned from query.");
            } else {
                int rowCount = 0;
                while (resultSet.next()) {
                    rowCount++;
                    String productReg = resultSet.getString("product_reg"); // Ensure correct case
                    Array partsIncluded = resultSet.getArray("parts_included");
                    Array refToParts = resultSet.getArray("ref_to_parts");
                    Array refToAnimals = resultSet.getArray("ref_to_animals");

                    // Convert SQL arrays to List<String>
                    List<String> partsIncludedList = convertArrayToList(partsIncluded);
                    List<String> refToPartsList = convertArrayToList(refToParts);
                    List<String> refToAnimalsList = convertArrayToList(refToAnimals);

                    Product product = new Product(partsIncludedList, refToPartsList, productReg, refToAnimalsList);
                    System.out.println(product); // Ensure your Product class has a toString() method for better output
                }
                System.out.println("Total rows returned: " + rowCount);
            }
        } catch (SQLException e) {
            System.err.println("Connection failed!");
            e.printStackTrace(); // Print the stack trace for debugging
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Helper method to convert SQL array to List
    private static List<String> convertArrayToList(Array array) throws SQLException, java.sql.SQLException {
        List<String> list = new ArrayList<>();
        if (array != null) {
            // Get the Java array from the SQL Array
            String[] stringArray = (String[]) array.getArray(); // Get the array
            for (String item : stringArray) {
                list.add(item); // Add each item to the list
            }
        }
        return list; // Return the filled list
    }
}
