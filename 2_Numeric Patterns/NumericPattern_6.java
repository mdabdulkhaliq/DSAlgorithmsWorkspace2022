/*
5 4 3 2 1
4 3 2 1
3 2 1
2 1
1
*/

public class NumericPattern_6 {
    public static void main(String[] args) {
        //for rows
        for(int i=1; i<=5; i++){
            for(int j=5; j>=i; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}