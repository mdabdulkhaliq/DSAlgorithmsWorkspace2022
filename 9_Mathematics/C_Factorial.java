public class C_Factorial {
    public static void main(String[] args) {
        int num = 5;
        factorialIterative(num);
        int result = factorialRecursive(num);
        System.out.println("Factorial Recursive is " + result);
    }

    //O(n) time complexity
    //O(1) space complexity
    public static void factorialIterative(int num){
        int fact = 1;
        for(int i=2; i<=num; i++){
            fact = fact * i;
        }
        System.out.println("Factorial Iterative is " + fact);
    }

    //O(n) time complex
    //O(n) space complex - at given point in stack there are n variable to store num values from num * fact(n-1)
    public static int factorialRecursive(int num){
        if(num == 0)
            return 1;
        
        return num * factorialRecursive(num-1);
        
        
    }

}
