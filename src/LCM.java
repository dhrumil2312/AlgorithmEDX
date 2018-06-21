import java.util.HashMap;
import java.util.Scanner;

public class LCM {

    private static HashMap<Integer,Integer> getfactors (int n){
        HashMap<Integer, Integer> factors = new HashMap<>();
        int current = n;
        for(int i = 2;i <= n && current > 1 ; i++ ){
            while (current % i == 0){
                factors.put(i, factors.getOrDefault(i,0) + 1);
                current = current / i;
            }
        }
        return factors;
    }

    private static long lcm(int a, int b) {
        HashMap<Integer , Integer> factors_a = getfactors(a);
        HashMap<Integer , Integer> factors_b = getfactors(b);

        HashMap<Integer , Integer> result = new HashMap<>();

        long ans = 1L;
        System.out.println("Here");

        factors_a.forEach((K,V) -> {
            result.put(K,result.getOrDefault(K,0) + V ) ;
        });

        factors_b.forEach((K,V) -> {
            result.put(K,result.getOrDefault(K,0) + V ) ;
        });


        factors_a.forEach((k,v)->{
            System.out.println(k + "   " + v);
        });

        factors_b.forEach((k,v)->{
            System.out.println(k + "   " + v);
        });

        result.forEach((k,v)->{
            System.out.println(k + "   " + v);
        });


        for(Integer i :  result.keySet()){
            ans *= (long) Math.pow(i , result.get(i));
            System.out.println(ans);
        }

        return ans;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        LCM_efficient.lcm_eff(a,b);
        System.out.println(lcm(a, b));
    }
}
