/*
          *
        * *
      * * *
    * * * *
is same as combination of 2 patterns (_ pattern + * pattern)
    _ _ _ *
    _ _ * *
    _ * * *
    * * * *
Every row has n-i spaces and i stars, where n is no. of rows.
for n=4 and for i = 1 to n i.e 4
3 space + 1 star
2 space + 2 star
1 space + 3 star
0 space + 4 star
*/

public class StarPattern_4 {
    public static void main(String[] args) {
        //For no. of rows
        for(int i=1; i<=4; i++){
            //for spaces pattern
            for(int j=3;j>=i;j--){ //or j=1 to n-i spaces
                System.out.print(" ");
            }
            //for * pattern
            for(int k=1; k<=i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        

    }
}