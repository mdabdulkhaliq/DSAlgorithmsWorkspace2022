/*
    Check if kth bit in the binary representation of a number n is set.
Naive Method:
    To check if the last bit of a number is set or not we can do a bitwise AND with 1.
    Result is yes if last bit is set and no if the last bit is not set.
    Logic:
        So to check if the Kth bit is set in the binary representation of a number n, we need to do bitwise AND with a number X whose only kth bit is set.
        So X can be calculated as 2^k-1, as the sequence of bit representation starts with 2^0, 2^1, 2^2, ....
Alternative Naive Method:
    Keep dividing n by 2 for k-1 times, this will bring the kth bit to the last position.
    Then do a bitwise AND of the number with 1 to get the result.
Efficient Method 1 from Naive Method 1:
    Start with x=1 and left shift x -> k-1 times, this will create a number x with its kth bit set.
    Then do a bitwise AND of n and x to get the result.
Efficient Method 2 from Alternate Method:
    To get the kth bit from n instead of dividing it by 2, right shift n -> k-1 times this will bring kth bit to the right most end (LSB) and then do a bitwise AND with 1 to get the result.
*/
public class A_CheckIfKBitIsSet {
    public static void main(String[] args) {
        int n=5, k=3;
        boolean result = checkKBitIsSet(n, k);
        System.out.println(result);

        boolean result1 = checkKBitIsSet1(n, k);
        System.out.println(result1);
        
        boolean result2 = checkKBitIsSet2(n, k);
        System.out.println(result2);

        boolean result3 = checkKBitIsSet3(n, k);
        System.out.println(result3);
    }

    public static boolean checkKBitIsSet(int n, int k) {
        int x = 1;
        for(int i=0; i<k-1; i++)
            x = x * 2;
        
        if((n&x) != 0)
            return true;
        else
            return false;
    }

    public static boolean checkKBitIsSet1(int n, int k) {
        for(int i=0; i<k-1; i++)
            n = n/2;
        
        if((n&1) != 0)
            return true;
        else
            return false;
    }

    public static boolean checkKBitIsSet2(int n, int k) {
        int x = (1 << (k-1));

        if((n&x) != 0)
            return true;
        else
            return false;
    }

    public static boolean checkKBitIsSet3(int n, int k) {
        int x = (n >> (k-1));
        
        if((x&1) != 0)
            return true;
        else
            return false;
    }
}
