/*
      *
    *   *
  *       *
*           *
is same as below pattern with * in between removed
      *
    * * *
  * * * * *
* * * * * * *
*/

public class StarPattern_12 {
    public static void main(String[] args) {
        //for no of rows
        for(int i=1; i<=5; i++){
            //for spaces before
            for(int j=5; j>=i; j--){
                System.out.print(" ");
            }
            //for all stars, every ith row has i*2-1 stars
            for(int k=1; k<i*2; k++){
                if(k>1 && k<i*2-1)
                  System.out.print(" ");
                else
                  System.out.print("*");
            }
            System.out.println();
        }
    }
}