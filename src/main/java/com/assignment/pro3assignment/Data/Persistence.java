package com.assignment.pro3assignment.Data;

import com.assignment.pro3assignment.Model.Product;

import java.util.Collection;
import java.util.List;

public interface Persistence {
    public Collection<String> getAllAnimalsByProduct(String productReg);
    public Collection<Product> getAllProductsByAnimal(String animalRef);
}
