package api;
import java.util.Arrays;
import java.util.Iterator;

public class testdwg {
    public static void main(String[] args) {
        DWG my_g = new DWG();
        for(int i=0; i<10; i++){
            GeoLocation p = new Geo_location(i,i,0);
            NodeData n = new Node_data(p,0," " + i,0);
            my_g.addNode(n);
        }
        my_g.connect(1,5,20);
        my_g.connect(5,1,40);
        System.out.println(my_g.getMC());
        Iterator<NodeData> iter = my_g.nodeIter();
        while (iter.hasNext()){
            Node_data n = (Node_data) iter.next();
            System.out.println(n);
        }
        my_g.removeEdge(1,5);
        System.out.println(my_g.getMC());
        iter = my_g.nodeIter();
        while (iter.hasNext()){
            Node_data n = (Node_data) iter.next();
            System.out.println(n);
        }

    }
}
