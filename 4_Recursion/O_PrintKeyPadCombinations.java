/*
    Print all combinations for keypad strokes from an old phone
    pressing 0 will print .
    pressing 1 once will print a, pressing 1 twice will print b, pressing 1 thrice will print c so on.
    So if an input is given as 23 print all combinations possible
    Logic:
        For every digit in input get the mapping from keypad
        For every character in the mapping call the next recursive call for next digit
    Time Complexity: O(4^n) , assuming there are 4 characters in each mapping and n is no of digits in input string
*/
public class O_PrintKeyPadCombinations {
    
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) {
        String input = "23";    
        printCombinations(input, 0, "");
    }

    public static void printCombinations(String input, int idx, String combination){

        if(idx == input.length()){
            System.out.println(combination);
            return;
        }

        //Retrieve current digit from input
        char currentChar = input.charAt(idx);
        
        //Get mapping for the digit (since its a character to convert to int index subtract character '0')
        String mapping = keypad[currentChar - '0'];

        //Select every character in the result one by one and move on to next character combinations in the input
        for(int i=0; i<mapping.length(); i++){
            printCombinations(input, idx+1, combination+mapping.charAt(i));
        }

    }
}