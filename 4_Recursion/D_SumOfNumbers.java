public class D_SumOfNumbers {
    public static void main(String[] args) {
        int n = 10;
        int sum = printSum(n);
        System.out.println(sum);
    }

    public static int printSum(int n){
        if(n == 0)
            return 0;
        
        return n + printSum(n-1);
    }
}
