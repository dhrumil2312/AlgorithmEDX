import java.util.Scanner;

public class Fibonnaci {


    static long getFibonnaci(int n ){
        long[] array = new long[n+1];
        if (n==0 || n ==1){
            return n;
        }
        System.out.println("Here");
        array[0] = 0;
        array[1] = 1;
        for(int i =2 ; i<=n ; i++){
            array[i] = array[i-1] + array[i-2];
            System.out.println(array[i] + "   " + i);
        }

        for( long i : array){
            System.out.println(i);
        }
        return array[n];


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getFibonnaci(n ));
    }
}
