import java.util.Scanner;
import java.util.Stack;

public class NumberOfPricePlaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        int i = 1;
        int current = 0;

        while (n != 0) {
            stack.add(i);
            n -= i;
            //for (int a : stack) System.out.printf(" %d  , %d", a, n);
            System.out.println();
            System.out.println(stack.size());
            if (n < i) {
                current = stack.pop();
                n += current;
                i += 1;
            } else {
                i += 1;
            }
            if (i == 182414464 ){
                break;
            }
        }
    }

}
