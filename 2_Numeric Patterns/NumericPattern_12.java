/*
    1 
   212
  32123
 4321234
543212345

Logic: for n=5
i=1 spaces=4 and numbers=1 to 1 and nothing
i=2 spaces=3 and numbers=2 to 1 and numbers=2to2
i=3 spaces=2 and numbers=3 to 1 and numbers=2to3
i=4 spaces=1 and numbers=4 to 1 and numbers=2to4
i=5 spaces=0 and numbers=5 to 1 and numbers=2to5

spaces=n-i
first set of numbers i to 1
second set of numbers 2 to i
*/

public class NumericPattern_12 {
    public static void main(String[] args) {
        int n=5;
        //for rows
        for(int i=1; i<=n; i++){
            //for spaces
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            //for first set of numbers
            for(int k=i; k>=1; k--){
                System.out.print(k);
            }
            for(int l=2; l<=i; l++){
                System.out.print(l);
            }
            System.out.println("");
        }
    }    
}
