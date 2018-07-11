import java.util.ArrayList;

public class PermutationSequence {



    static String getPermutation(int n , int k){
        ArrayList<Integer> numbers = new ArrayList<>();

        int[] factorial = new int[n+1];

        for(int i  =1 ; i <= n ; i++){
            numbers.add(i);
        }



        factorial[0] = 1;

        for(int i = 1 ; i <= n ; i++){
            factorial[i] = i * factorial[i-1];
        }

        StringBuilder ans = new StringBuilder();

        k--;

        for(int i = 1 ; i <= n ; i++){
            int index =  k / factorial[n-i];
            System.out.println(index + " " + k + "  " + ans + "   " + i);
            ans.append(numbers.get(index));
            k -= index*factorial[n-i];
            numbers.remove(index);
        }

    return ans.toString();
    }

    public static void main(String[] args) {
        int n = 4 ;
        int k = 9 ;

        System.out.println(getPermutation(n,k));
    }
}
