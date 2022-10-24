/*
    Find prime factors of a number
Naive Solution:
    Loop from 2 to n-1
    if the ith value is prime number
        save ith value in x
        Keep checking as long as n%x==0
            print i as this is a prime fator
            x = x * i (to get all prime factors that has i -> 4, 8, 16, ....)
    Time Complexity: O(n * sqrt(n) * logn)
        for loop from 2 to n-1 O(n)
        for loop for is Prime O(sqrt(n))
        log n for while loop O(log n)
Better Solution:
    A number n can be written as multiplication of powers of prime factors
    12 = 2power2 * 3
    450 = 2power1 * 3power2 * 5power2
    As we know that factors appear in pairs we can check from 2 to sqrt(n)
    if a number is divisible by 2 we keep on dividing it by 2, then by 3, so on. to get all powers of prime factors.
Efficient Solution:
    Check for divisibility of n by 2 and 3 outside the loop 
    All other numbers can be checked from i=5 and i+2=7 and increment by 6 which will be 11 and 13, then 17 and 19, so on.
*/
public class H_PrimeFactors {
    public static void main(String[] args) {
        int n = 12;
        System.out.println("Method1:");
        getPrimeFactors(n);
        System.out.println("Method2:");
        getPrimeFactors2(n);
        System.out.println("Method3:");
        getPrimeFactors3(n);
    }

    public static void getPrimeFactors(int n){
        for(int i=2;i<n;i++){
            if((checkPrime2(i))){
                int x = i;
                while(n%x == 0){
                    System.out.println(i);
                    x = x * i;
                }
            }
        }
    }

    public static boolean checkPrime2(int n){
        //1 is not a prime
        if(n==1)
            return false;
        
        //2 and 3 are primes
        if(n==2 || n==3)
            return true;
        
        //Eliminate all multiples of 2 and 3s
        if(n%2==0 || n%3==0)
            return false;
        
        //above cases we already covered 1 to 4, so start with 5
        //increment i by 6 and check for both i and i+2
        //For i=5 it will check for i=5 and 7
        //6,8,9,10 will be covered by 2 and 3 checks at the start
        //then 11 and 13, then 17 and 19 so on.
        for(int i=5;i*i<=n;i=i+6){
            if(n%i==0 || n%(i+2)==0)
                return false;
        }
        
        return true;
    }

    public static void getPrimeFactors2(int n){
        //Since 1 is not prime and has no prime factors
        if(n<=1)
            return;

        //Check all numbers from 2 to sqrt n as factors appear in pairs
        //to get all prime factors keep on dividing the number until its no longer divisible and proceed with next number 
        for(int i=2;i*i<=n;i++){
            while(n%i==0){
                System.out.println(i);
                n = n/i;
            }
        }
        if(n > 1)
            System.out.println(n);
    }

    public static void getPrimeFactors3(int n){
        if(n<=1)
            return;
        while(n%2 == 0) {
            System.out.println(2);
            n = n/2;
        }
        while(n%3 == 0) {
            System.out.println(3);
            n = n/3;
        }
        for(int i=5;i*i<=n;i=i+6){
            while(n%i ==0){
                System.out.println(i);
                n = n/i;
            }
            while(n%(i+2) ==0){
                System.out.println(i+2);
                n = n/(i+2);
            }
        }
        if(n>3) 
            System.out.println(n);
    }
}
