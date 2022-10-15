import java.util.HashMap;
import java.util.Map;

/*
Problem Statement
-----------------
    Longest substring with K unique characters
    str: a a b a c b e b e b e
    k : 3
    Result: a a b a c has 3 unique characters and length is 5.
    c b e b e b e has 3 unique characters and length is 7.

Identification
--------------
    String is given
    Longest substring is asked
    condition is k = 3 unique characters
    Explanation
    Loop through the string and add its characters to a map one by one and increment its count. Check if the condition map.size() < k then keep adding characters. If map.size() == k then we have k unique characters gets its length. if map.size() > k, then as long as size > k remove elements from i index. While removing the element from i index, decrease its count in the map, and if count = 0 then remove the element from the map.

Explanation
-----------
Create a Map, to store characters and their count.
Total unique character count will be = size of keys in the map.
As we loop through the characters in the string, add the character to the map and increment its count, keep doing this until the size of the map is < K.
When the size of map is same as K, evaluate the length of the substring and find max value of substring and increment j to add another character.
If the size of the map crosses K, then we need to slide the window by removing one character from the start and decrease its count in map or remove char from map if its current value is 1. Then slide the window.

Pseudo Code
-----------
    maxLen = 0
    while j < size
        //do the calculations
        if map.contains( str[j] )
            map.put( str[j], map.get( str[j] )++ )
        else
            map.put( str[j], 1 )
        if map.size() < k // if map size is less than k characters we need more characters so increment j
            j++
        else if map.size() == k //when we have k unique characters
            maxLen = Math.max( maxLen, j - i + 1 ) //Get the result from the calculations
            j++
        else if map.size() > k //If we have more than k characters
            while map.size() > k //Remove elements from i index as long as we have more than k characters
                if map.contains ( str[i] )
                    map.put( str[i] , map.get( str[i] )--)
                if map.get( str[i] == 0 )
                    map.remove( str[i] )
                i++
            j++
    return maxLen
 */
public class B_LongestSubStrWithKUniqChars {
    public static void main(String[] args) {
        String text = "aabacbebebe";
        int k = 3; //condition - 3 unique chars
        int maxLength = longestSubStrWithKUniqChars(text, k);
        System.out.println(maxLength);
    }

    private static int longestSubStrWithKUniqChars(String text, int k) {
        int i=0, j=0, maxLen = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        while(j<text.length()){
            if(charMap.containsKey(text.charAt(j))){
                charMap.put(text.charAt(j), charMap.get(text.charAt(j))+1);
            } else {
                charMap.put(text.charAt(j), 1);
            }

            if(charMap.size() < k)
                j++;
            else if(charMap.size() == k) {
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            }
            else if(charMap.size() > k){
                while(charMap.size() > k){
                    if(charMap.containsKey(text.charAt(i))){
                        int count = charMap.get(text.charAt(i));
                        if(count == 1)
                            charMap.remove(text.charAt(i));
                        else
                            charMap.put(text.charAt(i), charMap.get(text.charAt(i))-1);
                    }
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }
}