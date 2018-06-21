import java.math.BigInteger;
import java.util.Scanner;

public class FibonnaciHugeNumber {

    private  static int getPisanoPeriod( long m){


        int length = 0;
        long first = 0;
        long second = 1;
        long current = (first + second) %m;
        for(int i = 0 ; i <  m*m ; i++){
            current = (first + second ) % m;
            first = second;
            second = current;
            length++;
            System.out.println(length);
            System.out.println(first + "  " + second);
            if(first == 0 && second == 1)
                return i+1;
        }
        return  0;
    }

    private static long getFibonacciHugeNaive(long n, long m) {

        int length = getPisanoPeriod(m);
        System.out.println(length +"-----");
        long remainder = n % length;

        System.out.println("Remainder" + "  " + remainder);

        long first = 0;
        long second = 1;
        long current = remainder;

        for(int i = 1 ; i < remainder ; i++ ){
            current = (first + second) % m;
            first = second;
            second = current;
        }

        System.out.println();
        return current %m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}
