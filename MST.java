import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MST implements MSTinterface{
    static class Edge{
        int s, d, w;
        public Edge(int s, int d, int w){
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    static class Graph{
        int n;
        ArrayList<Edge> adj = new ArrayList<>();

        public Graph(int n){
            this.n = n;
        }

        public void add_edge(int u, int v, int w){
            Edge curr_edge = new Edge(u, v, w);
            adj.add(curr_edge);
        }

        public int give_mst(){
            if(adj.size() == 0 || adj.size() == 1)
                return 0;
            PriorityQueue<Edge> pq = new PriorityQueue<>(adj.size(), Comparator.comparingInt(o -> o.weight));
            int par = new int[n];

            for(int i=0; i < adj.size(); i++){
                pq.add(adj.get(i));
            }
        }
    }

    public void add_graph(String name, int n){

    }

    public void add_edge(String name, int u, int v, int w){

    }

    public int get_mst(String name){

    }
}