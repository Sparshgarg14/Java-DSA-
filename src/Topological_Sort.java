import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Topological_Sort {
    private HashMap<Integer, HashMap<Integer, Integer>> map;

    public Topological_Sort(int v) {
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {  // Changed to initialize from 1 to v
            map.put(i, new HashMap<>());
        }
    }

    public void addedge(int v1, int v2) {
        map.get(v1).put(v2, 0);
    }

    public int[] Indegree() {
        int v = map.size() + 1;  // Changed to +1 to account for 1-based indexing
        int[] arr = new int[v];
        for (int v1 : map.keySet()) {
            for (int v2 : map.get(v1).keySet()) {
                arr[v2]++;
            }
        }
        return arr;
    }

    public void Topological() {
        int[] in = Indegree();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < in.length; i++) {  // Changed to start from 1 to in.length
            if (in[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v + " ");  // Changed to print without a newline
            for (int nbrs : map.get(v).keySet()) {
                in[nbrs]--;
                if (in[nbrs] == 0) {
                    q.add(nbrs);
                }
            }
        }
        System.out.println();  // Added to end with a newline after the loop
    }

    public boolean Iscycle() {
        int[] in = Indegree();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;  // Added to count processed vertices
        for (int i = 1; i < in.length; i++) {  // Changed to start from 1 to in.length
            if (in[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int v = q.poll();
            count++;
            for (int nbrs : map.get(v).keySet()) {
                in[nbrs]--;
                if (in[nbrs] == 0) {
                    q.add(nbrs);
                }
            }
        }
        return count != map.size();  // Changed to check if all vertices are processed
    }

    public static void main(String[] args) {
        Topological_Sort ts = new Topological_Sort(7);
        ts.addedge(1, 2);
        ts.addedge(1, 0);
        ts.addedge(1, 4);
        ts.addedge(4, 3);
        ts.addedge(3, 2);
        ts.addedge(4, 5);
        ts.addedge(5, 7);
        ts.addedge(6, 3);
        ts.addedge(6, 7);
        ts.Topological();
        System.out.println("Cycle detected: " + ts.Iscycle());
    }
}
