public class F_XPowN {
    public static void main(String[] args) {
        int result = printPower(2,3);
        System.out.println(result);
    }

    public static int printPower(int x, int n){
        if(x == 0)
            return 0;
        
        if(n == 0)
            return 1;
        
        return x * printPower(x, n-1);
    }

    public static int printPower2(int x, int n){
        if(x == 0)
            return 0;
        
        if(n == 0)
            return 1;
        
        if(n%2 == 0) //even power to reduce stack size by half and make it log n space.
            return printPower2(x, n/2) * printPower2(x, n/2);
        else //when power is odd
            return printPower2(x, n/2) * printPower2(x, n/2) * x;
    }
}
