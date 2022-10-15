/*
    Not all problems will have choices and recursive tree another way is IBH.
    Approach: Base Condition - Induction - Hypothesis
    Hypothesis - Method signature, return value and result.
    Induction: Calling hypothesis recursively
    Base Condition: Smallest valid input / Largest invalid input

Problem Statement:
------------------
    n = 7
    Result: 1 2 3 4 5 6 7
Hypothesis:
-----------
    print (n) = print (7) =  1 2 3 4 5 6 7
    call the same on smaller input
    print (n-1)  = print (6) = 1 2 3 4 5 6
Induction:
----------
    print n = print (n-1) + print n
Base condition:
---------------
    Smallest valid input is 1
    if n == 1
        return 1

Pseudo Code
-----------
    void print(n)
        if n == 1 // Base Condition
            print 1
            return
        print (n-1) //Hypothesis
        print n //Induction

Recursive Tree
--------------
    print(7) - print(6) - print(5) - print(4) - print(3) - print(2) - print(1)
    Will go to the hierarchy until it reaches base condition then prints 1, then goes back to the next statement after print(1) and prints 2 so on ….
    When we don't have decisions and choices, then we try to make the input smaller. Just take one level down and design the BHI.

 */
public class A_Print1toN {
    public static void main(String[] args) {
        print(7);
    }

    public static void print(int n){
        //Base condition
        if(n==1){
            System.out.print(1 + " ");
            return;
        }
        //Hypothesis
        print(n-1);

        //Induction
        System.out.print(n + " ");
    }
}