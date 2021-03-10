import java.rmi.Remote;
import java.rmi.RemoteException;

// Creating Remote interface for our application
public interface MSTinterface extends Remote {

    public abstract void add_graph(String name, int n) throws RemoteException;

    public abstract void add_edge(String name, int u, int v, int w) throws RemoteException;

    public abstract int get_mst(String name) throws RemoteException;
}
