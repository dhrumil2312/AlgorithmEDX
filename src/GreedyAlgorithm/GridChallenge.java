package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] grid = {"ebacd",
                "fghij",
                "olmkn",
                "trpqs",
                "xywuv"};

        ArrayList<char []> matrix = new ArrayList<>();

        for(int i = 0 ; i < grid.length ; i++){
            String current = grid[i];
            char[] current_array= new char[current.length()];
            for(int j = 0 ; j < current.length() ; j++){
                current_array[j] = current.charAt(j);
            }
            Arrays.sort(current_array);
            matrix.add(current_array);
        }

        for(int r = 1 ; r < grid.length ; r++){
            for(int c = 0 ; c < grid.length ; c++){
                if (matrix.get(r-1)[c] > matrix.get(r)[c]){
                    System.out.println("False");
                }
            }
        }
        System.out.println("True");

    }
}
