package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChangeProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 950;

        int[] coins = {1,3,4};

        int[] dp = new int[sum+1];

        dp[0] = 0;

        int[] part_dp = new int[coins.length];

        Arrays.fill(part_dp,100000);

        for(int i = 1 ; i < sum + 1 ; i++){
            for(int j = 0 ; j < coins.length ; j++){
                if (coins[j]<=i){
                    part_dp[j] = dp[i-coins[j]] + 1;
                    //System.out.println(coins[j] + "  " + i + "  " + (i-coins[j])+ "  " + dp[i-coins[j]] + "  " + (dp[i-coins[j]] +1));
                }
            }
            System.out.println();
            dp[i] = Arrays.stream(part_dp).reduce((x,y) -> x < y ? x : y).getAsInt();
        }

        for(int i : dp){
            System.out.printf(" %d ",i);
        }

    }
}
