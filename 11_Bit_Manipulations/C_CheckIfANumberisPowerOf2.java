/*
    Check if a number is power of 2
Method 1:
    Repeatedly divide by 2
Efficient Solution:
    Binary representation of powers of 2 have only 1 bit set.
    if count of set bits is 1 return true
*/
public class C_CheckIfANumberisPowerOf2 {
    public static void main(String[] args) {
        int n = 16;
        boolean answer = checkPowerOfTwo(n);
        System.out.println(answer);

        boolean answer1 = checkPowerOfTwo1(n);
        System.out.println(answer1);
    }

    public static boolean checkPowerOfTwo(int n){
        if(n == 0)
            return false;
        while(n != 1){
            if(n%2 !=0)
                return false;
            n=n/2;
        }
        return true;
    }

    public static boolean checkPowerOfTwo1(int n){
        if (n==0)
            return false;
        
        //Since there will be only 1 bit that is set for number that is power of 2.
        //Once we apply Brian's algorithm, the right most 1 will be set as 0 after 1 iteration
        //So the resultant number will be 0 if it is a power of 2
        return ((n&(n-1)) == 0);
    }
}
