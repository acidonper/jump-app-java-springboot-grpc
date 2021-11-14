package com.acidonpe.jumpapp.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import com.acidonpe.jumpapp.grpc.proto.*;
import com.acidonpe.jumpapp.grpc.GrpcClientService;

import java.util.ArrayList;
import java.util.List;
@GrpcService
public class GrpcServerService extends JumpServiceGrpc.JumpServiceImplBase {

    @Override
    public void jump(JumpReq req, StreamObserver<Response> responseObserver) {
        // Log
        System.out.println("gRPC Server: Request received " + req);

        // Add a new count
        int count = req.getCount() + 1;

        // Log
        System.out.println("gRPC Server: Steps count " + Integer.toString(count));

        // Add Defined Jumps
        List<String> jumpList = new ArrayList<String>();
        if (req.getJumpsCount() > 0 && req.getCount() > 1) {
            for (int i = 1; i<req.getJumpsCount(); i = i + 1) {
                jumpList.add(req.getJumps(i));
            }
        } else {
            jumpList = req.getJumpsList();
        } 

        // Creating new jump request
        JumpReq newJump = JumpReq
        .newBuilder()
        .setCount(count)
        .setMessage(req.getMessage())
        .addAllJumps(jumpList)
        .build();

        // Create response object
        Response responseJump;

        // Evaluate jumps to send response or perform a jump
        if (newJump.getJumpsCount() == 0 || newJump.getJumps(0) == "") {
            // Log
            System.out.println("gRPC Server: Send response 200");
            
            // Reply response when no jumps are included
            responseJump = Response.newBuilder()
            .setMessage("/jump - Greetings from SpringBoot gRPC! | Jumps: " + Integer.toString(count))
            .setCode(200)
            .build();
        } else {
            // Perform the respective Jump
            responseJump = new GrpcClientService().sendMessage(newJump);

            // Log
            System.out.println("gRPC Server: Response received " + responseJump);
        }

        responseObserver.onNext(responseJump);
        responseObserver.onCompleted();
    }

}