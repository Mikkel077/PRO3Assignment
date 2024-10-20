package com.assignment.pro3assignment.grpc;

import via.pro3.grpcspringbootexample.grpc.Product;

public class ModelToGrpc {
    public static Product productToGrpc(com.assignment.pro3assignment.Model.Product product) {
        if (product == null) return null;
        Product.Builder productBuilder = Product.newBuilder().setProductReg(product.getProductReg());

        productBuilder.addAllPartsIncluded(product.getPartsIncluded());
        productBuilder.addAllRefToPart(product.getRefToParts());
        productBuilder.addAllRefToAnimals(product.getRefToAnimals());

        return productBuilder.build();
    }
}
