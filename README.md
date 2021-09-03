### Core Concept
**service definition**  
gRPC is based around the idea of defining a service, specifying the methods that can be called remotely with their parameters and return types

**Synchronous vs. asynchronous**  
The gRPC programming API in most languages comes in both synchronous and asynchronous flavors

**Directions**
- Unary RPC
- Server Streaming RPC
- Client Streaming RPC
- Bidirectional Streaming RPC

**Steps**
- Define a service in proto file
- Generate server and client code using protocol buffer compiler
- Use Java gRPC API to write client and server for your service
