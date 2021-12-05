package api;

import java.util.List;

public class algo_dwg implements DirectedWeightedGraphAlgorithms{

    DWG G = null;

    public algo_dwg(){
    }

    @Override
    public void init(DirectedWeightedGraph g) {
        this.G = (DWG)g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.G;
    }

    @Override
    public DirectedWeightedGraph copy() {

        return null;
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        return 0;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        return null;
    }

    @Override
    public NodeData center() {
        return null;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }

    @Override
    public boolean save(String file) {
        return false;
    }

    @Override
    public boolean load(String file) {
        return false;
    }
}
