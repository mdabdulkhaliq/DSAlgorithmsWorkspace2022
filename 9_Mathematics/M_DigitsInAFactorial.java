/*
Count digits in a factorial
Naive Approach:
    A naive solution would be to calculate the n! first and then calculate the number of digits present in it. However as the value for n! can be very large, it would become cumbersome to store them in a variable (Unless you’re working in python!). 
Efficient Solution:
    Count digits in a factorial using the property of logarithms
    To solve the problem follow the below idea:
    We know, log(a*b) = log(a) + log(b)
    Therefore log( n! ) = log(1*2*3...*n) = log(1) + log(2) + ... +log(n)
    Now, observe that the floor value of log base 10 increased by 1, of any number, gives the number of digits present in that number. 
    Hence, output would be : floor(log(n!)) + 1.
*/
public class M_DigitsInAFactorial {
    public static void main(String[] args) {
        int n = 120;
        int result = digitsInAFactorial(n);
        System.out.println("No of digits " + result);
    }

    public static int digitsInAFactorial(int n){
        if(n<0)
            return 0;
        if(n<=1)
            return 1;
    
        double digits = 0;
        for(int i=2;i<=n;i++){
            digits = digits + Math.log10(i);
        }

        return (int) Math.floor(digits) + 1;
    }
}