package com.assignment.pro3assignment.grpc;

import via.pro3.grpcspringbootexample.grpc.Product;

public class ModelToGrpc {
    public static Product productToGrpc(Product product) {
        if (product == null) return null;
        Product.Builder productBuilder = Product.newBuilder().setProductReg(product.getProductReg());

        productBuilder.addAllPartsIncluded(product.getPartsIncludedList());
        productBuilder.addAllRefToPart(product.getRefToPartList());
        productBuilder.addAllRefToAnimals(product.getRefToAnimalsList());

        return productBuilder.build();
    }
}
