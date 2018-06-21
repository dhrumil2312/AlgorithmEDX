package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Help implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        String s1 = Integer.toString(o1);
        String s2 = Integer.toString(o2);

        String s1_comb = s1+s2;
        String s2_comb = s2+s1;

        if(Integer.parseInt(s1_comb) > Integer.parseInt(s2_comb)) return -1;
        return 1;
    }
}

public class MaxSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Help help = new Help();
        int n = sc.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            numbers.add(sc.nextInt());
        }

        numbers.sort(help);

        for(int i : numbers) System.out.printf("%d",i);

    }
}
