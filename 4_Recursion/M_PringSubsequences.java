/*
    Print subsequences of the string abc
    Every character will have a choice of to be printed or not to be printed.
    Make a recursive call with to be printed and another recursive call with to be printed.
    Time Complexity: O(2^n) , where n is no of characters in the string
*/
public class M_PringSubsequences {
    public static void main(String[] args) {
        String input = "abc";
        printSubsequences(input, 0, "");
    }

    public static void printSubsequences(String input, int idx, String result){

        //If we reach beyond string length, print string and return
        if(idx == input.length()){
            System.out.println(result);
            return;
        }
        
        //Get the current character at given index
        char currentChar = input.charAt(idx);
        
        //Decision 1: to be printed in the result
        printSubsequences(input, idx+1, result+currentChar);

        //Decision 2: not to be printed in the result
        printSubsequences(input, idx+1, result);
    }
}
