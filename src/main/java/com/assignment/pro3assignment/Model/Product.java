package com.assignment.pro3assignment.Model;

import java.util.List;



public class Product {
    private List<String> partsIncluded;
    private List<String> refToParts;
    private String productReg;
    private List<String> refToAnimals;

    public Product(List<String> partsIncluded, List<String> refToParts, String productReg, List<String> refToAnimals) {
        this.partsIncluded = partsIncluded;
        this.refToParts = refToParts;
        this.productReg = productReg;
        this.refToAnimals = refToAnimals;
    }

    public List<String> getPartsIncluded() {
        return partsIncluded;
    }

    public List<String> getRefToParts() {
        return refToParts;
    }

    public String getProductReg() {
        return productReg;
    }

    public List<String> getRefToAnimals() {
        return refToAnimals;
    }

    @Override
    public String toString() {
        return "Product{" +
                "partsIncluded=" + partsIncluded +
                ", refToParts=" + refToParts +
                ", productReg='" + productReg + '\'' +
                ", refToAnimals=" + refToAnimals +
                '}';
    }

}
