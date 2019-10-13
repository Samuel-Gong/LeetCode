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
public class EdgeWeightedDigraph {
    /**
     * 顶点总数
     */
    private final int V;

    /**
     * 边的总数
     */
    private int E;

    /**
     * 邻接表
     */
    private List<List<DirectedEdge>> adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            adj.add(new ArrayList<>());
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj.get(e.from()).add(e);
        E++;
    }

    /**
     * 从 v 指出的边
     *
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> adj(int v) {
        return adj.get(v);
    }

    /**
     * 该有向图的所有边
     *
     * @return
     */
    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> bag = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            bag.addAll(adj.get(v));
        }
        return bag;
    }
}
