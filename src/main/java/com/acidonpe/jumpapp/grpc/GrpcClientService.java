package com.acidonpe.jumpapp.grpc;

import net.devh.boot.grpc.client.inject.GrpcClient;
import com.acidonpe.jumpapp.grpc.proto.JumpServiceGrpc.JumpServiceBlockingStub;
import org.springframework.stereotype.Service;
import io.grpc.StatusRuntimeException;
import com.acidonpe.jumpapp.grpc.proto.*;

@Service
public class GrpcClientService {

    @GrpcClient("local-grpc-server")
    private JumpServiceBlockingStub jumpStub;

    public Response sendMessage(final JumpReq request) {
        // log
        System.out.println("gRPC Client: Request received " + request);
        try {
            final Response response = this.jumpStub.jump(request);
            // final Response response = this.jumpStub.jump(JumpReq.newBuilder().addJumps("").setMessage("pepe").build());
            return response;
        } catch (final StatusRuntimeException e) {
            return Response.newBuilder()
            .setMessage("/jump - Greetings from SpringBoot gRPC! | Jumps: " + Integer.toString(request.getCount()))
            .setCode(400)
            .build();
        }
    }

}
