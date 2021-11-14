package com.acidonpe.jumpapp.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import com.acidonpe.jumpapp.grpc.proto.*;
import com.acidonpe.jumpapp.grpc.GrpcClientService;

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

        Response reply;

        // Evaluate jumps to send response or perform a jump
        if (req.getJumpsCount() == 0 || req.getCount() == 2 || req.getJumps(0) == "") {
            // Log
            System.out.println("gRPC Server: Send response 200");
            
            // Reply response when no jumps are included
            reply = Response.newBuilder()
            .setMessage("/jump - Greetings from SpringBoot gRPC! | Jumps: " + Integer.toString(count))
            .setCode(200)
            .build();
        } else {
            // Perform the respective Jump
            Response responseJump = new GrpcClientService().sendMessage(req);

            // Log
            System.out.println("gRPC Server: Response received" + responseJump);

            // Reply
            reply = Response.newBuilder().setMessage("Bye ==> " + req.getCount()).build();
        }

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}