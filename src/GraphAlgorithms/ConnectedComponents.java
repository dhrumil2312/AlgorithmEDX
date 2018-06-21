package GraphAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
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
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<Integer>[] edges = (ArrayList<Integer>[]) new ArrayList[v];

        for(int i = 0 ; i < v ; i++){
            edges[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < e ;i++){
            //System.out.println(i);
            int start = sc.nextInt() -1 ;
            int end = sc.nextInt() -1 ;
            edges[start].add(end);
            edges[end].add(start);
        }

        System.out.println( getConnectedComponents(edges,v,e));

    }
}
