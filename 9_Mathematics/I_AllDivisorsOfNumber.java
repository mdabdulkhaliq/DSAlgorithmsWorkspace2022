/*
Find all divisors of a number
Naive Solution:
    Loop through all numbers from 1 to n and divide by it.
    If it is divisible then it is a factor.
    Time Complexity: O(n)
Efficient Solution:
    Since factors appear in pairs, check till sqrt of n, if a factor is found, then divide n by the factor to get the other factor.
    The problem with this method is that the order of the factors is not maintained.
    Time compexity: O(sqrt n)
Improved Efficient Solution:
    Print all factors from 1 to sqrt(n) and dont print the other factor which lies on the other side of sqrt(n)
    In the next loop continue to go back and then print the factors.
*/
public class I_AllDivisorsOfNumber {
    public static void main(String[] args) {
        int n = 12;
        getAllDivisors(n);
        System.out.println();
        getAllDivisors1(n);
        System.out.println();
        getAllDivisors2(n);
    }

    public static void getAllDivisors(int n){
        for(int i=1;i<=n;i++){
            if(n%i == 0){
                System.out.print(i + " ");
            }
        }
    }

    public static void getAllDivisors1(int n){
        for(int i=1;i*i<=n;i++){
            if(n%i == 0){
                //print the factor
                System.out.print(i + " ");
                //if the other factor is not same , print the other factor that comes after sqrt(n)
                if(i != n/i){
                    System.out.print(n/i + " ");
                }
            }
        }
    }

    public static void getAllDivisors2(int n){
        int i;
        //for n=15, i goes till 4 and breaks as 4*4=16
        //This will print 1, 3
        for(i=1;i*i<=n;i++){
            if(n%i == 0)
                System.out.print(i + " ");
        }
        //i is still 4, continue the loop to print the other factor and go back
        //This will print 5 and 15
        for(;i>=1;i--){
            if(n%i == 0)
                System.out.print(n/i + " ");
        }
    }
}
