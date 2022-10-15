/*
    *
    * *
    * * *
    * * * *
    * * *
    * *
    *
is same as
    *
    * *
    * * *
    * * * *
and
    * * * *
    * * *
    * *
    *
    This is combination of pattern 1 and pattern 2
    Do 1 less iteration for pattern 2 to avoid the 4* being shown twice
    Code contains 4 for loops. 1 nested for top pattern and another nested for bottom pattern
*/

public class StarPattern_3 {
    public static void main(String[] args) {
        //top pattern
        for(int i=1; i<=4; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //bottom pattern with one less row to remove duplicate
        for(int i=1; i<=4; i++){
            for(int j=3; j>=i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}