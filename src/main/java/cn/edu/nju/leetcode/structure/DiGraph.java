package cn.edu.nju.leetcode.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/21
 */
public class DiGraph {
    private List<List<Integer>> adj;

    private final int V;

    public DiGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public DiGraph reverse() {
        DiGraph r = new DiGraph(V);
        for (int i = 0; i < V; i++) {
            for (int w : adj.get(i)) {
                r.addEdge(w, i);
            }
        }
        return r;
    }

    public List<Integer> adj(int v) {
        return adj.get(v);
    }

    public int V() {
        return V;
    }
}
