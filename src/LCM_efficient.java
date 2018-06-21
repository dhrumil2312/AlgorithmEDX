import java.util.Scanner;

public class LCM_efficient {
    public static int getGCD(int a , int b){
        if (b == 0){
            return a;
        }
        else {
            return getGCD(b,a%b);
        }
    }

    public static long lcm_eff(int a , int b){

        int gcd = getGCD(a,b);
        return ((long) a * b ) / gcd ;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a < b){
            int temp = b;
            b = a;
            a = temp;
        }
        System.out.println(lcm_eff(a, b));
    }
}
