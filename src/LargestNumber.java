import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {


    static class Checker implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            String s1 = String.valueOf(o1) + String.valueOf(o2);
            String s2 = String.valueOf(o2) + String.valueOf(o1);

            if(Long.valueOf(s1) > Long.valueOf(s2)) return -1;
            return 1;
        }
    }

    static String helper(int[] nums){
        Checker checker = new Checker();

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i : nums){
            arr.add(i);
        }
        arr.sort(checker);


        if(arr.get(0)==0){
            return "0";
        }

        String ans = "";
        for(Integer i : arr){
            ans += String.valueOf(i);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {0,0};

        System.out.println(helper(nums));
    }
}
