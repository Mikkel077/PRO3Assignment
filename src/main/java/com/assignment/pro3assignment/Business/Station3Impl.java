package com.assignment.pro3assignment.Business;

import com.assignment.pro3assignment.Data.Persistence;
import com.assignment.pro3assignment.Model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Station3Impl implements InterfaceStation3 {

    private Persistence persistence;


    public Station3Impl(Persistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public List<String> getAllAnimalsByProduct(Product product) {
        return (List<String>) persistence.getAllAnimalsByProduct(product.getProductReg());
    }

    @Override
    public List<Product> getAllProductsByAnimal(String animalRef) {
        return (List<Product>) persistence.getAllProductsByAnimal(animalRef);
    }
}
