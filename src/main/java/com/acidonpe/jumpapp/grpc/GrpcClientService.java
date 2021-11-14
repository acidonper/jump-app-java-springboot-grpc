package com.acidonpe.jumpapp.grpc;

import org.springframework.stereotype.Service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.ArrayList;
import java.util.List;

import com.acidonpe.jumpapp.grpc.proto.*;

@Service
public class GrpcClientService {
        
    public Response sendMessage(final JumpReq request) {
        // Log
        System.out.println("gRPC Client: Request received " + request);

        // Obtaining Jump Step
        String url = request.getJumps(request.getJumpsCount()-1);
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

            // Add Defined Jumps
            List<String> jumpList = new ArrayList<String>();
            if (request.getJumpsCount() > 1) {
                for (int i = 0; i<request.getJumpsCount()-1; i = i + 1) {
                    jumpList.add(request.getJumps(i));
                }
            } else {
                jumpList.add("");
            }

            // Creating new jump request
            JumpReq newJump = JumpReq
            .newBuilder()
            .setCount(request.getCount())
            .setMessage(request.getMessage())
            .addAllJumps(jumpList)
            .build();

            // Perform the new jump
            final Response response = jumpClient.jump(newJump);
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
