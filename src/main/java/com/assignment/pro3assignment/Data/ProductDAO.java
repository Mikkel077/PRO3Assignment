package com.assignment.pro3assignment.Data;

import com.assignment.pro3assignment.Model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.sql.SQLException;
import java.util.*;

@Component
@Scope("singleton")
public class ProductDAO implements Persistence {

    private DatabaseHelper<Product> dbHelper;

    public ProductDAO(DatabaseHelper<Product> dbHelper) {
        this.dbHelper = dbHelper;
    }


    private Product createProduct(ResultSet rs) throws SQLException {
        Array partsIncludedArray = rs.getArray("parts_included");
        Array refToPartsArray = rs.getArray("ref_to_parts");
        String productReg = rs.getString("product_reg");
        Array refToAnimals = rs.getArray("ref_to_animals");

        List<String> partsIncluded = new ArrayList<>();

        if (partsIncludedArray != null) {
            String[] partsArray = (String[]) partsIncludedArray.getArray();
            partsIncluded = Arrays.asList(partsArray);
        }

        List<String> refToParts = new ArrayList<>();
        if (refToPartsArray != null) {
            String[] refToArray = (String[]) refToPartsArray.getArray();
            refToParts = Arrays.asList(refToArray);
        }

        List<String> refToAnimal = new ArrayList<>();
        if (refToAnimals != null) {
            String[] refToArray = (String[]) refToAnimals.getArray();
            refToAnimal = Arrays.asList(refToArray);
        }

        return new Product(partsIncluded, refToParts, productReg, refToAnimal);
    }


    @Override
    public Collection<String> getAllAnimalsByProduct(String productReg) {
        try {
            List<Product> listOfProducts = dbHelper.map(this::createProduct, "SELECT * FROM product WHERE product_reg = ?", productReg);

            List<String> animals = new ArrayList<>();
            for (Product product : listOfProducts) {
                animals.addAll(product.getRefToAnimals());
            }

            return animals;

        } catch (com.assignment.pro3assignment.Data.SQLException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Product> getAllProductsByAnimal(String animalRef) {
        try {
            return dbHelper.map(this::createProduct, "SELECT * FROM product WHERE animal_ref = ?", animalRef);
        } catch (com.assignment.pro3assignment.Data.SQLException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
