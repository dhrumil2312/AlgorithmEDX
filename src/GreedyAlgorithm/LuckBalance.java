package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LuckBalance {


    public static void main(String[] args) {

        ArrayList<Integer> asd ;


        int k = 3;
        int[][] contests = {{5, 1},
                {2 ,1},
                {1 ,1},
                {8 ,1},
                {10, 0},
                {5 ,0}};

        Arrays.sort(contests, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1]) return 1;
                else if(o1[1] == o2[1] ){
                    if(o1[0] >o2[0]) return -1;
                    return 1;
                }
                return -1;
            }
        });


        for(int[] i : contests){
            for(int j : i){
                System.out.printf(" %d ", j);
            }
            System.out.println();
        }

        int ans = 0 ;
        for(int i = 0 ; i < contests.length;i++){
            if(contests[i][1] == 0){
                ans += contests[i][0];
            }
            else if(contests[i][1] == 1 && k != 0){
                k--;
                ans += contests[i][0];
            }
            else {
                ans -= contests[i][0];
            }
            }

        System.out.println(ans);

    }

}
