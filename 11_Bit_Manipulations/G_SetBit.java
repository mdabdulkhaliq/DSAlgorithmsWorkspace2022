/*
    Set Bit at a given positon in a number
    Create BitMask by left shifting the number 1 by the given position so that the digit is 1 at the given position and rest are all 0.
    Perform a Bit wise OR with the given number
    The result will be that the digit at the given position in the number will be set (1)
*/
public class G_SetBit {
    public static void main(String[] args) {
        int n =5;        
        int pos = 1;

        int bitMask = 1<<pos;
        int newNumber = bitMask | n;

        System.out.println(newNumber);
    }
}
