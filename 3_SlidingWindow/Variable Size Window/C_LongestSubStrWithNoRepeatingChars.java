import java.util.HashMap;
import java.util.Map;

/*
Problem Statement
-----------------
    Longest substring with no repeating characters
    str: p w w k e w
    Result: w k e / k e w

Identification
--------------
    String is given
    Longest substring is asked
    Condition = no repeating characters = j - i + 1

Explanation
-----------
    No repeating characters mean all unique characters. So it means all the elements in the window should be unique, which means no of unique characters should be = j - i + 1 and this should be equal to map.size(). Also in this case map.size() cannot be greater than j - i + 1 because no. of unique characters cannot be greater than the characters in the window.

Pseudo Code
-----------
    while j < size
        //do calculations
        if map.contains( str[j] )
            map.put( str[j] , map.get( str[j] ) + 1)
        else
            map.put( str[j] , 1)
        //If the no of elements in the map is less than the window size, it means there are duplicates, so decrease the window size until it's no longer lesser.
    if map.size() < j - i + 1
            while map.size() < j - i +1
                map.put( str[i] , map.get( str[i] )-- )
                if map.get(str[i]) == 0
                    map.remove( str[i] )
                i++
            j++
        else if map.size() == j - i + 1
            maxLen = Math.max( maxLen, j - i + 1)
            j++
 */
public class C_LongestSubStrWithNoRepeatingChars {
       public static void main(String args[]){
           String text = "pwwkew";
           int maxLength = longestSubStrNoRepeatingChars(text);
           System.out.println(maxLength);
       }

       public static int longestSubStrNoRepeatingChars(String text){
           int i=0,j=0,maxLen=0;
           Map<Character, Integer> charMap = new HashMap<>();
           while(j<text.length()){
               //Operation for the current element
               if(charMap.containsKey(text.charAt(j))){
                   charMap.put(text.charAt(j), charMap.get(text.charAt(j))+1);
               } else {
                   charMap.put(text.charAt(j), 1);
               }
               //Condition check
               if(j-i+1 > charMap.size()){
                   while(j-i+1 > charMap.size()){
                       if(charMap.get(text.charAt(i)) == 1){
                           charMap.remove(text.charAt(i));
                       } else {
                           charMap.put(text.charAt(i), charMap.get(text.charAt(i))-1);
                       }
                       i++;
                   }
                   j++;
               } else if(j-i+1 == charMap.size()){
                   maxLen = Math.max(maxLen, j-i+1);
                   j++;
               }
           }
           return maxLen;
       }
}
