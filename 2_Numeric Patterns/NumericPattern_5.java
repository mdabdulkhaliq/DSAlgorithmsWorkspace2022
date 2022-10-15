/*
    1
    1 2 1
    1 2 3 2 1
    1 2 3 4 3 2 1
    1 2 3 4 5 4 3 2 1
this is same as
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5 
plus
1
2 1
3 2 1
4 3 2 1
5 4 3 2 1
*/

public class NumericPattern_5 {
    public static void main(String[] args) {
        //for rows
        for(int i=1; i<=5; i++){
            //for first pattern
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            //for 2nd pattern, to remove duplicate column start with i-1
            for(int k=i-1; k>=1; k--){
                System.out.print(k);
            }
            System.out.println();
        }
    }
}