import java.util.Arrays;

/*
    Print all prime numbers until N.
Naive Solution:
    Loop from 2 to N and if i is prime, print i.
    Time Complexity: O(n * sqrt(n)) = O(n^3/2)
Efficient Solution:
    Sieve of Eratosthenes Algorithm
        Create a boolean array till n+1
        0 and 1 will be false, rest all will be true by default.
        Mark all multiples of 2, 3 and 5 as false.
        All remaining elements with True are prime numbers.
    Time Complexity: O(n log logn)
Optimized Efficient Solution:
    Replace 2*i with i*i so instead of 2i, 2i+i , 2i+2i.... it will be i^2, i^2+i, i^2+2i, ...
    Earlier for 5: we loop through 10, 15, 20, 25,....
    Now for 5: we start with 25, 30, ...
    The reason is 10, 15, 20 will already be marked as false by smaller factors
    Any number less then i^2 can be written as i*(i-1), i*(i-2), so on. So it means there are smaller divisors than i
    Time Complexity: O(n log logn) almost same as O(n) as log log n is very small.
*/
public class J_AllPrimesUntilN {
    public static void main(String[] args) {
        int n = 10;
        printPrimes(n);
        System.out.println();
        //Sieve of Eratosthenes Algorithm
        printPrimes2(n);
        //Optimized Sieve of Eratosthenes Algorithm
        printPrimes3(n);
    }

    public static void printPrimes(int n){
        for(int i=2; i<=n; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }

    public static void printPrimes2(int n){
        boolean[] isPrime = new boolean[n+1];
        //Default all values with True
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        //If there is no factor till sqrt(n) there will not be any after that.
        for(int i=2; i*i<=n;i++){
            if(isPrime[i]){
                //Eliminate all factors of the prime number
                for(int j=2*i; j<=n; j=j+i){
                    isPrime[j] = false;
                }
            }
        }
        //print all remaining values with true which are prime numbers.
        for(int i=2; i<=n; i++){
            if(isPrime[i]){
                System.out.print(i + " ");
            }
        }
    }

    public static void printPrimes3(int n){
        boolean[] isPrime = new boolean[n+1];
        //Default all values with True
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i<=n; i++){
            if(isPrime[i]){
                System.out.print(i + " ");
                for(int j=i*i; j<=n; j=j+i){
                    isPrime[j] = false;
                }
            }
        }
    }

    public static boolean isPrime(int n) {
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
}
