/*
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1

no. of rows n=5
i=1 j=1 to 5
i=2 j=1 to 4
i=3 j=1 to 3
i=4 j=1 to 2
i=5 j=1 to 1

i=1 to n
j=1 to n-i+1
*/

public class NumericPattern_9 {
    public static void main(String[] args) {
        int n=5;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
