import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class Client{
    private Client(){}

    public static void main(String args[]){
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(args[0], Integer.parseInt(args[1]));

            // Looking up the registry for the remote object
            MSTinterface stub = (MSTinterface) registry.lookup("MSTinterface");

            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()){
                String cmd = scanner.nextLine();
                String[] arr = cmd.split(" ");

                if(arr[0].equals("add_graph")){
                    int n = Integer.parseInt(arr[2]);
                    stub.add_graph(arr[1], n);
                }
                else if(arr[0].equals("add_edge")){
                    int u = Integer.parseInt(arr[2]);
                    int v = Integer.parseInt(arr[3]);
                    int w = Integer.parseInt(arr[4]);
                    stub.add_edge(arr[1], u, v, w);
                }
                else if(arr[0].equals("get_mst")){
                    int weight = stub.get_mst(arr[1]);
                    System.out.println(weight);
                }
                else{
                    System.out.println("Invalid command");
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}