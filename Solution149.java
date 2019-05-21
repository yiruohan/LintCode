import java.util.Stack;
public class Solution149 {
    public static int maxProfit(int[] prices) {
        // write your code here
        if(prices.length<=1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(prices[0]);
        int max = 0;
        for(int i=1; i<prices.length; i++) {
            if(stack.peek()<prices[i]) {
                max = prices[i]-stack.peek()>max ? prices[i]-stack.peek() : max;
            }else{
                stack.push(prices[i]);
            }
        }
        return max;
    }

    public static int maxProfit1(int[] prices) {
        // write your code here
        if(prices.length<=1) {
            return 0;
        }
        int minNum = prices[0];
        int max = 0;
        for(int i=1; i<prices.length; i++) {
            if(minNum<prices[i]) {
                max = prices[i]-minNum>max ? prices[i]-minNum : max;
            }else{
                minNum = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {3,2,3,1,2};
        int[] b = {1,2,3,4,5};
        int[] c = {5,4,3,2,1};
        System.out.println(maxProfit1(a));
        System.out.println(maxProfit1(b));
        System.out.println(maxProfit1(c));
    }
}

