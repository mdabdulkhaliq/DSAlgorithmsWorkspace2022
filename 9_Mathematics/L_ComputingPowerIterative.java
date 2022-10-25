/*
    Compute Power of a number using Iterative approach - Binary Exponentiation
Logic:
    Every number can be written as sum of power of 2(set bits in binary representation)
    We can traverse through all bits of a number from Least Significant Bit (LSB) to Most Significant Bit (MSB) in O(log n) time
    For x^n
        result = 1
        while(n > 0)
            if(n%2 != 0)
                Bit is 1
            else
                Bit is 0
            n = n/2
            x = x*x
Example:
    3^10 = 3^8 * 3^2
        10 = 1 0 1 0 = 3^2 * 1 + 3^8 * 1
    3^19 = 3^16 * 3^2 * 3^1
        19 = 1 0 0 1 1 = 3^1 * 1 + 3^2 * 1 + 3^16 * 1
Iteration of code:
    x=4, n=5
    Initially: answer = 1
    Ist Iteration: answer = 4, x = 16, n = 2
    2nd Iteration: answer = 4, x = 16*16 = 256, n = 1
    3rd Iteration: answer = 4 * 256 = 1024, x = 256*256 = 65536, n = 0
Time Complexity: O(log n)
Aux Space Complexity: O(1) better than recursive approach
*/
public class L_ComputingPowerIterative {
    public static void main(String[] args) {
        int x=4, n=5;
        int result = power(x,n);
        System.out.println(result);
    }    

    public static int power(int x, int n){
        int answer = 1;
        while(n>0){
            if(n%2!=0){ // This can be improved in performance by writing it as n & 1 (bitwise & operator that checks n is odd or not, value is non 0 only when n is odd, because we are doing bitwise AND with 1 whose last bit is 1, cant be used in Java only in CPP)
                answer = answer * x;
            }
            x = x*x;
            n=n/2; // use right shift operator by 1, which means we are dividing n by 2.
        }
        return answer;
    }
}
