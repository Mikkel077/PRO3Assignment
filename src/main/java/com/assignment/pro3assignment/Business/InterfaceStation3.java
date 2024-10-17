package com.assignment.pro3assignment.Business;

import via.pro3.grpcspringbootexample.grpc.Product;

import java.util.List;

public interface InterfaceStation3 {
    public List<String> getAllAnimalsByProduct(com.assignment.pro3assignment.Model.Product product);
    public List<Product> getAllProductsByAnimal(String animalRef);
}
