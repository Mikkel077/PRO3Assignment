package com.assignment.pro3assignment.grpc;

import com.assignment.pro3assignment.Model.Product;

import java.util.List;

public class GrpcToModel {
    public static Product grpcToModel(via.pro3.grpcspringbootexample.grpc.Product product) {
        List<String> partsIncluded = product.getPartsIncludedList();
        List<String> refToParts = product.getRefToPartList();
        String productReg = product.getProductReg();
        List<String> refToAnimals = product.getRefToAnimalsList();


        return new Product(partsIncluded, refToParts, productReg, refToAnimals);
    }
}
