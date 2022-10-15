/*
*******
 *****
  ***
   *
is same as 1-4 spaces + 4-1 stars + 3-1 stars
_ **** ***
__ *** **
___ ** *
____ *
*/

public class StarPattern_9 {
    public static void main(String[] args) {
        for(int i=1; i<=4; i++){
            //for spaces pattern on the left
            for(int j=1; j<=i; j++){
                System.out.print(" ");
            }
            //for star pattern in the middle
            for(int k=4; k>=i; k--){
                System.out.print("*");
            }
            //for star pattern at the end
            for(int l=3; l>=i; l--){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("Approach 2");
        approach2();
        System.out.println("Approach 3");
        approach3();
    }

    public static void approach2() {
        for(int i=1; i<=4; i++){
            //for spaces pattern on the left
            for(int j=1; j<=i; j++){
                System.out.print(" ");
            }
            //for star pattern
            for(int k=9; k>(i*2); k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void approach3() {
        for(int i=4; i>=1; i--){
            //for spaces pattern on the left
            for(int j=4; j>i; j--){
                System.out.print(" ");
            }
            //for star pattern, every ith row has i*2-1 stars
            for(int k=1; k<(i*2); k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}