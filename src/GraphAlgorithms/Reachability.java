package GraphAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {

    private static int DFS(ArrayList<Integer>[] edges, int[] visited, int start, int end){
        visited[start] = 1;

        if(start == end) {
            return 1;
        }
        ArrayList<Integer> current = edges[start];
        for(int i : current){
            if (visited[i] == 0) {
                if(DFS(edges, visited, i, end)==1) return 1;
            }
        }

        return 0;

    }

    private static int getReachability(ArrayList<Integer>[] edges, int start, int end, int v , int e){

        int[] visited = new int[v];

        return DFS(edges,visited,start,end);

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
            int start = sc.nextInt() -1 ;
            int end = sc.nextInt() -1 ;
            edges[start].add(end);
            edges[end].add(start);
        }

        int start = sc.nextInt()-1;
        int end = sc.nextInt()-1;

        System.out.println(getReachability(edges,start,end,v,e));

    }
}
