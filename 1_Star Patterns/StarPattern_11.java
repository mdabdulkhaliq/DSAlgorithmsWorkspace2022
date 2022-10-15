/*
    *
   *
  *
 *
*
is same as space pattern + 1-4 star pattern just remove the stars on the right of the diagonal in star pattern.
____*
___**
__***
_****
*****
*/

public class StarPattern_11 {
    public static void main(String[] args) {
        for(int i=1; i<=5; i++){
            for(int j=5; j>=i; j--){
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++){
                if(k==1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("Approach 2");
        approach2();
    }

    public static void approach2(){
        for(int i=1; i<=5; i++){
            for(int j=5; j>=i; j--){
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++){
                if(i>=2 && k>1){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}