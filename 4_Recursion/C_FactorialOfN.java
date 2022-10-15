/*
Factorial of N
Hypothesis
----------
fact(n) = n * n-1 * n-2 * …. * 1
fact(n-1) = n-1 * n-2 * n-3 * …. * 1

Induction
---------
so for fact(n) we need to print n * fact(n-1)

Base condition 
-------------
when n = 1 return

Pseudo Code
-----------
void fact(n)
	if n == 1 // Base Condition
		return
	return n * fact(n-1) //Induction and Hypothesis
 */

public class C_FactorialOfN {
    public static void main(String[] args) {
        int factorial = factorial(7);
        System.out.println(factorial);
    }

    public static int factorial(int n){
        //Base Condition
        if(n == 1)
            return 1;
        
        //Induction is multiplying n and Hypothesis is calling on smaller input.
        int factorial = n * factorial(n-1);

        return factorial;
    }
}
