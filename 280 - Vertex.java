import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Traversing {
    public static class Graph {
        public int V;
        public LinkedList<Integer> adj[];
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }
        void addEdge(int v, int w) {
            adj[v].add(w);
        }
        void findPath(Integer v,Graph graph) {
            int index =0;
            int array[] = new int[graph.V];
            for (int i = 0; i < graph.V; i++) {
                int flag =0;
                for (Integer pCrawl : graph.adj[v]) {
                   if(pCrawl == (i+1)) {
                       flag = 1;
                   }
                }
                if(flag == 0) {
                    array[index] = (i+1);
                    index++;
                }
            }
            System.out.print(index + " ");
            for (int i = 0; i <index ; i++) {
                    System.out.print(array[i] + " ");
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("traversing.in"));
        int num = input.nextInt();
        while (num!=0){
            Graph g = new Graph(num);
            for (int i = 0; i < num; i++) {
                int source = input.nextInt();
                int distination = input.nextInt();
                while(distination!=0) {
                    g.addEdge(source-1, distination);
                    distination = input.nextInt();
                }
            }
            int zero = input.nextInt();
            int len = input.nextInt();
            for (int i = 0; i <len ; i++) {
                int vertex = input.nextInt();
                g.findPath((vertex-1),g);
                System.out.println();
            }
            num = input.nextInt();
        }
    }
}
