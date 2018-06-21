package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class OrganizingLotery {

    static  class Sorter implements Comparator<ArrayList<String>>{

        @Override
        public int compare(ArrayList<String> o1, ArrayList<String> o2) {
            int a = Integer.parseInt(o1.get(0));
            int b = Integer.parseInt(o2.get(0));

            if (a > b) return 1;
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<String>> pairs = new ArrayList<>();

        Sorter sorter = new Sorter();

        for(int i = 0 ; i < n ; i++){
            ArrayList<String> current = new ArrayList<>();
            ArrayList<String> current_end = new ArrayList<>();

            String  start = Integer.toString(sc.nextInt());
            String  end = Integer.toString(sc.nextInt());

            current.add(start);
            current.add("Left");

            current_end.add(end);
            current_end.add("Right");

            pairs.add(current);
            pairs.add(current_end);

        }

        for(int i = 0 ; i < m ;i++){
            ArrayList<String> current = new ArrayList<>();

            String  point = Integer.toString(sc.nextInt());

            current.add(point);
            current.add("Point");

            pairs.add(current);
        }

        pairs.sort(sorter);

        //for(ArrayList<String> st : pairs){
        //    System.out.println(st);
        //}

        Stack<String> stack = new Stack<>();

        int ans = 0 ;
        for(ArrayList<String> s : pairs){
            if(s.get(1).equals("Left")){
                stack.add("Left");
            }
            else if (s.get(1).equals("Point")){
                //for(String j : stack) System.out.printf(" %s ",j);
                ans += stack.size();
            } else if (s.get(1).equals("Right")){
                stack.pop();
            }
        }

        System.out.println(ans);

    }

}
