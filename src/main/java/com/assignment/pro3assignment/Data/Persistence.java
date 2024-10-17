package com.assignment.pro3assignment.Data;

import com.assignment.pro3assignment.Model.Product;

import java.util.List;

public interface Persistence {
    public List<String> getAllAnimalsByProduct(String productReg);
    public List<Product> getAllProductsByAnimal(String animalRef);
}
