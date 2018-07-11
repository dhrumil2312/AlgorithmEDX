package DynamicProgramming;

public class EqualSubsetSumProblem {

    static boolean canPartition(int[] arr){

        int sum = 0 ;

        for(int i : arr) sum += i;

        if (sum %2 == 1 ) return false;

        boolean[][] dp = new boolean[sum/2+1][arr.length + 1];

        for (int i = 0; i <= arr.length; i++)
            dp[0][i] = true;

        // initialize leftmost column, except part[0][0], as 0
        for (int i = 1; i <= sum/2; i++)
            dp[i][0] = false;

        for (int i = 1; i <= sum/2; i++)
        {
            for (int j = 1; j <= arr.length; j++)
            {
                dp[i][j] = dp[i][j-1];
                if (i >= arr[j-1])
                    dp[i][j] = dp[i][j] || dp[i - arr[j-1]][j-1];
            }
        }

        return dp[sum/2][arr.length];
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 1, 2, 2,1};

        System.out.println(canPartition(arr));
    }
}
