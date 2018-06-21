import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class maxPairwiseProduct {

    static long getMaxPairwiseProduct(int[] numbers) {
        int n = numbers.length;
        Arrays.sort(numbers);
        //if(numbers[0]*numbers[1] > numbers[n-2]*numbers[n - 1]){
        //    return numbers[0]*numbers[1];
        //} else {
         //   return numbers[n-2]*numbers[n - 1] ;
        //}
        System.out.println(numbers[n-1] + "    " +numbers[n-2]);
        long result = (long) numbers[n-1] * numbers[n-2];
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        FastScanner ft = new FastScanner(System.in);

        int max_int = 0;

        int n = ft.nextInt();
        int[] numbers = new int[n];

        for (int i = 0 ; i < n ;i++){
            numbers[i] = ft.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream){
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e){
                e.printStackTrace();
            }

        }
        String next(){
            while(st == null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }


    }
}
