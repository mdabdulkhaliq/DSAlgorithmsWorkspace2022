/*
1   2   3
6   5   4  - Reverse
7   8   9 
12  11  10 - Reverse
13  14  15
18  17  16 - Reverse
*/

public class NumericPattern_8 {
    public static void main(String[] args) {
        /*
        This will print the normal block of
        1 2 3
        4 5 6
        7 8 9, so on.
        int count = 0;
        for(int i=1; i<=5; i++){
            for(int j=1; j<=3; j++){
                count++;
                System.out.print(count + " ");
            }
            System.out.println();
        }
        */

        int count = 0;
        for(int i=1; i<=5; i++){
            //for odd rows - print normal sequence
            if (i%2 != 0){
                for(int j=1; j<=3; j++){
                    count++;
                    System.out.print(count + " ");        
                }
            }
            //for even rows print reverse sequence
            else{
                //starting value for this row
                int temp = count+1;
                //start from 3 values more to that value
                for(int j=count+3; j>=temp; j--){
                    count++;
                    System.out.print(j + " ");        
                }
            }
            System.out.println();  
        }

    }
}