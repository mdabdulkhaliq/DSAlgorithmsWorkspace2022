/*
Problem: Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

Variable size window:
---------------------
    Given String
    Find longest substring.
    Condition: replace no more than k letters

Variable size window pattern
-----------------------------
while j < size
	//do the calculations
	if condition < k
		j++
	else if condition == k
		Get answer from the calculations
		j++
	else if condition > k
		while condition > k
			Remove calculations of i
			i++
		j++
    return answer

Explanation
-----------
Initialise all required variables
    windowStart, windowEnd, 
    HashMap to store all characters and count
    maxCharCount to maintain the count of character that repeated the most times in the window.
    maxSubArrayLength

Loop until windowEnd < arraylength
    //do calculations
    Add the currentChar at windowsStart to the HashMap
    maxCharCount = max (maxCharCount , map.get(currentChar)
    number of remaining chars that can be replaced (NRC) = windowEnd - windowStart + 1 - maxCharcount

    //check conditions & get result
    //we use an if instead of while because only 1 charcter gets added at a time in the loop, not like sum etc where we need to continuously loop
    if NRC > k 
        remove windowStart char from Map
        windowStart++
    
    maxSubArrayLength = max of (maxSubArraylength , windowEnd - windowStart + 1)
    windowEnd++

Return maxSubArrayLength

*/

import java.util.*;

public class LongestSubStringWithSameLettersAfterReplacement {
    public static void main(String args[]){
        String text = "aabccbb";
        int k = 2;
        int result = longestSubString(text, k);
        System.out.println(result);

    }
    
    private static int longestSubString(String text, int k){
    int windowStart = 0, windowEnd = 0, maxCharCount = 0, maxSubArrayLength = 0, remainingChars = 0;
    Map<Character, Integer> map = new HashMap<>();

    while(windowEnd < text.length()){
        //do calculations
        map.put(text.charAt(windowEnd), map.getOrDefault(text.charAt(windowEnd),0) + 1);
        maxCharCount = Math.max(maxCharCount, map.get(text.charAt(windowEnd)));
        remainingChars = windowEnd - windowStart + 1 - maxCharCount;
        
        //check condition
        if(remainingChars > k){
            map.put(text.charAt(windowStart), map.get(text.charAt(windowStart))-1);
            windowStart++;
        }
        
        //Get result
        maxSubArrayLength = Math.max(maxSubArrayLength, windowEnd - windowStart + 1);
        
        //increment window size
        windowEnd++;
    }
    
    return maxSubArrayLength;
    
}
}

