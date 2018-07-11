package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {


    static void helper(List<List<Integer>> result , List<Integer> path , int k , int n , int index , int sum){
        if (path.size() == k && sum == n){
            result.add(new ArrayList<> (path));
            return;
        }

        for(int i = index ; i <= 9 ;i++){
            path.add(i);
            helper(result , path , k , n , i + 1 , sum + i);
            path.remove(path.size() -1);
        }

    }

    public static List<List<Integer>> combinationSum3(int k, int n){

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        helper(result, path, k, n, 1 , 0);

//        for(List<Integer> i : result){
//            for(int kg : i){
//                System.out.print(kg + "  ");
//            }
//            System.out.println();
//        }

        return result;

    }
    public static void main(String[] args) {
        int n = 9;
        int k = 3;


        List<List<Integer>> a = combinationSum3(k , n);



    }
}
