/*
Find Least Common Multiple (LCM) of two numbers.
If one number divides the other number, the LCM is the largest number, 2 and 8.
If two numbers do not have a common multiple, their LCM is a*b
Method 1:
    Start with max number = max of a and b.
    If this is max number is divisible by both a and b then max num is LCM.
    increment max number until we reach a number that is divisible by both which will be LCM.
    Time Complexity: O(a*b) or exactly O(a*b-max(a,b)) we are subtracting max(a,b) because we are starting the search from the max number until the worst case which is a*b which can be the LCM
Method 2: Efficient
    Use the formula a * b = gcd(a,b) * lcm(a,b)
*/
public class F_LCMOfTwoNumbers {
    public static void main(String[] args) {
        int a=4, b=6;
        int result = lcm1(a,b);
        System.out.println(result);
        int result2 = lcm2(a,b);
        System.out.println(result2);
    }

    public static int lcm1(int a, int b){
        int lcm = Math.max(a,b);
        while(true){
            if(lcm%a == 0 && lcm%b == 0){
                return lcm;
            }
            lcm++;
        }
    }

    //Method 2
    public static int lcm2(int a, int b){
        return (a*b)/gcd(a,b);
    }

    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }

}
