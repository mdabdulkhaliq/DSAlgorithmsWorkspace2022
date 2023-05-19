/*
    Print unique subsequences of the string aaa
    Same as earlier problem, get all subsequences and before printing check if it is unique using a set
    Every character will have a choice of to be printed or not to be printed.
    Make a recursive call with to be printed and another recursive call with to be printed.
*/
import java.util.HashSet;
import java.util.Set;

public class N_PrintUniqueSubsequences {

    public static void main(String[] args) {
        String input = "aaa";
        Set<String> set = new HashSet<>();
        printUniqueSubsequences(input, 0, "", set);
    }

    public static void printUniqueSubsequences(String input, int idx, String result, Set<String> set){

        if(idx == input.length()){
            if(!set.contains(result)){
                set.add(result);
                System.out.println(result);
            }
            return;
        }


        char currentChar = input.charAt(idx);

        //add to result
        printUniqueSubsequences(input, idx+1, result+currentChar, set);

        //do not add to result
        printUniqueSubsequences(input, idx+1, result, set);
    }
}
