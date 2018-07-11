package DynamicProgramming;

import java.util.HashMap;

public class TwoKeysKeyboard {

    private static HashMap<Integer,Integer> getfactors (int n){
        HashMap<Integer, Integer> factors = new HashMap<>();
        int current = n;
        //System.out.println("Here " + n);
        for(int i = 2;i <= n && current > 1 ; i++ ){
            while (current % i == 0){

                factors.put(i, factors.getOrDefault(i,0) + 1);
                current = current / i;
            }
        }
        return factors;
    }


    static int minSteps(int n ){
        int ans = 0 ;

        HashMap<Integer,Integer> factors = getfactors(n);

        for(Integer c : factors.keySet()){

            ans += factors.get(c)*c;
        }

        return ans;
    }

    public static void main(String[] args) {
        int  n = 10;

        System.out.println(minSteps(n));
    }
}
