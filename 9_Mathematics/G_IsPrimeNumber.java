/*
Check if a number is prime number.
A number is prime if it is divisible by 1 and itself.
Method 1 Logic:
    Check if there is a number from 2 to n-1 if there is any other number which divides the number then it is not a prime number.
Time Complexity: O(n)
Method 2 Logic:
    Divisors always occur in pair.
    30: (1,30) (2,15) (3,10) (5,6) (6,5) (10,3) (15,2) (30,1)
    So we need not check all number from 2 to n-1 and just check till sqrt(n)
    if (x,y) is a pair
        x*y=n
    And if x<=y
        x*x<=n
        x<sqrt(n)
    So start from 2 till sqrt of n, if we find a divisor it is not a prime
    anything greater than sqrt(n) will the number we would have already found it in the pair
    Time Complexity: O(sqrt(n))
Method 3: For larger n values, explanation inline with code.
    Time Complexity: O(sqrt(n)) but will be 3 times faster as we eliminate no of checks by 3/5 checks
    
*/
public class G_IsPrimeNumber {
    public static void main(String[] args) {
        int n = 17;
        checkPrime(n);
        boolean result = checkPrime1(n);
        System.out.println(result);
    }

    public static void checkPrime(int n){
        boolean prime = true;
        for(int i=2;i<n;i++){
            if(n%i == 0)
                prime = false;
        }
        if(prime)
            System.out.println("It is a prime number");
        else
            System.out.println("Not a prime number");
    }

    public static boolean checkPrime1(int n) {
        if(n==1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
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
}
