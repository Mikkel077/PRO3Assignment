package com.assignment.pro3assignment.Data;

import com.assignment.pro3assignment.Model.Product;

import java.util.Collection;


public class dbTest {
    private ProductDAO productDAO;

    public dbTest(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Collection<String> test(String product) {
        return productDAO.getAllAnimalsByProduct(product);
    }

    public static void main(String[] args) throws SQLException {

        DatabaseHelper<Product> dbhelper = new DatabaseHelper<Product>("jdbc:postgresql://localhost:5432/postgres", "postgres", "mikkel");
        ProductDAO productDAO1 = new ProductDAO(dbhelper);
        dbTest test = new dbTest(productDAO1);

        Collection<String> animal = test.test("P003");

        for (String element : animal) {
            System.out.println(element);
        }
    }
}
