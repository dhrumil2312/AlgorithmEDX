package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Kanpsack_Discrete {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int weight = sc.nextInt();

        int n = sc.nextInt();

        ArrayList<Integer> array = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            array.add(sc.nextInt());
        }

        int[][] dp = new int[n+1][weight+1];

        for(int i = 0 ; i < n ; i++){
            dp[i][0] = 0;
        }

        for(int i = 0 ; i < weight + 1 ; i++){
            dp[0][i] = 0;
        }

        for(int i = 1 ; i < n + 1; i++){
            for(int j = 1 ; j< weight + 1; j++){

                if(array.get(i-1) < j){
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-array.get(i-1)] + array.get(i-1));
                }
            }
        }

        for(int[] i : dp){
            for(int j : i){
                System.out.printf(" %d ", j);
            }
            System.out.println();
        }

    }
}
