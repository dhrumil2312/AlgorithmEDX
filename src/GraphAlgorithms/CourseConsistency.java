package GraphAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseConsistency {

    private static int DFS(ArrayList<Integer>[] edges , int i , int[] visited , int[] recursion){

        visited[i] = 1;
        recursion[i] = 1;
        ArrayList<Integer> current = edges[i];

        for(int j : current){
            if(visited[j]==0){
                if(DFS(edges,j,visited, recursion) == 1) return 1;
            }
            else if (recursion[j] == 1) {
                return 1;
            }
        }
        recursion[i] = 0;
        return 0;
    }

    private static int getIsCycle(ArrayList<Integer>[] edges , int v){

        int[] visited = new int[v];
        int[] recursion = new int[v];

        for(int i = 0 ; i < v ; i++){
            if(DFS(edges,i,visited , recursion) == 1) return  1;
        }
        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();

        int e = sc.nextInt();

        //int[][] prereq = {{0,1},{0,1}};

        ArrayList<Integer>[] edges = (ArrayList<Integer>[]) new  ArrayList[v];

        for(int i = 0 ; i < v; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 0  ; i < e ; i++){
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;

            edges[start].add(end);
        }
/*
        for(int[] i :prereq){
            edges[i[0]].add(i[1]);
        }

        if (getIsCycle(edges,v)==0){
            return true;
        } else{
            return false;
        }
*/

        System.out.println(getIsCycle(edges,v));
    }

}
