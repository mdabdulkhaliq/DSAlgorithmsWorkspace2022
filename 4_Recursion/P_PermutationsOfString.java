/*
    Print all permutations of a string
    Logic:
        Loop through all characters one by one.
        Fix that character and call recursively with all remaining characters.
        Base condition if no characters remaining print that combination
    Time complexity: n * n-1 * n-2 ..... => O(n!)
*/
public class P_PermutationsOfString {
    public static void main(String[] args) {
        String input = "abc";
        printPermutations(input, "");
    }

    public static void printPermutations(String input, String permutation){

        //processed all characters in input
        if(input.length() == 0){
            System.out.println(permutation);
            return;
        }

        for(int i=0; i<input.length(); i++){
            //Get the current character for fix first
            char currentChar = input.charAt(i);

            //substring start index to last index (last index not included in substring)
            //substring start index - till end if last index not provided
            //the below will take all character before the current char and all chars after the current char
            String newInput = input.substring(0, i) + input.substring(i+1);
            
            //
            printPermutations(newInput, permutation+currentChar);
        }

    }
}
