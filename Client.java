import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class Client{
    private Client(){}

    public static void main(String args[]){
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(null);

            // Looking up the registry for the remote object
            MSTinterface stub = (MSTinterface) registry.lookup("MSTinterface");

            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()){
                String cmd = scanner.nextLine();
                System.out.println(cmd);
            }
            scanner.close();
            System.out.println("Remote method invoked");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}