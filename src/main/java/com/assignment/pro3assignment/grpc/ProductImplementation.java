package com.assignment.pro3assignment.grpc;

import com.assignment.pro3assignment.Business.InterfaceStation3;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import via.pro3.grpcspringbootexample.grpc.*;

import java.util.List;

@GrpcService
public class ProductImplementation extends station3ServiceGrpc.station3ServiceImplBase {

    private InterfaceStation3 station3;


    public ProductImplementation(InterfaceStation3 station3) {
        this.station3 = station3;
    }

    @Override
    public void getAllAnimalsByProduct(Product request, StreamObserver<ListOfAnimalRefs> responseObserver) {
        try {
            List<String> animalRefs = station3.getAllAnimalsByProduct(request.getProductReg());

            ListOfAnimalRefs.Builder responseBuilder = ListOfAnimalRefs.newBuilder();

            for (String animalRef : animalRefs) {
                responseBuilder.addAnimalRef(animalRef);
            }

            responseObserver.onNext(responseBuilder.build());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error fetching animal references: " + e.getMessage()).asRuntimeException());
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAllProductsByAnimal(AnimalRef animalRef, StreamObserver<ListOfProducts> responseObserver) {
        try {
            List<com.assignment.pro3assignment.Model.Product> products = station3.getAllProductsByAnimal(animalRef.getAnimalRef());

            ListOfProducts.Builder responseBuilder = ListOfProducts.newBuilder();

            for (com.assignment.pro3assignment.Model.Product product : products) {
                Product grpcProduct = ModelToGrpc.productToGrpc(product);
                responseBuilder.addProducts(grpcProduct);
            }

            responseObserver.onNext(responseBuilder.build());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error fetching products: " + e.getMessage()).asRuntimeException());
        } finally {
            responseObserver.onCompleted();
        }
    }


}
