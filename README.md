# turbo-giggle
JAVA RMI (MST - graph algorithm)

## Architecture
Java RMI application uses a single server multiple clients architecture. In this
specific application multiple clients can create graphs(weighted and undirected), 
add edges to the graph and query for the weight of minimum spanning tree.

Java RMI is an RPC(Remote Procedure Call) library.
The client uses a stub object which is a reference to a remote object defined
by the server. Using this it can call various methods defined for that object.
This object is an **interface** in java. A class **implements** this interface
on the server side. The choice of just exposing the **interface** is very
important as the client only needs to know the method signature and not the
hidden implementation for it.


