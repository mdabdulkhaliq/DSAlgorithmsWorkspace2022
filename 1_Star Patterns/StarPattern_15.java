/*
Butterfly pattern
*             *
* *         * *
* * *     * * *
* * * * * * * *
* * * * * * * *
* * * * * * * *
* * *     * * *
* *         * *
*             *
For the first half n=4, and when
i=1 1star 6spaces 1star
i=2 2star 4spaces 2star
i=3 3star 2spaces 3star
i=4 4star 0spaces 4star
For 1st part stars its based on i, for spaces its based on 2*(n-i), 2nd part stars is also based on i
For the second part flip the above logic instead of from 1 to n, go from n to 1
*/ 

public class StarPattern_15 {
    public static void main(String[] args) {
        int n =5; //for each half
        
        //Upper half
        //Rows 1 to n
        for(int i=1; i<=n; i++){
            //For stars on left
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            //print spaces
            int spaces = 2*(n-i);
            for(int k=1;k<=spaces;k++){
                System.out.print("  ");
            }
            //for stars on right
            for(int l=1; l<=i; l++){
                System.out.print("* ");
            }
            System.out.println("");
        }

        //Lower half
        //Rows n to 1
        for(int i=n; i>=1; i--){ //this statement is the only change for lower half
            //For stars on left
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            //print spaces
            int spaces = 2*(n-i);
            for(int k=1;k<=spaces;k++){
                System.out.print("  ");
            }
            //for stars on right
            for(int l=1; l<=i; l++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}