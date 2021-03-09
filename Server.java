import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends MST{
    private Server(){}

    public static void main(String args[]){
        try {
            // Instantiating the implementation class
            MST obj = new MST();

            MSTinterface stub = (MSTinterface) UnicastRemoteObject.exportObject(obj, 0);

            // Binding the remote object (stub) in the registry
            LocateRegistry.createRegistry(2001);
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 2001);
            registry.bind("MSTinterface", stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}