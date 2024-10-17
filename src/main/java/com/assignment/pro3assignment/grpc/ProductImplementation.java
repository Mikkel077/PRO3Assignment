package com.assignment.pro3assignment.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import via.pro3.grpcspringbootexample.grpc.*;

@GrpcService
public class ProductImplementation extends station3ServiceGrpc.station3ServiceImplBase {

    @Override
    public void getAllAnimalsByProduct(Product request, StreamObserver<ListOfAnimalRefs> responseObserver) {


        //ListOfAnimalRefs response = ListOfAnimalRefs.newBuilder()

        // responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllProductsByAnimal(AnimalRef animalRef, StreamObserver<ListOfProducts> responseObserver) {

        //ListOfProducts response = ListOfProducts.newBuilder()

        //responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


}
