/*
    *
    * *
    * * *
    * * * *
    Pattern has 4 rows and 4 columns.
    First for loop is for rows
    Second for loop is for columns
    Value of i -> 1 to 4
    Value of j -> 1 to <=i and not 1 to 4.
*/

public class StarPattern_1 {
    public static void main(String[] args) {
        for(int i=1; i<=4; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}