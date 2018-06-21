import java.util.ArrayList;
import java.util.Scanner;

public class lastDigitPartialSumFibonnaci {

    private static long getFibonacciPartialSumNaive(long from, long to) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(0);
        numbers.add(1);

        for(int i = 2 ; i < 60 ; i++){
            numbers.add((numbers.get(i-1) + numbers.get(i-2) )% 10);
        }

        to %= 60;
        from %= 60;
        int f = (int) from ;
        if(to < from) to += 60;
        int ans = 0;
        for(int i = f ; i <= to ; i++ ){
            ans += numbers.get(i) % 10;

        }
        return ans %10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}
