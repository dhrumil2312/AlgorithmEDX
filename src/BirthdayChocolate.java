import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BirthdayChocolate {

    static int solve(int[] s, int d, int m){

        Queue<Integer> queue = new LinkedList<>();

        int count = 0;

        int k = 0 ;
        int initial_sum = 0;
        while(queue.size() != m){
            queue.add(s[k]);
            initial_sum += s[k];
            k++;
        }

        System.out.println(initial_sum + "  " + queue.size());
        if(initial_sum == d) count++;

        for(int i = k ; i  < s.length ; i++){
            int remove = queue.poll();
            queue.add(s[i]);
            initial_sum = initial_sum - remove + s[i];
            System.out.println(initial_sum + "  " + queue.size() + "   " + remove +  "   " + s[i]);
            if(initial_sum == d) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new  int[n];

        for(int  i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int d = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(solve( arr,  d, m) );

    }
}
