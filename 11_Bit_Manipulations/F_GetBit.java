/*
    Identiy the bit at a given position for a number n
    Create a bitMask by left shifting the number 1 to the position speficied in the problem, so that the digit at the given position becomes 1 and rest all will be 0.
    Now do a bit wise AND with the bitMask number and the actual number
    After the operation, all the digits in other positions will be 0 as bitMask has 0 in all other positions
    For the given position the result will be either 0 or 1
    Since the bitMask has 1 at the given position so if the result is 1 (non zero number) the digit in the number is also 1, if the result is 0 it means the digit was also 0 at the given position
*/
public class F_GetBit {
    public static void main(String[] args) {
        int n = 5;
        int pos = 2;
        
        int bitMask = 1<<pos;

        if ((bitMask & n) == 0)
            System.out.println("Bit was 0");
        else 
            System.out.println("Bit was 1");
    }
}