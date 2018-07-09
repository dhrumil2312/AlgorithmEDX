package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    static void helper(String s, String temp, ArrayList<String> ans){

        if(s.length() == 0 ){
            System.out.println(temp + " aans");
            ans.add(temp);
            return ;
        }

        char current = s.charAt(0);
        if(current >= 'A') {
            System.out.println(s + "   " +temp + "----------  ");
            helper(s.substring(1), temp + current, ans);
            System.out.println(s + "   " +temp );
            char upper = (char) (current + 32);
            char lower = (char) (current - 32);
            if (current >= 65 && current <= 90) {
                helper(s.substring(1), temp + upper, ans);
            } else {
                helper(s.substring(1), temp + lower, ans);
            }
        }
            else{
                helper(s.substring(1), temp+ current , ans);
            }

        }


    public static void main(String[] args) {
        String s = "a1b2";

        char[] arr = s.toCharArray();

        ArrayList<String> ans = new ArrayList<>();

        List<String> result = new ArrayList<>();
        helper(s,"" , ans);

        for(String i : ans){
            System.out.println(i);
        }
    }
}
