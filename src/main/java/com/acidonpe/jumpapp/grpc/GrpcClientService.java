package com.acidonpe.jumpapp.grpc;

import org.springframework.stereotype.Service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import com.acidonpe.jumpapp.grpc.proto.*;

@Service
public class GrpcClientService {
        
    public Response sendMessage(final JumpReq request) {
        // Log
        System.out.println("gRPC Client: Request received " + request);

        // Obtaining Jump Step
        String url = request.getJumps(0);
        String[] parts = url.split(":");
        String addr = parts[0];
        int port = Integer.parseInt(parts[1]);
        System.out.println("gRPC Client: Jump to " + addr + ":" + port);

        // Creating a new channel
        ManagedChannel channel = ManagedChannelBuilder
        .forAddress(addr,port)
        .usePlaintext()
        .build();
        JumpServiceGrpc.JumpServiceBlockingStub jumpClient = JumpServiceGrpc.newBlockingStub(channel);

        try {
            // Perform the new jump
            final Response response = jumpClient.jump(request);
            return response;

        } catch (StatusRuntimeException e) {
            System.out.println("gRPC Client: Error " + e.getMessage());
            return Response.newBuilder()
            .setMessage("/jump - Farewell from SpringBoot gRPC! | Jumps: " + Integer.toString(request.getCount()))
            .setCode(400)
            .build();
        }
    }

}
