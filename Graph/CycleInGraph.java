package Graph;

import java.util.Map;
import java.util.List;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.HashMap;
/*
 *  Detect Cycle in an Undirected Graph
 */
public class CycleInGraph {
    
    private Map<Integer, List<Integer>> graph= new HashMap<>();
    private int vertices;
    // add number of Vertices
    public CycleInGraph(int vertices){
        this.vertices=vertices;
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
        }
    }
    //add number of Edges
    public void addEdge(int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);//because ut's undirected graph
    }
    //Check if there is any cycle
    public boolean isCycleUtil(int v, boolean[] visited, int parent){
        visited[v]=true;
        for(int neighbor:graph.get(v)){
            if (!visited[neighbor]) {
                if (isCycleUtil(neighbor, visited, v)) {
                    return true;
                }
            }else if (neighbor !=parent) {
                return true;
            }
        }
        return false;
    }

    //is Cycle
    public boolean isCycle(){
        boolean[] visited=new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (isCycleUtil(i, visited, -1)) {
                    return true;
                } 
            }
        }
        return false;
   }


   //Main
   public static void main(String[] args) {
    CycleInGraph g= new CycleInGraph(5);
    g.addEdge(0,1);
    g.addEdge(1,2);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    g.addEdge(4, 0);
    System.out.println("Cycle Detected: "+ g.isCycle());
   }
}



// public class Graph {
//     private Map<Integer, List<Integer>> graph = new HashMap<>();
//     private int vertices;

//     public Graph(int vertices) {
//         this.vertices = vertices;
//         for (int i = 0; i < vertices; i++) {
//             graph.put(i, new ArrayList<>());
//         }
//     }

//     public void addEdge(int u, int v) {
//         graph.get(u).add(v);
//         graph.get(v).add(u); // because it's an undirected graph
//     }

//     public boolean isCycleUtil(int v, boolean[] visited, int parent) {
//         visited[v] = true;
//         for (int neighbor : graph.get(v)) {
//             if (!visited[neighbor]) {
//                 if (isCycleUtil(neighbor, visited, v)) {
//                     return true;
//                 }
//             } else if (neighbor != parent) {
//                 return true;
//             }
//         }
//         return false;
//     }

//     public boolean isCycle() {
//         boolean[] visited = new boolean[vertices];
//         for (int i = 0; i < vertices; i++) {
//             if (!visited[i]) {
//                 if (isCycleUtil(i, visited, -1)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

//     public static void main(String[] args) {
//         Graph g = new Graph(5);
//         g.addEdge(0, 1);
//         g.addEdge(1, 2);
//         g.addEdge(2, 3);
//         g.addEdge(3, 4);
//         g.addEdge(4, 0); // This creates a cycle

//         System.out.println("Cycle Detected: " + g.isCycle());  // Output: Cycle Detected: true
//     }
// }
