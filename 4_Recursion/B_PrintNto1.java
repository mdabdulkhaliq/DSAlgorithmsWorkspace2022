/*
    Print N to 1
Hypothesis
----------
    print(n) - N to 1
    print(n-1) - n-1 to 1

Induction
---------
    We need to print N and then call print(n-1) and it will take care of everything. 

Base condition
--------------
    least possible input = 1 so when 1 is reached print 1 and return

Pseudo Code:
------------
    void print(n)
        if n == 1 //Base condition
            print 1
            return
        print n //Induction
        print(n-1) //Hypothesis
 */

public class B_PrintNto1 {
    public static void main(String[] args) {
        print(7);
    }

    public static void print(int n){
        //Base condition
        if(n==0){
            return;
        }

        //Induction
        System.out.print(n + " ");

        //Hypothesis
        print(n-1);
    }
}