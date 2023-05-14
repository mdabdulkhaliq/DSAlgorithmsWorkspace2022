public class E_Fibonacci {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int n = 10; //to be printed till nth term
        System.out.print(a + " ");
        System.out.print(b + " ");
        //n-2 because we already printed 2 terms above
        fibonacci(a, b, n-2);
    }

    public static void fibonacci(int a, int b, int n){
        if(n == 0)
            return;

        int c = a+b;
        System.out.print(c + " ");

        fibonacci(b, c, n-1);
    }
}
