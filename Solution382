import java.util.Arrays;
public class Solution382 {
    public static int triangleCount(int[] S) {
        // write your code here
        int count = 0;
        for(int i=0; i<S.length-2; i++) {
            for(int j=i+1;j<S.length-1; j++) {
                for(int k=j+1;k<S.length;k++) {
                    if(isTriangle(S[i],S[j],S[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int triangleCount1(int[] S) {
        // write your code here
        int count = 0;
        Arrays.sort(S);
        for(int i=0; i<S.length-2; i++) {
            if(S[i]<=0) {
                continue;
            }
            for(int j=i+1;j<S.length-1; j++) {
                for(int k=j+1;k<S.length;k++) {
                    if(S[i]+S[j]<=S[k]) {
                        break;
                    }
                    if(isTriangle1(S[i],S[j],S[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int triangleCount2(int[] S) {
        // write your code here
        int count = 0;
        Arrays.sort(S);
        int index = 0;
        for(int i=2; i<S.length; i++) {
            if(S[i]<=0) {
                if(i+1<S.length && S[i+1]>0) {
                    index = i+1;
                }
                continue;
            }

            int firstIndex = index;  // 第一个数的下标
            int secondIndex = i-1;  // 第二个数的下标
            int thirdNumber = S[i];  // 固定第三个数
            while (firstIndex<secondIndex) {
                if(S[firstIndex]+S[secondIndex]>thirdNumber) { // S[firstIndex]+S[secondIndex]>S[i] 则 secondIndex--
                    count += secondIndex-firstIndex;
                    secondIndex--;
                }else{  // 否则 firstIndex++
                    firstIndex++;
                }
            }
        }
        return count;
    }

    public static boolean isTriangle(int a,int b,int c) {
        return a>0 && b>0 &&c>0 && (a+b)>c && (b+c)>a && (a+c)>b;
    }

    public static boolean isTriangle1(int a,int b,int c) {
        return (a+b)>c && (b+c)>a && (a+c)>b;
    }

    public static void main(String[] args) {
        int[] a = {3,4,6,7};
        int[] b = {4,4,4,4};
        System.out.println(triangleCount2(a));
        System.out.println(triangleCount2(b));
    }
}
