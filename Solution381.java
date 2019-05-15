public class Solution381 {
    public static int[][] generateMatrix(int n) {
        // write your code here
        int[][] arr = new int[n][n];
        int count = 1;
        for(int i=0; i<=(n-1)/2; i++) {
            for(int j=i;j<n-i; j++) {
                arr[i][j] = count++;
            }

            for(int j=i+1; j<n-i; j++) {
                arr[j][n-i-1] = count++;
            }

            for(int j=n-i-2; j>=i; j--) {
                arr[n-i-1][j] = count++;
            }

            for(int j=n-i-2; j>i; j--) {
                arr[j][i] = count++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = generateMatrix(5);
        printMatrix(arr);
    }

    public static void printMatrix(int[][] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length;j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }
}

