# Jump App Java Springboot gRPC Repository

This repository includes a microservice based on Java Springboot and gRPC that is a component develop for Jump App application. The idea of this microservice is implement an API based on gRPC that emulates the current features implemented in the original Jump App Java SpringBoot microservice.

## Quick Start Java Springboot Demo

Once the demo project has been uploaded, it is required to execute the following process:

- Download Maven Dependencies
- Package the application
- Execute the Application

## Java Springboot Test

Java Springboot Demo included a set of test in order to check all features.

## Test Demo App API Locally

- Use a **grpcurl** command to test the app running (_* or create a main.go function as shown before_)

```$bash
grpcurl -plaintext -d '{"count": 0, "message": "hola", "jumps": ["localhost:50053","localhost:50053"]}' localhost:50053 jump.JumpService/Jump
{
  "code": 200,
  "message": "/ - Greetings from SpringBoot gRPC! | Jumps: 3"
}
```
# Author

Asier Cidon

asier.cidon@gmail.com

