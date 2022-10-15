/*
*
 *
  *
   *
    *
is same as 1-4 star pattern with spaces before instead of stars.
*
_*
__*
___*
____*
*/

public class StarPattern_10 {
    public static void main(String[] args) {
        for(int i=1; i<=5; i++){
            for(int j=1; j<=i; j++){
                if(j == i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("Approach 2");
        approach2();
    }

    public static void approach2(){
        for(int i=1; i<=5; i++){
            for(int j=1; j<=i; j++){
                if(i>=2 && j<=i-1)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}