public class MinSizeSubarrayProblem {
    public static void main(String[] args) {

        int[] nums = {2,3,1,2,4,3};
        int s = 7 ;

        int i = 0 ;
        int j = 0 ;

        int ans = 421342342;
        int sum = 0;

        while(i < nums.length){

            if(sum > s){
                sum -= nums[i];
                i++;
            }
            if(sum == s){
                System.out.println("Here");
                System.out.println(i + "  " + j + "-------");
                ans = Math.min(ans,j-i);
                sum -= nums[i];
                i++;

            }
            if(sum < s){
                sum += nums[j];
                j++;
            }
            System.out.println(sum);
        }
        System.out.println(ans);
    }
}
