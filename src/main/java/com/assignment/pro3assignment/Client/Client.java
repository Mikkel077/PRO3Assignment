package com.assignment.pro3assignment.Client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    private final String host;
    private final int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }


    private ManagedChannel channel() {
        return ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    }




}
