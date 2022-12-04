package com.example.grpcclient.service;

import com.example.grpcclient.proto_gen.Request;
import com.example.grpcclient.proto_gen.TestGrpcServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcTestService {
    @GrpcClient("grpc-server")
    private TestGrpcServiceGrpc.TestGrpcServiceBlockingStub stub;

    public void printResponse(Request request) {
        var response = stub.test(request);
        System.out.println(response.getMessage());
    }
}
