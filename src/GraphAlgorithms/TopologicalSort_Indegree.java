package GraphAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort_Indegree {

    private static ArrayList<Integer> getTopologicalOrder(ArrayList<Integer>[] edges, int v){

        int[] inDegrees = new int[v];

        for(ArrayList<Integer> i : edges){
            for(int j = 0 ; j < i.size() ; j++){
                inDegrees[i.get(j)]++;
            }
        }

        //for(int i : inDegrees) System.out.printf(" %d ", i);

        //System.out.println();

        ArrayList<Integer> sortedOrder = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < v ; i++){
            if (inDegrees[i] == 0) {
                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
            /*for(int i : stack){
                System.out.printf(" %d ", i);
            }
            System.out.println("Indegrees");
            for(int i : inDegrees){
                System.out.printf(" %d ", i);
            }*/
            int current = stack.pop();
            sortedOrder.add(current+1);
            for(int i : edges[current]) {
               // System.out.println(i);
                inDegrees[i]--;
                if(inDegrees[i] == 0){

                 //   System.out.println("Here");
                    stack.push(i);
                }
            }
        }

    return sortedOrder;
    };

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

        ArrayList<Integer> order = getTopologicalOrder(edges,v);

        System.out.println();

        for(int i : order){
            System.out.printf(" %d ", i);
        }
    }
}
