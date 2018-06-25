package GraphAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BipartiteGraph {

    private static boolean getIsBipartiteGraph(ArrayList<Integer>[] edges, int v, int i){

        int[] visited = new int[v];
        int[] color = new int[v];

        Queue<Integer> queue = new PriorityQueue<>();

        for(int j = 0 ; j < v ; j++){
            color[j] = Integer.MAX_VALUE;
        }

        color[i] = 0;

        queue.add(i);

        while(!queue.isEmpty()){
            int current = queue.remove();
            for(int j : edges[current]){
                if(color[j]==color[current]){
                    return false;
                }
                if(color[j] == Integer.MAX_VALUE){
                    queue.add(j);
                    color[j] = color[current] + 1;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<Integer>[] edges = (ArrayList<Integer>[]) new ArrayList[v];

        for(int i = 0 ;i < v ; i++){
            edges[i] = new ArrayList<>();
        }


        for(int i = 0 ; i < e ; i++){
            int start = sc.nextInt() -1;
            int end = sc.nextInt() -1 ;

            edges[start].add(end);
            edges[end].add(start);
        }

        for(int i = 0 ; i < v ; i++){
            if(!getIsBipartiteGraph(edges,v,i)){
                System.out.println("False");
                break;
            }
        }

        System.out.println("True");

    }
}
