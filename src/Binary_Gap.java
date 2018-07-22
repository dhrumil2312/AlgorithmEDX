public class Binary_Gap {

    public static void main(String[] args) {


        int n = 22;

        char[] str = Integer.toBinaryString(n).toCharArray();

        int count=0;
        System.out.println(str);
        int ans = 0;
        for(int i = 0 ; i < str.length ;i++){
            if(i != 0 && str[i] == '0'){
                count++;
            }
            else{
                ans = Math.max(ans, count);
                count = 1;
            }
        }

        System.out.println(ans);

    }
}
