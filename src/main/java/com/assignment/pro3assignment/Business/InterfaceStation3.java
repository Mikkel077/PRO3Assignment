package com.assignment.pro3assignment.Business;

import com.assignment.pro3assignment.Model.Product;

import java.util.List;

public interface InterfaceStation3 {
    public List<String> getAllAnimalsByProduct(String productReg);
    public List<Product> getAllProductsByAnimal(String animalRef);
}
