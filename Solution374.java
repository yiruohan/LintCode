import java.util.*;
public class Solution374 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        if(rows<1) {
            return list;
        }
        int columns = matrix[0].length;
        for(int i=0; i<=(rows-1)/2 && i<=(columns-1)/2; i++) {
            for(int j=i; j<(columns-i);j++) {
                list.add(matrix[i][j]);
            }

            for(int k=i+1; k<(rows-i);k++) {
                list.add(matrix[k][columns-i-1]);
            }

            for(int l=columns-i-2; l>=i && (rows-i-1>i);l--) {
                list.add(matrix[rows-i-1][l]);
            }

            for(int m=rows-i-2; m>i && columns-1>2*i;m--) {
                list.add(matrix[m][i]);
            }
        }
        return list;
    }

    public static void printList(List<Integer> list) {
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4,5,6,7},{8,9,10,11,12,13,14},{15,16,17,18,19,20,21},{22,23,24,25,26,27,28},{29,30,31,32,33,34,35}};
        int[][] b = {{1,2,3},{4,5,6}};
        int[][] c = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] d = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        int[][] e = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
//        int[][] e = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15},{16,17,18}};

       List<Integer> listA = spiralOrder(a);
        List<Integer> listB = spiralOrder(b);
        List<Integer> listC = spiralOrder(c);
        List<Integer> listD = spiralOrder(d);
        List<Integer> listE = spiralOrder(e);
        printList(listA);
        printList(listB);
        printList(listC);
        printList(listD);
        printList(listE);
    }
}

