import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch {

    private static int getBinarySearchIndex(ArrayList<Integer> numbers, int low , int high, int key){

        if (high < low) return -1;

        int mid = low + ((high - low) / 2);
        //System.out.println(key + "   " + mid + "  " + high + "  " + low);
        if (numbers.get(mid) == key){
            return mid;
        }else if(numbers.get(mid) > key) {
            return getBinarySearchIndex(numbers, low, mid -1, key);
        } else return getBinarySearchIndex(numbers, mid +1 , high, key);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i = 0 ; i < n ;i++){
            numbers.add(sc.nextInt());
        }
        int q = sc.nextInt();

        ArrayList<Integer> queries = new ArrayList<>();

        for(int i = 0 ; i< q ; i++){
            queries.add(sc.nextInt());
        }

        Collections.sort(numbers);

        int result = 0;
        for(int i = 0 ; i <q ; i++) {
            int ans = getBinarySearchIndex(numbers, 0, numbers.size(), queries.get(i));
            System.out.println(ans);
            if (ans != -1) result++;
        }
        System.out.println(result);
    }
}
