public class Solution383 {
    public static int maxArea(int[] heights) {
        // write your code here
        int max = 0;
        for(int i=0; i<heights.length-1; i++) {
            for(int j=i;  j<heights.length; j++) {
                if((Math.min(heights[j],heights[i])*(j-i))>max) {
                    max = Math.min(heights[j],heights[i])*(j-i);
                }
            }
        }
        return max;
    }

    public static int maxArea1(int[] heights) {
        // write your code here
        if(heights.length<=1) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = heights.length-1;
        int leftHeight = heights[left];
        int rightHeight = heights[right];
        while(left<right) {
            if(leftHeight<rightHeight) {
                if(leftHeight*(right-left)>max) {
                    max = leftHeight*(right-left);
                }
                left++;
                if(leftHeight<heights[left]) {
                    leftHeight = heights[left];
                }
            }else{
                if(rightHeight*(right-left)>max) {
                    max = rightHeight*(right-left);
                }
                right--;
                if(rightHeight<heights[right]) {
                    rightHeight = heights[right];
                }
            }
        }
        return max;
    }

    public static int maxArea2(int[] heights) {
        // write your code here
        if(heights.length<=1) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = heights.length-1;
        int leftHeight = heights[left];
        int rightHeight = heights[right];
        int maxArea = 0;
        while(left<right) {
            max = leftHeight<rightHeight ? leftHeight*(right-left) : rightHeight*(right-left);
            if(max>maxArea) {
                maxArea = max;
            }
            if(leftHeight<rightHeight) {
                left++;
                if(leftHeight<heights[left]) {
                    leftHeight = heights[left];
                }
            }else{
                right--;
                if(rightHeight<heights[right]) {
                    rightHeight = heights[right];
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] a = {1,3,2};
        int[] b = {1,3,2,2};
        int[] c = {2,3,1,1,3};
        System.out.println(maxArea2(a));
        System.out.println(maxArea2(b));
        System.out.println(maxArea2(c));
    }
}

