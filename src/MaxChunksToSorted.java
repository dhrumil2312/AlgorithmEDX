public class MaxChunksToSorted {


    static int getMaxChunksToSorted(int[] nums){
        int ans = 0;
        int max = 0;

        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max,nums[i]);
            if(max == i) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,1,0};

        System.out.println(getMaxChunksToSorted(nums));
    }
}
