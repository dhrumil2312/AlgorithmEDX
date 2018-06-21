package GreedyAlgorithm;

import java.util.*;

public class MaxAdvertisementRevenue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> profit = new ArrayList<>();
        ArrayList<Integer> noOfClicks = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            profit.add(sc.nextInt());
        }

        Collections.sort(profit);

        for(int i = 0 ; i < n ; i++){
            noOfClicks.add(sc.nextInt());
        }

        Collections.sort(noOfClicks);

        long ans = 0;

        for(int i = 0 ; i < n ; i++){
            System.out.println(profit.get(i) +  "   " + noOfClicks.get(i) +  "   " +  profit.get(i)*noOfClicks.get(i));
            long current = (long) profit.get(i)*noOfClicks.get(i);
            ans += current;
        }


        System.out.println(profit.size());
        System.out.println(noOfClicks.size());
        System.out.println(ans);

    }
}

