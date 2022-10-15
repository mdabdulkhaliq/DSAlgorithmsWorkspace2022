/*
* * * * *
*       *
*       *
*       *
* * * * *
is same as below with stars removed in between
* * * * *
* * * * *
* * * * *
* * * * *
* * * * *
*/

public class StarPattern_14 {
    public static void main(String[] args) {
      //to print entire block of stars 
      /* for(int i=1; i<=5; i++) {
         for(int j=1; j<=5; j++) {
           System.out.print("*");
         }
         System.out.println("");
       } */

       for(int i=1; i<=5; i++) {
        for(int j=1; j<=5; j++) {
          if(i>1 && j>1 && i<5 && j<5)
            System.out.print(" ");
          else
            System.out.print("*");
        }
        System.out.println("");
      }


    }
}