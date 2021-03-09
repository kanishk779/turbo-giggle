import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.HashMap;

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
        int [] par;
        int [] quantity;
        public Graph(int n){
            this.n = n;
        }

        public void add_edge(int u, int v, int w){
            Edge curr_edge = new Edge(u-1, v-1, w);
            adj.add(curr_edge);
        }
        int find_set(int v) {
            if (v == par[v])
                return v;
            return par[v] = find_set(par[v]);
        }
        boolean union_sets(int a, int b) {
            a = find_set(a);
            b = find_set(b);
            if (a != b) {
                if (quantity[a] < quantity[b]) {
                    int t = a;
                    a = b;
                    b = t;
                }
                par[b] = a;
                quantity[a] += quantity[b];
                return true;
            }
            return false;
        }
        public int give_mst(){
            if(adj.size() == 0 || adj.size() == 1)
                return 0;
            PriorityQueue<Edge> pq = new PriorityQueue<>(adj.size(), Comparator.comparingInt(o -> o.w));
            par = new int[n];
            quantity = new int[n];
            for (int i=0; i<n; i++){
                par[i] = i;
                quantity[i] = 1;
            }
            for(int i=0; i < adj.size(); i++){
                pq.add(adj.get(i));
            }
            int edges_added = 0;
            int ans = 0;
            while(true){
                Edge edge = pq.poll();
                if(edge == null)
                    break;
                int u = edge.s;
                int v = edge.d;
                int w = edge.w;
                if(union_sets(u, v)){
                    ans += w;
                    edges_added += 1;
                }
                if(edges_added == n-1)
                    break;
            }
            if(edges_added < n-1)
                return -1;
            else
                return ans;
        }
    }

    HashMap<String, Graph> map = new HashMap<>();

    public void add_graph(String name, int n){
        if(map.containsKey(name)) {
            System.out.println("The graph with similar id already exists :( ");
            return;
        }
        Graph graph = new Graph(n);
        map.put(name, graph);
        return;
    }

    public void add_edge(String name, int u, int v, int w){
        if(map.containsKey(name) == false) {
            System.out.println("The graph with this id does not exists :( ");
            return;
        }
        Graph graph = map.get(name);
        graph.add_edge(u, v, w);
        map.put(name, graph);
        return;
    }

    public int get_mst(String name){
        if(map.containsKey(name) == false) {
            System.out.println("The graph with this id does not exists :( ");
            return -1;
        }
        Graph graph = map.get(name);
        return graph.give_mst();
    }
}