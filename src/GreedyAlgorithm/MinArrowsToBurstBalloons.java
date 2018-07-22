package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;



public class MinArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};

        Arrays.sort(points, (a, b) -> a[1] - b[1]);

        int ans = 1;
        int current = points[0][1];

        for(int[] i : points){
            for( int j : i ){
                System.out.print(j +"  ");
            }
            System.out.println();
        }


        for(int[] i : points){
            if(i[0] > current){
                current = i[1];
                ans++;
            }
        }
        System.out.println(ans);

    }
}
