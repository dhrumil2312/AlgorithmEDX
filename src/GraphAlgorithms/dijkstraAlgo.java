package GraphAlgorithms;

import java.util.*;




public class dijkstraAlgo {


    private static int minDistance(int[] dist, int[] visited){
        int min = Integer.MAX_VALUE ;
        int min_value = Integer.MAX_VALUE;



        for(int i = 0 ; i < dist.length; i++){
            if(visited[i] == 0 && dist[i] < min_value){
                min = i;
                min_value = dist[i];
            }
        }
        return min;
    }

    private static int runDijkstraAlgorithm(int[][] edges , int v, int start, int end){

        int[] dist = new int[v];
        int[] visited = new int[v];

        for(int i = 0 ; i < v ; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        for(int i = 0 ; i < v -1 ;i++){
            int current = minDistance(dist, visited);
            if(current == Integer.MAX_VALUE) return -1;

            visited[current] = 1;

            for(int temp = 0 ; temp < v ;temp++){
                if(visited[temp] == 0 && edges[current][temp] != 0 && dist[current] != Integer.MAX_VALUE && dist[current]+edges[current][temp] < dist[temp]){
                    dist[temp] = dist[current]+edges[current][temp];
                }
            }
            //System.out.println();
            //for(int f = 0 ; f < v ;f++) System.out.printf(" %d %d", dist[f], visited[f]);
            //System.out.println();

        }
        //System.out.println();
        //for(int i : dist) System.out.printf(" %d ", i);
        //System.out.println();
        return dist[end] != Integer.MAX_VALUE ? dist[end] : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v =sc.nextInt();

        int e = sc.nextInt();

        int[][] edges = new int[v][v];


        for(int i = 0 ; i < e ; i++){
            int start = sc.nextInt() -1 ;
            int end = sc.nextInt() -1 ;
            int weight = sc.nextInt();

            edges[start][end] = weight;

        }
        int start = sc.nextInt() -1;
        int end = sc.nextInt() - 1;

        System.out.println(runDijkstraAlgorithm(edges,v, start,end));

    }
}
