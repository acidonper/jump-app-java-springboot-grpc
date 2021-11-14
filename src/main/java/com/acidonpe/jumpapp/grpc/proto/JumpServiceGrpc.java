package com.acidonpe.jumpapp.grpc.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: jump.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class JumpServiceGrpc {

  private JumpServiceGrpc() {}

  public static final String SERVICE_NAME = "jump.JumpService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.acidonpe.jumpapp.grpc.proto.JumpReq,
      com.acidonpe.jumpapp.grpc.proto.Response> getJumpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Jump",
      requestType = com.acidonpe.jumpapp.grpc.proto.JumpReq.class,
      responseType = com.acidonpe.jumpapp.grpc.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.acidonpe.jumpapp.grpc.proto.JumpReq,
      com.acidonpe.jumpapp.grpc.proto.Response> getJumpMethod() {
    io.grpc.MethodDescriptor<com.acidonpe.jumpapp.grpc.proto.JumpReq, com.acidonpe.jumpapp.grpc.proto.Response> getJumpMethod;
    if ((getJumpMethod = JumpServiceGrpc.getJumpMethod) == null) {
      synchronized (JumpServiceGrpc.class) {
        if ((getJumpMethod = JumpServiceGrpc.getJumpMethod) == null) {
          JumpServiceGrpc.getJumpMethod = getJumpMethod =
              io.grpc.MethodDescriptor.<com.acidonpe.jumpapp.grpc.proto.JumpReq, com.acidonpe.jumpapp.grpc.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Jump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.acidonpe.jumpapp.grpc.proto.JumpReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.acidonpe.jumpapp.grpc.proto.Response.getDefaultInstance()))
              .setSchemaDescriptor(new JumpServiceMethodDescriptorSupplier("Jump"))
              .build();
        }
      }
    }
    return getJumpMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JumpServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JumpServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JumpServiceStub>() {
        @java.lang.Override
        public JumpServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JumpServiceStub(channel, callOptions);
        }
      };
    return JumpServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JumpServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JumpServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JumpServiceBlockingStub>() {
        @java.lang.Override
        public JumpServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JumpServiceBlockingStub(channel, callOptions);
        }
      };
    return JumpServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JumpServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JumpServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JumpServiceFutureStub>() {
        @java.lang.Override
        public JumpServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JumpServiceFutureStub(channel, callOptions);
        }
      };
    return JumpServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class JumpServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void jump(com.acidonpe.jumpapp.grpc.proto.JumpReq request,
        io.grpc.stub.StreamObserver<com.acidonpe.jumpapp.grpc.proto.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJumpMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getJumpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.acidonpe.jumpapp.grpc.proto.JumpReq,
                com.acidonpe.jumpapp.grpc.proto.Response>(
                  this, METHODID_JUMP)))
          .build();
    }
  }

  /**
   */
  public static final class JumpServiceStub extends io.grpc.stub.AbstractAsyncStub<JumpServiceStub> {
    private JumpServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JumpServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JumpServiceStub(channel, callOptions);
    }

    /**
     */
    public void jump(com.acidonpe.jumpapp.grpc.proto.JumpReq request,
        io.grpc.stub.StreamObserver<com.acidonpe.jumpapp.grpc.proto.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJumpMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class JumpServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<JumpServiceBlockingStub> {
    private JumpServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JumpServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JumpServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.acidonpe.jumpapp.grpc.proto.Response jump(com.acidonpe.jumpapp.grpc.proto.JumpReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJumpMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class JumpServiceFutureStub extends io.grpc.stub.AbstractFutureStub<JumpServiceFutureStub> {
    private JumpServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JumpServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JumpServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.acidonpe.jumpapp.grpc.proto.Response> jump(
        com.acidonpe.jumpapp.grpc.proto.JumpReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJumpMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_JUMP = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JumpServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JumpServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_JUMP:
          serviceImpl.jump((com.acidonpe.jumpapp.grpc.proto.JumpReq) request,
              (io.grpc.stub.StreamObserver<com.acidonpe.jumpapp.grpc.proto.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class JumpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JumpServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.acidonpe.jumpapp.grpc.proto.JumpProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("JumpService");
    }
  }

  private static final class JumpServiceFileDescriptorSupplier
      extends JumpServiceBaseDescriptorSupplier {
    JumpServiceFileDescriptorSupplier() {}
  }

  private static final class JumpServiceMethodDescriptorSupplier
      extends JumpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    JumpServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (JumpServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JumpServiceFileDescriptorSupplier())
              .addMethod(getJumpMethod())
              .build();
        }
      }
    }
    return result;
  }
}
