import java.util.Arrays;
import java.util.Scanner;

public class BetweenTwoSets {

    static int gcd(int a , int b){

        if(b==0) return a;
        return gcd(b,a%b);
    }

    static int getTotalX(int[] a, int[] b){

        Arrays.sort(a);
        Arrays.sort(b);

        int gcd_b = b[0];

        for(int i = 1 ; i < b.length ;i++){
            gcd_b = gcd(b[i],gcd_b);
        }

        int gcd_a = a[0];
        long product_a = a[0];

        for(int i = 1 ; i < a.length ;i++){
            gcd_a = gcd(a[i],gcd_a);
            product_a =(long) product_a * a[i];
        }

        long lcm = product_a / gcd_a;

        System.out.println(gcd_b + "   " + lcm + "   " + product_a + "   " + gcd_a);

        int count=0;

        for(long i = lcm, j =2; i<=gcd_b; i = lcm*j,j++){
            System.out.println(gcd_b  + "  " + i + "  "+lcm + "   "+ j);
            if(gcd_b%i==0 && i!= 1){ count++;}
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for(int i = 0 ; i < n ; i++){
            a[i] = sc.nextInt();
        }

        for(int i = 0 ; i < m ; i++){
            b[i] = sc.nextInt();
        }

        System.out.println(getTotalX( a,  b));
    }
}
