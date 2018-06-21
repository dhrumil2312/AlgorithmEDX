package DynamicProgramming;

import java.util.Scanner;
import java.lang.Math;


public class MaxValueArithmeticExpression {

    static int eval(int s1 , int s2 , char op){
        if (op =='+'){
            return s1 + s2;
        }
        if (op =='-'){
            return s1 - s2;
        }
        if (op =='*'){
            return s1 * s2;
        }
        return -1;
    }

    private static int getMaxValue(String st){

        int noOfNums = (st.length() + 1)/2;

        int[][] mindp = new int[noOfNums][noOfNums];
        int[][] maxdp = new int[noOfNums][noOfNums];

        for(int i = 0 ; i < noOfNums ; i++){
            mindp[i][i] = Character.getNumericValue(st.charAt(2*i));
            maxdp[i][i] = Character.getNumericValue(st.charAt(2*i));
        }

        for(int s = 0 ; s < noOfNums -1 ; s++){
            for(int i = 0 ; i < noOfNums -s -1 ; i++){
                int j = i + s + 1;
                int maxval = -345234523;
                int minval = 234214124;

                for(int k = i ; k < j ; k++){
                    int a = eval(mindp[i][k],mindp[k+1][j],st.charAt(2*k+1));
                    int b = eval(mindp[i][k],maxdp[k+1][j],st.charAt(2*k+1));
                    int c = eval(maxdp[i][k],mindp[k+1][j],st.charAt(2*k+1));
                    int d = eval(maxdp[i][k],maxdp[k+1][j],st.charAt(2*k+1));

                    maxval = Math.max(maxval,Math.max(d,Math.max(c,Math.max(a,b))));
                    minval = Math.min(minval,Math.min(d,Math.min(c,Math.min(a,b))));
                }

                mindp[i][j] = minval;
                maxdp[i][j] = maxval;
            }
        }

    for(int[] i : mindp){
            for(int j : i){
                System.out.printf(" %d ",j);
            }
        System.out.println();
    }

        for(int[] i : maxdp){
            for(int j : i){
                System.out.printf(" %d ",j);
            }
            System.out.println();
        }

    return maxdp[0][noOfNums-1];

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(getMaxValue(s));
    }
}
