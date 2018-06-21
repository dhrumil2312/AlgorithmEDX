package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class LCS_forThreeStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> sub1 = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            sub1.add(sc.nextInt());
        }

        int m = sc.nextInt();
        ArrayList<Integer> sub2 = new ArrayList<>();

        for(int i = 0 ; i <m ;i++){
            sub2.add(sc.nextInt());
        }

        int o = sc.nextInt();
        ArrayList<Integer> sub3 = new ArrayList<>();

        for(int i = 0 ; i <o ;i++){
            sub3.add(sc.nextInt());
        }

        int[][][] dp  = new int[sub1.size()+1][sub2.size()+1][sub3.size() + 1];

        for(int i = 0 ; i < sub1.size() +1 ; i++) {
            dp[i][0][0] = 0;
        }
        System.out.println("Here");

        for(int i = 0 ; i < sub2.size() ; i++){
            dp[0][i][0] = 0;
        }

        for(int i = 0 ; i < sub3.size() ; i++){
            dp[0][0][i] = 0;
        }

        for(int i = 1 ; i < sub1.size() +1; i++){
            for(int j = 1 ; j < sub2.size() +1; j++ ){
                for(int k = 1 ; k < sub3.size() + 1 ; k++) {
                    if (sub1.get(i - 1).equals(sub2.get(j - 1)) && sub2.get(j-1).equals(sub3.get(k-1)) && sub3.get(k-1).equals(sub1.get(i-1)) ) {
                        dp[i][j][k] = dp[i - 1][j - 1][k-1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i][j - 1][k]);
                        dp[i][j][k] = Math.max(dp[i][j][k] , dp[i][j][k-1]);
                    }
                }
            }
        }

        for(int[][] i : dp){
            for(int[] h : i){
                for(int k: h){
                    System.out.printf(" %d ", k );
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println(dp[sub1.size()][sub2.size()][sub3.size() ]);

    }

}
