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

Java RMI internally handles the marshalling of 'arguments to the method' and
transporting it on a network to the server. The arguments are un-marshalled on
the server side. The server needs to bind the object to registry which is
running on a specified port (port number can be given by user). Using the IP
address and port number of registry on server, client can access the remote
object and perform the **RPC**. RMI is thread safe which means that multiple
clients can simultaneously call remote methods on stub and RMI guarantees mutual
exclusion.
![image showing RMI](rmiworking.png "RMI Working")

## Algorithm
