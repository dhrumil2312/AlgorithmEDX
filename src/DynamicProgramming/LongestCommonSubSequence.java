package DynamicProgramming;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestCommonSubSequence {

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

        int[][] dp  = new int[sub1.size()+1][sub2.size()+1];

        for(int i = 0 ; i < sub1.size() +1 ; i++) {
            dp[i][0] = 0;
        }
        System.out.println("Here");

        for(int i = 0 ; i < sub2.size() ; i++){
            dp[0][i] = 0;
        }

        for(int i = 1 ; i < sub1.size() +1; i++){
            for(int j = 1 ; j < sub2.size() +1; j++ ){
                if (sub1.get(i-1) == sub2.get(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        for(int[] i : dp){
            for(int h : i){
                System.out.printf(" %d ", h );
            }
            System.out.println();
        }

    }
}
