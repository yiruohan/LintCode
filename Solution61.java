public class Solution61 {
    public static int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = {-1,-1};
        if(null==A || A.length==0) {
            return result;
        }

        int begin = 0;
        int end = A.length-1;
        while(begin<=end) {
            if(A[begin]>target || A[end]<target) {
                result[0] = -1;
                result[1] = -1;
                break;
            }
            if(A[begin]<target) {
                begin++;
            }else if(A[begin]==target){
                result[0] = begin;
            }

            if(A[end]>target) {
                end--;
            }else if(A[end]==target){
                result[1] = end;
            }

            if(result[0]>-1 && result[1]>-1) {
                break;
            }
        }

        return result;
    }

    public static int[] searchRange1(int[] A, int target) {
        // write your code here
        int[] result = {-1,-1};
        if(null==A || A.length==0) {
            return result;
        }

        int begin = 0;
        int end = A.length-1;
        int middle = 0;
        while(begin+1<end) {
            middle = (begin+end)/2;
            if(A[middle]>=target) {
                end = middle;
            }else{
                begin = middle;
            }
        }
         if(A[begin]==target) {
             result[0] = begin;
         }else if(A[end]==target){
             result[0] = end;
         }else{
             return result;
         }

         begin = 0;
         end = A.length-1;
        while(begin+1<end) {
            middle = (begin+end)/2;
            if(A[middle]<=target) {
                begin = middle;
            }else{
                end = middle;
            }
        }
        if(A[end]==target) {
            result[1] = end;
        }else if(A[begin]==target){
            result[1] = begin;
        }
        return result;
    }

    public static void main(String args[]) {
//        int[] a = {5,7,7,8,8,10};
        int[] a  = {1,1,1,1};
        int[] result = searchRange(a,1);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
}

