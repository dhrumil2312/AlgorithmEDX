package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
    public static void main(String[] args) {
        List<Integer> sequence = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n+1];

        for(int i = 1 ; i < arr.length ; i++){
            arr[i] = arr[i-1] + 1;
            if(i%2==0) arr[i] = Math.min(1+arr[i/2],arr[i]);
            if(i%3==0) arr[i] = Math.min(1+arr[i/3],arr[i]);
        }
        /*for(int i : arr){
            System.out.printf(" %d " , i);
        }
*/
        for(int i = n ; i>1 ; ){
            sequence.add(i);

            if(i%3==0 && arr[i] == arr[i/3] + 1) i = i /3 ;
            else if(i%2==0 && arr[i] == arr[i/2] + 1) i = i /2 ;
            else if(arr[i-1] == arr[i] -1) i = i -1;

        }

        System.out.println();

        for(int i : sequence)  System.out.printf(" %d " , i);
        System.out.println();
        System.out.println((sequence.size() + 1));
    }
}
