/*
    1
   2 2
  3 3 3
 4 4 4 4
5 5 5 5 5

If we analyze with a 2d matrix, when n=5
i=1 4spaces 1-1times
i=2 3spaces 2-2times
i=3 2spaces 3-3times
i=4 1spaces 4-4times
i=5 0spaces 5-5times
*/
public class NumberPattern_11 {
    public static void main(String[] args) {
        int n=5;
        //for rows
        for(int i=1; i<=n;i++){
            //for spaces
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            //for numbers
            for(int k=1;k<=i;k++){
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
