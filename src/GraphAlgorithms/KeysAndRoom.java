package GraphAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRoom {
    private static  int DFS(ArrayList<Integer>[] edges, int[] visited , int i){

        visited[i] = 1;

        ArrayList<Integer> current = edges[i];

        for(int j : current){
            if (visited[j] == 0){
                DFS(edges,visited,j);
            }

        }
        return 0;

    }

    private static int getConnectedComponents(ArrayList<Integer>[] edges, int v, int e){

        int[] visited = new int[v];
        int noOfComponents = 0;

        for(int i = 0 ; i < v ;i++){
            if (visited[i] == 0){

                DFS(edges, visited , i);
                noOfComponents++;
            }

        }
        return noOfComponents;

    }
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();

        rooms = Arrays.asList(Arrays.asList(1,3),Arrays.asList(3,0,1),Arrays.asList(2),Arrays.asList(0));

        int v = rooms.size();

        ArrayList<Integer>[] edges = (ArrayList<Integer>[]) new ArrayList[v];

        for(int i = 0 ;i < v ; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < rooms.size(); i++){
            for(int j : rooms.get(i)){
                edges[i].add(j);
            }
        }

        if(getConnectedComponents(edges,v,0) > 0){
            System.out.println("False");
        }

        System.out.println("True");

    }
}
