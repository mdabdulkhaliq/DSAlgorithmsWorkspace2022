import java.util.HashSet;
import java.util.Set;

/*
Problem Statement: Remove Duplicate characters from a given String
Input: mohammed
Output: mohaed
Logic:
    Loop through each charcater of the string
    Maintain a HashSet which save the characters from the string
    If the HashSet has the character it means it is a duplicate so skip
    If not append the character to a StringBuffer
*/
public class A_RemoveDuplicateCharacters {
    public static void main(String[] args) {
        String input = "mohammed";
        removeDuplicateCharacters(input);
    }

    public static void removeDuplicateCharacters(String input){
        StringBuilder result = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<input.length(); i++){
            if(!set.contains(input.charAt(i))){
                set.add(input.charAt(i));
                result.append(input.charAt(i));
            }
        }
        System.out.println("String without duplicates " + result.toString());
    }
}
