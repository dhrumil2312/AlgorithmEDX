import java.util.Scanner;

public class LastDigitSumFibonnaci {

    private static long getFibonacci(long n) {
        if (n < 2 ) return n;
        n = n%60;
        long first = 0;
        long second = 1;
        long current = first + second;
        for(int i = 0 ; i < n -1 ; i++){
            current = (first + second) %10;
            first = second % 10;
            second = current;
        }

        System.out.println(current + "  " + current %10);
        return current % 10;
    }

    private static long getFibonacciSumNaive(long n){
        long ans =  (getFibonacci(n+2) -1 )  % 10;
        if (ans < 0) return ans+10;
        return ans % 10 ;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }

}
