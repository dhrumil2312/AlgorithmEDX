package GraphAlgorithms;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RoadsAndLibraries {


    static int dfsUtil(ArrayList<Integer>[] edges , int[] visited, int node){
        visited[node] = 1;

        ArrayList<Integer> current = edges[node];

        for(int i : current){
            if(visited[i] == 0){
                dfsUtil(edges,visited,i);
            }
        }

        return 0;
    }

    static long roadsAndLibrariesHelper(int n, int c_lib, int c_road,ArrayList<Integer>[] edges , int roads) {

        if(c_lib <= c_road){

            long ans = (long) c_lib*n;
            return ans;
        }


        int[] visited = new int[n];
        int comps = 0;

        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0){
                dfsUtil(edges,visited,i );
                comps++;
            }
        }

        long interim = (long) (n-comps)*c_road;
        long ans =  interim + (comps)*c_lib;

        return ans;

    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        while(q > 0) {
            q--;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int c_lib = sc.nextInt();
            int c_road = sc.nextInt();

            ArrayList<Integer>[] edges = (ArrayList[]) new ArrayList[n];

            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }

            System.out.println("Here-------------------------------");

            for (int i = 0 ; i < m ; i++) {
                int start = sc.nextInt() - 1;
                int end = sc.nextInt() - 1;

                System.out.println(i);
                edges[start].add(end);
                edges[end].add(start);
            }
            System.out.println(q + "  -------------------------------");
            System.out.println("Here123234234");
            System.out.println(roadsAndLibrariesHelper(n, c_lib, c_road, edges, m));
        }

    }
}
