import java.util.HashMap;

public class Solution994 {
    public static int findMaxLength(int[] nums) {
        // Write your code here
        if(nums.length<=1) {
            return nums.length;
        }
        int max = 0;

        for(int i=0; i<nums.length; i++) {
            int count = 0;
            int zeroNum = 0;
            int oneNum = 0;
            for(int j=i; j<nums.length; j++) {
                if(nums[j]==0) {
                    zeroNum++;
                }
                if(nums[j]==1) {
                    oneNum++;
                }
                if(oneNum==zeroNum) {
                    count = oneNum*2;
                }
            }

            if(count>max) {
                max = count;
            }
        }
        return max;
    }

    public static int findMaxLength1(int[] nums) {
        int sum = 0;
        int max = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,-1);
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==1) {
                sum += 1;
            }else{
                sum -= 1;
            }
            if(hashMap.containsKey(sum)) {
                int temp = i-hashMap.get(sum);
                if(temp>max) {
                    max = temp;
                }
            }else{
                hashMap.put(sum,i);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,0};
        int[] b = {0,1,0};
        int[] c = {1,0,0,1,0,0,0,1,0};
        int[] d = {1,1,0,1,0,0,0,1,0,1,1,1,0,0,0,0,0,1,0,0,0,1,1,0,1,1,0,1,0,1,0,1,1,1,0,0,1,0,0,1,0,1,0,1,0,1,0,0,1,1};
        int[] e = {0,1,0,0,0,1,1,1,0,0};
        System.out.println(findMaxLength1(a));
        System.out.println(findMaxLength1(b));
        System.out.println(findMaxLength1(c));
        System.out.println(findMaxLength1(d));
        System.out.println(findMaxLength1(e));
    }
}
