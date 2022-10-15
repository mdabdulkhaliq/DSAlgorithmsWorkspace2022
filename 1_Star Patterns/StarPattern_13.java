/*
*       *
  *   *  
    *    
  *   *  
*       *
is same as below with stars removed in between
* * * * *
* * * * *
* * * * *
* * * * *
* * * * *
*/

public class StarPattern_13 {
    public static void main(String[] args) {
      //to print entire block of stars 
      /* for(int i=0; i<5; i++) {
         for(int j=0; j<5; j++) {
           System.out.print("*");
         }
         System.out.println("");
       } */

       for(int i=0; i<5; i++) {
        for(int j=0; j<5; j++) {
          if(i==j || i+j == 5-1)
            System.out.print("*");
          else
            System.out.print(" ");
        }
        System.out.println("");
      }


    }
}