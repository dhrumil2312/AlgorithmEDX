public class NextPermutation {

    static void swap(int[] nums , int i , int j) {
        System.out.println(i + "  " + j);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int i) {
        int j = nums.length -1;
        while(i<=j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }


    static  void helper(int[] nums){

        int index = nums.length-2;

        while(index >= 0 &&nums[index+1] <= nums[index]){
            index--;
        }

        if(index >= 0) {

            int j = nums.length - 1;
            System.out.println(j + "  " + nums[index]);
            while (j >= index + 1 && nums[j] <= nums[index]) {
                j--;
            }
            System.out.println(j);

            swap(nums, index, j);
        }

        reverse(nums, index+1);

        }



    public static void main(String[] args) {

        //int[] nums = {1,5,8,4,7,6,5,3,1};
        int[] nums = {5,1,1};
        helper(nums);
        for(int i : nums){
            System.out.print(i +"  ");
        }
    }
}
