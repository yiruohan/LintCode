public class Solution150 {
    public static int maxProfit(int[] prices) {
        // write your code here
        if(prices.length<=1) {
            return 0;
        }
        int minNum =prices[0];
        int maxSum = 0;
        int max = 0;
        for(int i=1; i<prices.length; i++) {
            if(minNum<prices[i]) {
                if(prices[i]-minNum>=max){
                    max = prices[i]-minNum;
                    if((i+1<prices.length && prices[i+1]<=prices[i] )|| i+1==prices.length) {
                        maxSum += max;
                        max = 0;
                        minNum = prices[i];
                    }
                }
            }else{
                minNum = prices[i];
            }
        }
        return maxSum;
    }

    public static int maxProfit1(int[] prices) {
        // write your code here
        int maxSum = 0;
        for(int i=1; i<prices.length;i++) {
            if(prices[i]>prices[i-1]) {
                maxSum += prices[i]-prices[i-1];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {2,1,2,0,1};
        int[] b = {4,3,2,1};
        int[] c = {3,2,6,5,0,3};
        System.out.println(maxProfit1(a));
        System.out.println(maxProfit1(b));
        System.out.println(maxProfit1(c));
    }
}

