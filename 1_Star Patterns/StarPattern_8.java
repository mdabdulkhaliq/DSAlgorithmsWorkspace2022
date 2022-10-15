/*
    *
   ***
  *****
 *******
This pattern is same as combination of 3 patterns spaces 1 - 4 stars on right and 1-4 stars on left
____  *
___  ** *
__  *** **
_  **** ***
*/

public class StarPattern_8 {
    public static void main(String[] args) {
        for(int i=1; i<=4; i++){
            //for spaces pattern on the left
            for(int j=4; j>=i; j--){
                System.out.print(" ");
            }
            //for star pattern on the left
            for(int k=1; k<=i; k++){
                System.out.print("*");
            }
            //for star pattern on the right
            for(int l=2; l<=i;l++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("Approach 2");
        approach2();
    }

    public static void approach2(){
        for(int i=1; i<=4; i++){
            //for spaces pattern on the left
            for(int j=4; j>=i; j--){
                System.out.print(" ");
            }
            //for star pattern, every ith row has i*2-1 stars
            for(int k=1; k<i*2; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}