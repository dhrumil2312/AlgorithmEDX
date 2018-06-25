package GraphAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MinimumFlightSegments {


    private static int getMinimumFlightSegments(ArrayList<Integer>[] edges, int v , int start , int end){

        int[] visited = new int[v];
        int[] distance = new int[v];

        for(int i = 0 ; i < v ; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start] = 0;
        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(start);

        int count = 0 ;

        while(!queue.isEmpty()){
            int current = queue.remove();
            visited[current] = 1;
            for(int i : edges[current]){
                if (visited[i]==0 && distance[i] == Integer.MAX_VALUE){
                    queue.add(i);
                    distance[i] = distance[current] + 1;
                }
            }
        }

        if(distance[end]==Integer.MAX_VALUE){
            return -1;
        }
        return distance[end];

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
            edges[end].add(start);
        }

        int start = sc.nextInt() -1;
        int end = sc.nextInt() -1;

        System.out.println(getMinimumFlightSegments(edges,v , start , end) );

    }
}
