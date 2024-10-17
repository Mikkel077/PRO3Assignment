package com.assignment.pro3assignment.Data;

import com.assignment.pro3assignment.Model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductDAO implements Persistence {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    private Connection connection;
    private Statement statement;


    @PostConstruct
    private void connect() throws SQLException, java.sql.SQLException {
        connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        statement = connection.createStatement();
    }

    @Override
    public List<String> getAllAnimalsByProduct(String productReg) {
            String query = "SELECT ref_to_animals FROM product where product_reg = ?";


        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, productReg);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<String> animals = new ArrayList<>();


            while (resultSet.next()) {
                Array refToAnimalsFromQuery = resultSet.getArray("ref_to_animals");
                String[] refToAnimals = (String[]) refToAnimalsFromQuery.getArray();
                animals.addAll(Arrays.asList(refToAnimals));
            }
            return animals;
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<com.assignment.pro3assignment.Model.Product> getAllProductsByAnimal(String animalRef) {
        String query = "SELECT * FROM public.product WHERE ref_to_animals @> ARRAY['" + animalRef + "']";
        List<com.assignment.pro3assignment.Model.Product> products = new ArrayList<>();
        try {

            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                String productReg = resultSet.getString("product_reg"); // Ensure correct case
                Array partsIncluded = resultSet.getArray("parts_included");
                Array refToParts = resultSet.getArray("ref_to_parts");
                Array refToAnimals = resultSet.getArray("ref_to_animals");

                // Convert SQL arrays to List<String>
                List<String> partsIncludedList = Collections.singletonList(String.valueOf(partsIncluded));
                List<String> refToPartsList = Collections.singletonList(String.valueOf(refToParts));
                List<String> refToAnimalsList = Collections.singletonList(String.valueOf(refToAnimals));

                Product product = new Product(partsIncludedList, refToPartsList, productReg, refToAnimalsList);
                products.add(product);
            }
            return products;
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
