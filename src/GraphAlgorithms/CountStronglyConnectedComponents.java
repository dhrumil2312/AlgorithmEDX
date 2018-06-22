package GraphAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CountStronglyConnectedComponents {


    int dfsscc(ArrayList<Integer>[] edges, int[] visited, int i){

        visited[i] = 1;
        ArrayList<Integer> current = edges[i];
        for(int node : current){
            if(visited[node]==0){
                dfsscc(edges,visited,node);
            }
        }
        return 0;

    }

     int runDFS(ArrayList<Integer>[] edges, int[] visited, int i, Stack<Integer> postorder ){

        visited[i] = 1;

        ArrayList<Integer> current = edges[i];
        for(int node : current){
            if (visited[node] == 0) {
                runDFS(edges, visited, node, postorder);
            }

        }

       postorder.add(i);
        return 0;
    }

    private   int getCountStronglyConnectedComponents(ArrayList<Integer>[] edges, ArrayList<Integer>[] reverseGraph, int v){

        // Run DFS on reverse Graph

        int[] visited = new int[v];
        Stack<Integer> postorder = new Stack<>();

        int number = 0;

        for(int i = 0 ; i < v ; i++){
            if(visited[i] == 0) {
                runDFS(reverseGraph, visited, i, postorder );
            }
        }

        int[] revisited = new int[v];

        int scc = 0 ;

        while (!postorder.isEmpty() ){
            int current = postorder.pop();
            if (revisited[current] == 0){
                dfsscc(edges,revisited,current);
                scc++;
            }
        }
        return scc;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        //int[][] prereq = {{0,1},{0,1}};

        ArrayList<Integer>[] edges = (ArrayList<Integer>[]) new  ArrayList[v];
        ArrayList<Integer>[] reverseGraph = (ArrayList<Integer>[]) new ArrayList[v];

        for(int i = 0 ; i < v; i++){
            edges[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for(int i = 0  ; i < e ; i++){
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;

            edges[start].add(end);
            reverseGraph[end].add(start);
        }

        CountStronglyConnectedComponents cscc = new CountStronglyConnectedComponents();
        int i = cscc.getCountStronglyConnectedComponents(edges,reverseGraph,v);

        System.out.println(i);

    }
}
/*
5 7
2 1
3 2
3 1
4 3
4 1
5 2
5 3
 */
