/*https://www.youtube.com/watch?v=T8ErAYobcbc&ab_channel=Vivekanand-AlgorithmEveryDay
Print element of a matrix diagonally upwards.
    1  2  3  4
    5  6  7  8
    9  10 11 12
    13 14 15 16
Result:
   1
   5 2
   9 6 3
   13 10 7 4
   14 11 8
   15 12
   16
Logic:
    If the matrix contains m=4 rows and n=5 columns
    00 01 02 03 04
    10 11 12 13 14
    20 21 22 23 24
    30 31 32 33 34
    To print diagonal elements print all element starting in rows and then all elements starting in columns (last row upwards).
    This will have a duplicate entry for element present at 30 position as it is common for both row and column, so skip in during column traversal.
    To print all elements arr[i][j] from rows start from i = 0 to m-1(4) and starting value of j=0 (first column)
    print arr[i][j] and then i=i-1 and j=j+1 will give next diagonal element until i >= 0 (until there are no more rows) for rows loop.
    To print all elements arr[i][j] from the columns start from i=1 instead of 0 to skip 1st column to i = n-1(5) and starting value of j=m-1(last row)
    print arr[i][j] and then i=i-1 and j=j+1 will give next diagonal element until j <= n-1 (until there are no more columns)
 */

public class A_PrintDiagonally {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printDiagonalElements(arr, 4, 4);
    }

    public static void printDiagonalElements(int[][] arr, int rows, int cols){
        //print diagonal element starting with rows
        for(int k=0;k<=rows-1;k++){
            int i = k;
            int j = 0;
            while(i >= 0){
                System.out.print(arr[i][j] + "  ");
                i = i - 1;
                j = j + 1;
            }
            System.out.println();
        }
        //for diagonal elements starting with columns
        for(int k=1;k<=cols-1;k++){
            int i = rows-1;
            int j = k;
            while(j<=rows-1){
                System.out.print(arr[i][j] + "  ");
                i = i - 1;
                j = j + 1;
            }
            System.out.println();
        }
    }
}
