/*
1
2 6
3 7 10
4 8 11 13
5 9 12 14 15

The difference between 1st and 2nd col = 4
The difference between 1st and 2nd col = 3
The difference between 1st and 2nd col = 2
The difference between 1st and 2nd col = 1
formula = i + 5 - j
*/

public class NumericPattern_7 {
    public static void main(String[] args) {
        //for rows
        for(int i=1; i<=5; i++){
            int num = i;
            for(int j=1; j<=i; j++){
                System.out.print(num + " ");
                num = num + 5 - j;
            }
            System.out.println();
        }
    }
}