/*
        *
      * *
    * * *
  * * * *
* * * * *
  * * * *
    * * *
      * *
        *
is same as
________*
______* *
____* * *
__* * * *
* * * * *
and
* * * * *
__* * * *
____* * *
______* *
________*
This is same as combination of 
spaces on top left + stars on the top right + 
spaces on bottom left + stars on bottom right
bottom right start pattern start with 1 row less to avoid duplicate
*/

public class StarPattern_6 {
    public static void main(String[] args) {
        //For no. of rows
        for(int i=1; i<=5; i++){
            //for spaces pattern
            for(int j=4;j>=i;j--){
                System.out.print(" ");
            }
            //for * pattern
            for(int k=1; k<=i; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        //For no. of rows
        for(int i=1; i<=5; i++){
            //for spaces pattern
            for(int j=1;j<=i;j++){
                System.out.print(" ");
            }
            //for * pattern
            for(int k=4; k>=i; k--){
                System.out.print("*");
            }
            System.out.println();
        }
        

    }
}