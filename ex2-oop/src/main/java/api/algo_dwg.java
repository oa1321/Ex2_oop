package api;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;

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
        try {
            String path = "C:\\Users\\ofek alon\\IdeaProjects\\ex2-oop\\src\\main\\resources\\data\\"+file;
            JsonWriter writer = new JsonWriter(new FileWriter(path));
            writer.beginObject();
            writer.name("Edges");
            writer.beginArray();
            Iterator<EdgeData> edges = this.G.edgeIter();
            while(edges.hasNext()){
                Edge_data edge = (Edge_data) edges.next();
                writer.beginObject();
                writer.name("src").value(edge.getSrc());
                writer.name("w").value(edge.getWeight());
                writer.name("dest").value(edge.getDest());
                writer.endObject();
            }
            writer.endArray();



            writer.name("Nodes");
            writer.beginArray();
            Iterator<NodeData> nodes = this.G.nodeIter();
            while(nodes.hasNext()){
                Node_data node = (Node_data) nodes.next();
                writer.beginObject();
                writer.name("pos").value(node.getLocation().x()+","+node.getLocation().y()+","+node.getLocation().z());
                writer.name("id").value(node.getKey());
                writer.endObject();
            }
            writer.endArray();
            writer.endObject();
            writer.close();
            Type collectionType = new TypeToken< HashMap<String, ArrayList<HashMap<String, String>>>>(){}.getType();
            return true;
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean load(String file) {
        try {
            String path = "C:\\Users\\ofek alon\\IdeaProjects\\ex2-oop\\src\\main\\resources\\data\\"+file;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();

            Type collectionType = new TypeToken< HashMap<String, ArrayList<HashMap<String, String>>>>(){}.getType();
            HashMap<String, ArrayList<HashMap<String, String>>> json_g = gson.fromJson(bufferedReader, collectionType);

            ArrayList<HashMap<String, String>> e = json_g.get("Edges");
            ArrayList<HashMap<String, String>> n = json_g.get("Nodes");

            this.G = new DWG();
            Iterator<HashMap<String, String>> iter = n.iterator();
            while(iter.hasNext()){
                HashMap<String, String> curr = iter.next();
                String[] pos = curr.get("pos").split(",");
                int id =  Integer.parseInt(curr.get("id"));
                double x = Float.parseFloat(pos[0]);
                double y = Float.parseFloat(pos[1]);
                double z = Float.parseFloat(pos[2]);
                Node_data new_node = new Node_data(x,y,z,id);
                this.G.addNode(new_node);
            }
            iter = e.iterator();
            while(iter.hasNext()){
                HashMap<String, String> curr = iter.next();
                int src = Integer.parseInt(curr.get("src"));
                double w = Float.parseFloat(curr.get("w"));
                int dest = Integer.parseInt(curr.get("dest"));
                this.G.connect(src,dest,w);
            }
            return true;
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
            return false;
        }

    }

}
