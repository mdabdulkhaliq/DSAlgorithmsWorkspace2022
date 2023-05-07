/*
Diamond Pattern
   *
  ***
 *****
*******
*******
 *****
  ***
   *

For n=4
i=1 3spaces 1stars
i=2 2spaces 3stars
i=3 1spaces 5stars
i=4 0spaces 7stars
logic for spaces is 1 to n-i
logic for stars is 1 to 2*i-1 (odd number)
*/

public class StarPattern_17{
    public static void main(String[] args) {
        int n=4;
        
        //for upper half
        //for rows
        for(int i=1; i<=n; i++){
            //for spaces
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            //for stars
            for(int k=1; k<=2*i-1; k++){
                System.out.print("*");
            }
            System.out.println("");
        }

        //for lower half
        //for rows
        for(int i=n; i>=1; i--){
            //for spaces
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            //for stars
            for(int k=1; k<=2*i-1; k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}