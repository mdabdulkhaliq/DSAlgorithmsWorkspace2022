/*
    * * * *
    * * *
    * *
    *
    Pattern has 4 rows and 4 columns.
    i   j
    -----
    1   4
    2   3
    3   2
    4   1
    First for loop is for rows
    Second for loop is for columns
    Value of i -> 1 to 4
    Value of j -> 4 to >= i
*/
public class StarPattern_2 {
    public static void main(String[] args) {
        for(int i=1; i<=4; i++){
            for(int j=4; j>=i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}