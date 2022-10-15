/*
Problem Statement
-----------------
    Minimum window substring
    str: t i m e t o p r a c t i s e
    t: t o c t
    t should be present in str, characters can be present in any order, but with same quantity and need not be continuous.

Identification
--------------
    String is given.
    Substring is asked. (with pattern)
    condition - same no of characters and quantity should be present.

Explanation
-----------
    Store all characters of t in a map with char and its count. Maintain a count variable with map.size() as its value to check if all characters are there or not. While looping through the str, if str[j] is present in the map then decrement that characters value. 
    When the character count is 0, we decrement the count variable and we continue decrementing the character in the map instead of removing it because if the window needs 2 t’s and we get 3 t’s we make it as -1 from 0 so that when 1 t goes out of the window we still have the required 2 t’s and when adding back -1 will be made as 0.
    While adding the character at i index back to the map, if its value becomes 1 then increment the overall count variable also.
    Once we get the count as 0, then we start incrementing i index to see if we can have a smaller window with all characters.

Pseudo Code
-----------
    //add all characters of t to a map
    count = map.size() //Get the no of unique characters
    while j < size
        //do the calculations
        if map.contains( str[j] ) //if the character is in map, then decrement its value
            map.put( str[j] , map.get( str[j] )--)
            if map.get( str[j] ) == 0 //if the value of that char = 0 then decrement count
                count--
        if count == 0 //this means that all characters are present in window
            while count == 0 //try to reduce the window from i index as long as count=0
    minLen = Math.min( minLen ,  j - i +1 ) //Get the result from calculations
                if( map.contains( str[i] ))
                    map.put( str[i], map.get( str[i] )++ )
                    if( map.get( str[i] ) == 1 )
                        count++
                i++
            j++
        else if count > 0
            j++
    return minLen
 */
import java.util.Map;
import java.util.HashMap;
public class E_MinimumWindowSubString {
    public static void main(String[] args) {
        String text = "timetopractise";
        String pattern = "toct";
        int minLength = minimumWindowSubString(text, pattern);
        System.out.println(minLength);
    }

    public static int minimumWindowSubString(String text, String pattern){
        int minLen=Integer.MAX_VALUE, i=0, j=0;
        Map<Character, Integer> patternMap = new HashMap<>();
        for(char c: pattern.toCharArray()){
            if(patternMap.containsKey(c)){
                patternMap.put(c, patternMap.get(c)+1);
            } else {
                patternMap.put(c, 1);
            }
        }
        int patternCharCount = patternMap.size();

        while(j<text.length()){
            //do the operations
            if(patternMap.containsKey(text.charAt(j))){
                patternMap.put(text.charAt(j), patternMap.get(text.charAt(j))-1);
                if(patternMap.get(text.charAt(j))==0){
                    patternCharCount--;
                }
            }
            //Condition is met
            if(patternCharCount == 0){
                while(patternCharCount == 0){
                    //Get the result
                    minLen = Math.min(minLen, j-i+1);
                    //Slide the window
                    if(patternMap.containsKey(text.charAt(i))){
                        patternMap.put(text.charAt(i), patternMap.get(text.charAt(i))+1);
                        if(patternMap.get(text.charAt(i)) == 1){
                            patternCharCount++;
                        }
                    }
                    i++;
                }
                j++;
            }
            //window/condition not yet reached
            else if(patternCharCount > 0){
                j++;
            }
        }

        return minLen;
    }
}
