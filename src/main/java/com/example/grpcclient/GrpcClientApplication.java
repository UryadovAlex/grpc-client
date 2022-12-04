package com.example.grpcclient;

import com.example.grpcclient.proto_gen.Request;
import com.example.grpcclient.service.GrpcTestService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcClientApplication implements ApplicationRunner {
    private static GrpcTestService grpcTestService;

    public GrpcClientApplication(GrpcTestService grpcTestService) {
        this.grpcTestService = grpcTestService;
    }

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var request = Request.newBuilder()
                .setPayload("Alex")
                .build();
        grpcTestService.printResponse(request);
    }
}
