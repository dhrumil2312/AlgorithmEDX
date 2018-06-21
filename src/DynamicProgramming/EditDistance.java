package DynamicProgramming;

import java.util.Scanner;

public class EditDistance {

    public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);

    String a = sc.next();
    String b = sc.next();

    int[][] dp = new int[a.length()+1][b.length()+1];

    int a_length = a.length();
    int b_length = b.length();

    for(int i = 0 ; i < a_length +1 ; i++) {
        dp[i][0] = i;
    }
        System.out.println("Here");
    for(int i = 0 ; i < b_length ; i++){
        dp[0][i] = i;
    }
        System.out.println("Here222");

    for(int i = 1 ; i < a_length +1; i++){
        for(int j = 1 ; j <b_length +1 ; j++){
            if(a.charAt(i-1) == b.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1];
            }
            else{
                int current_min = Math.min(dp[i-1][j] + 1 , dp[i][j-1] + 1);
                dp[i][j] = Math.min(dp[i-1][j-1] + 1 , current_min);
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
