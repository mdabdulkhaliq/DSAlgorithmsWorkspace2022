/*
    Remove duplicate characters from a string
    Create an array of 26 length for each alphabet, default to false
    If a character is found set the value for that character in array to true
    Check for each character if value is true or false
    If false, add to result and make it to true
    Once we go beyond string length print result and return
*/
public class L_RemoveDuplicateChars {

    public static StringBuilder result = new StringBuilder();
    public static boolean[] alphabets = new boolean[26];

    public static void main(String[] args) {
        String input = "abbccdeef";
        removeDuplicateChars(input, 0);
    }

    public static void removeDuplicateChars(String input, int idx){

        //Once the index is beyond the last char index, print and return
        if(idx == input.length()){
            System.out.println(result);
            return;
        }

        //c-a will return 2, so check the value at index 2, if value is set as true, dont add character to result.
        //then set that character index as true as we found it once
        if(!alphabets[input.charAt(idx) - 'a']){
            result.append(input.charAt(idx));
            alphabets[input.charAt(idx) - 'a'] = true;
        }
        removeDuplicateChars(input, idx+1);
    }
}