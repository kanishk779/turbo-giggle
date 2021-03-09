import java.rmi.Remote;
import java.rmi.RemoteException;

// Creating Remote interface for our application
public interface MSTinterface extends Remote {

    public void add_graph(String name, int n) throws RemoteException;

    public void add_edge(String name, int u, int v, int w);

    public int get_mst(String name);
}