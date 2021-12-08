package api;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Random.*;

public class testdwg {
    public static void main(String[] args) throws FileNotFoundException {
        algo_dwg d = new algo_dwg();
        d.load("G3.json");
/*        DWG G = new DWG();
        for(int i =0;i<1000;i++){
            Node_data n = new Node_data(new Geo_location(1,1,1),0,"",0);
            G.addNode(n);
        }
        for(int i =0;i<1000;i++){
            for(int j =0 ; j<3; j++){
                Random r = new Random();
                int a = r.nextInt(1000);
                double w =(double) r.nextInt(20)+1;
                G.connect(i,a,w);
            }
        }
        d.init(G);*/
        List<NodeData> a = new LinkedList<>();
        for(int i =0; i<10;i++){
            a.add(d.getGraph().getNode(i));
        }
        System.out.println(d.tsp(a));
        d.save("src\\main\\resources\\data\\try.json");






    }
}
