/*
    *
   * *
  * * *
 * * * *
 is almost same as with a space before *
          *
        * *
      * * *
    * * * *
*/

public class StarPattern_7 {
    public static void main(String[] args) {
        //For no. of rows
        for(int i=1; i<=4; i++){
            //for spaces pattern
            for(int j=3;j>=i;j--){
                System.out.print(" ");
            }
            //for * pattern
            for(int k=1; k<=i; k++){
                System.out.print(" *");
            }
            System.out.println();
        }

        anotherSolution();

    }

    public static void anotherSolution(){
        System.out.println("Another Solution");
        for(int i=1; i<=4; i++){
            for(int j=4; j>=1; j--){
                if(j>i){
                    System.out.print(" ");
                } else{
                    System.out.print(" *");
                }
            }
            System.out.println();
        }
    }

}