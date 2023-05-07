/*
Print a Solid Rhombus
        * * * * *
      * * * * *
    * * * * *
  * * * * *
* * * * *  

When n=5, If we put the above in a 2d matrix we see that for i=1 to 5, each line needs
i=1 4spaces 5stars
i=2 3spaces 5stars
i=3 2spaces 5stars
i=4 1spaces 5stars
i=5 0spaces 5stars
*/
public class StarPattern_16 {
    public static void main(String[] args) {
        int n=5;
        //For rows
        for(int i=1; i<=n; i++){
            //for spaces
            for(int j=1; j<=n-i;j++){
                System.out.print("  ");
            }
            //for stars
            for(int k=1;k<=n;k++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}
