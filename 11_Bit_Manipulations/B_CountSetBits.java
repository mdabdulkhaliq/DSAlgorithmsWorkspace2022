/*
Count number of bits that are set in the binary representation of a number N.
Method 1:
    We convert a number/decimal to binary by dividing it by 2 and the remainder is the bit we need.
    Logic:
        Check if the remainder of the number after dividing by 2 is 0, if yes then increase the count of set bits.
        instead of checking for remainder we can also check the last bit by doing a bitwise AND with 1 and then removing the last bit by right shift or n/2
    Time Complexity: O(d) no. of binary bits present in the number.
Method 2:
    Brian Kerningam's Algorithm: Traverse only through the set bits.
    Time Complexity: O(no. of set bits)
    Do a bitwise AND with the number n and n-1
    This will make the first set bit as 0, and then repeat the process.
Method 3:
    Lookup table solution
        The idea is to set count bits in O(1) time with some preprocessing involved.
    Assumption: We have 32 bit numbers.
    Precompute counts for 8 bit numbers(0 to 255)
    32 bit numbers has 4 sets of 8 bits, right shift to get next set of 4 bits.
    Generate a 32 bit number which has all last 8 bits as set, which will be 0xff (hexadecimal), ff means all four bits are set, which is basically number 255.
    So if we do a bitwise AND of a 32 bit number with 255 which has all its 8 bits set as 1, it will remove 24 bits or make 24 bits of the number as 0.
    TimeComplexity: O(1)
*/
public class B_CountSetBits {
    public static void main(String[] args) {
        int n=13;
        int count = countSetBits(n);
        System.out.println(count);

        int count1 = countSetBits1(n);
        System.out.println(count1);

        int count2 = countSetBits2(n);
        System.out.println(count2);

        //Lookup table
        int[] table = new int[256];
        //pre-processing
        table = initialize(table);
        //Get set bits
        int count3 = countSetBits3(n, table);
        System.out.println(count3);

    }

    public static int countSetBits(int n){
        int result = 0;
        while(n > 0){
            if(n%2 == 1)
                result++;
            n = n/2;
        }
        return result;
    }

    public static int countSetBits1(int n){
        int result = 0;
        while(n > 0){
            result = result + (n&1);
            n = n/2;
        }
        return result;
    }

    public static int countSetBits2(int n){
        int result = 0;
        while(n > 0){
            //This will make the first set bit from right to 0.
            n = n&(n-1);
            result = result + 1;
        }
        return result;
    }

    public static int[] initialize(int[] table){
       table[0] = 0;
       for(int i=1; i<256;i++){
           table[i] = table[i&(i-1)] + 1;
       }
       return table;
    }

    public static int countSetBits3(int n, int[] table){
        //We need not do bitwise AND with last 8 bits as there are only 8 bits left and nothing before to make as 0
        return table[n & 255] + table[(n>>8) & 255] + table[(n>>16) & 255] + table[(n>>24)];
    }
}
