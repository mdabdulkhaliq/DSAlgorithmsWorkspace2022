/*
Find the Greatest Common Divisor or the Highest Common Factor of 2 numbers.
Method 1:
    If there are 2 numbers 100 and 200.
    The greatest common factor can be the minimum of 2 numbers which is 100, but not greater than that.
    So start with the minimum number and decrement it until you find the number that divides both the numbers.
    Time Complexity: O(min(a,b))
Method 2:
    Euclid Algorithm: 
        Let b be smaller than a, then gcd(a,b) = gcd(a-b,b)
    Explanation of Algorithm:
        Let g be GCD of a and b
        Which means g is the greatest common divisor of a and b
        which can be written as
        a = gx and b = gy
        so x and y have no more common factors so
        gcd(x,y) = 1
        a - b = gx - gy
        a - b = g(x-y)
        So we need to now prove b and a-b also have g as GCD to prove the theorem.
        Which is true because if x-y had one more common factor there would have been g*? (x-y) which contradicts gcd(x-y) = 1
        Hence gcd (a,b) = gcd(a-b,b)
    Dry Run:
        a = 12, b = 15
        a = 12, b = 3
        a = 9, b = 3
        a = 6, b = 3
        a = 3, b = 3
*/
public class E_GCD_HCF {
    public static void main(String[] args) {
        int a = 100, b = 200;
        printGCD1(a,b);
        int gcd = printGCD2(a,b);
        System.out.println("printGCD2 " + gcd);
    }
    public static void printGCD1(int a, int b){
        int gcd = Math.min(a, b);
        while(gcd > 0){
            if(a%gcd == 0 && b%gcd == 0) {
                break;
            }
            gcd--;
        }
        System.out.println(gcd);
    }
    public static int printGCD2(int a, int b){
        while(a != b){
            if(a > b){
                a = a-b;
            } else {
                b = b-a;
            }
        }
        return a;
    }
}