/*
    Clear a bit at a given position in a number
    Create a bit mask by left shifting the number to the given position (this will have 1 set at given position rest all bits will be 0)
    Perform a Negation of the BitMask. i.e all bits will become 1 except for the given position bit will be 0
    Perform an AND of BitMask and the actual number so that the bit at the given position becomes 0. (clear)
*/
public class H_ClearBit {
    public static void main(String[] args) {
        int n = 5;
        int pos = 2;
        
        int bitMask = 1<<pos;
        bitMask = ~bitMask;

        int result = bitMask & n;
        System.out.println(result);
    }
}
