/*
    * * * *
      * * *
        * *
          *
is same as combination of 2 patterns (_ pattern + * pattern)
    _ * * * *
    _ _ * * *
    _ _ _ * *
    _ _ _ _ *
*/

public class StarPattern_5 {
    public static void main(String[] args) {
        //For no. of rows
        for(int i=1; i<=4; i++){
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