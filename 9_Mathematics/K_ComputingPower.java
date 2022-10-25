/*
    Compute power of x raised to n
Method 1:
    Multiply x , n number of times.
    Time Complexity: O(n)
Efficient Solution:
    power(x,n) = if n%2 == 0, then it can be written as power(x,n/2) * power(x,n/2)
        else it can be written as power(x,n-1) * x
    Example:
        pow(3,5) -> temp = 3*3, temp = 3*3*3*3, n is odd, return 3*3*3*3*3
            temp = pow(3,2) -> temp = 3, temp = 3*3, n is even, return 3*3
                temp = pow(3,1) -> temp = 1, temp = 1*1, n is odd, returns 1*3
                    temp = pow(3,0) -> base condition returns 1
    Time Complexity: Recursively calling n/2 - O(log n) + constant work for log n times. = O(log n)
    Space Complexity: O(log n) auxillary space
*/
public class K_ComputingPower {
    public static void main(String[] args) {
        int x=3, n=4;
        int result = computePower(x,n);
        System.out.println(result);
        int result1 = computePower1(x,n);
        System.out.println(result1);
    }

    public static int computePower(int x, int n){
        int result=1;
        for(int i=1;i<=n;i++){
            result = result * x;
        }
        return result;
    }

    public static int computePower1(int x, int n){
        if(n==0)
            return 1;
        int temp = computePower1(x, n/2);
        temp = temp * temp;
        if(n%2 == 0)
            return temp;
        else
            return temp * x;
    }
}
