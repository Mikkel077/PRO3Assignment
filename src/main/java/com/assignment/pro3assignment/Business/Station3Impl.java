package com.assignment.pro3assignment.Business;

import com.assignment.pro3assignment.Model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Station3Impl implements InterfaceStation3 {
    @Override
    public List<String> getAllAnimalsByProduct(Product product) {
        return List.of();
    }

    @Override
    public List<via.pro3.grpcspringbootexample.grpc.Product> getAllProductsByAnimal(String animalRef) {
        return List.of();
    }


}
