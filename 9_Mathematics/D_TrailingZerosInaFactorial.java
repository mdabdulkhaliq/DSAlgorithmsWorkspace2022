/*
Find the trailing zeros in factorial of number n.
Method 1
    Find the factorial of number
    to check the number of trailing zeros, % the number by 10 to get the last digit and check if it is 0 and then / by 10 to get the remaining digits.
    Do the above until we dont find a zero in the last digit.
    Time Complex: O(n)
    Issue: even for number 20 the factorial will be huge and will result in overflow.
Method 2: Efficient
    The number of zeros in a number can be calculated by checking how many 2's and 5's are present in the prime factorization of the given number
    1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10
    The no of 5's will be less than no of 2's, so if we calculate no of 5's that will give us no of 0's that will be in the factorial
    No of 5's in a number n will be atleast n/5. 
    However for n=25 -> 5 10 15 20 25, we counted 5 only once so if the number is greater than 25 we need to count that additional 5, so we also divide by n/25. Similarly if the number is greater than 125, we need to divide by n/125, so on.
    Trailing Zero Count = n/5 + n/25 + n/125 + n/625 + ...
    Time Complexity: O(log n) and no overflows
*/
public class D_TrailingZerosInaFactorial {
    public static void main(String[] args) {
        int n = 10;
        countTrailingZeros1(n);
        countTrailingZeros2(n);
    }

    public static void countTrailingZeros1(int n){
        int fact = 1;
        for(int i=2;i<=n;i++){
            fact = fact * i;
        }
        System.out.println("Factorial is " + fact);
        int trailingZeros = 0;
        while(fact%10 == 0){
            trailingZeros++;
            fact = fact/10;
        }
        System.out.println("Trailing zeros are " +  trailingZeros);
    }
    
    public static void countTrailingZeros2(int n){
        int trailingZeros = 0;
        for(int i=5; i<=n; i=i*5){
            trailingZeros = trailingZeros + n/i;
        }
        System.out.println("Trailing zeros are " + trailingZeros);
    }
}