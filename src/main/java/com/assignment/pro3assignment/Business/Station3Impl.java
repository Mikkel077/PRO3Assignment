package com.assignment.pro3assignment.Business;

import com.assignment.pro3assignment.Data.Persistence;
import com.assignment.pro3assignment.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Station3Impl implements InterfaceStation3 {

    private Persistence persistence;


    public Station3Impl(Persistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public List<String> getAllAnimalsByProduct(String productReg) {
        return (List<String>) persistence.getAllAnimalsByProduct(productReg);
    }

    @Override
    public List<Product> getAllProductsByAnimal(String animalRef) {
        return (List<Product>) persistence.getAllProductsByAnimal(animalRef);
    }
}
