/*
Problem
--------
Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.

Logic: 
------
Maintain a Map containing all counts of characters from the pattern.
Maintain a unique character count.
Find a window until all characters are found.
while creating the above window keep decrementing the count from the pattern map.
There can be possibility where count in pattern map becomes negative when there are repeating characters from the pattern in the original string.
Loop through the text to find a window
for every character check if it is in pattern map then decrement count.
if the count 0 there is one less unique character to be found.
if the count is becoming negative do not reduce the unique character count as this will be a repeating character in the window.
once the unique char count is 0 then find window size this is the substring.
keep reducing the window until unique char count is 0.
during reduction increment the count in map and only increment unique char count if the count in map is becoming from 0 to 1 and not from -ve to lesser negative. As this means there are still duplicate characters available in the window.

Pseudo Code:
------------
Add all characters and count to a Map
uniqueCharCount = 0
Loop till end of text
    if windowEnd character is in map
        decrementCount in map
    if decremented count is 0
        uniqueCharCount--
    while uniqueCharCount == 0
        if windowEnd - windowStart + 1 < minLength
            result = characters from windowStart till windowEnd
        if windowStart character is in map
            increment count
            if incrementedcount is 1
                uniqueCharCount++
        windowStart++
    
    windowEnd++
*/

import java.util.*;

public class J_SmallestSubstringContainingPattern {
    public static void main(String args[]){
        //String text = "aabdec";
        //String text = "abdabca";
        String text = "adcad";
        String pattern = "abc";
        
        Map<Character, Integer> patternMap = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char currentChar = pattern.charAt(i);
            patternMap.put(currentChar, patternMap.getOrDefault(currentChar,0)+1);
        }
        
        String result = findSmallestSubstring(text, pattern, patternMap);
        System.out.println(result);
    }
    
    private static String findSmallestSubstring(String text, String pattern, Map<Character, Integer> patternMap){
        
        /*for(Character c: patternMap.keySet()){
            System.out.println(c + " " + patternMap.get(c));
        }*/
        
        String smallestSubString = "";
        int windowStart = 0, windowEnd = 0, uniqueCharCount = patternMap.size(), minLength = Integer.MAX_VALUE;
        
        while (windowEnd < text.length()){
            //do calculations
            char currentChar = text.charAt(windowEnd);
            if(patternMap.containsKey(currentChar)){
                patternMap.put(currentChar, patternMap.get(currentChar)-1);
                if(patternMap.get(currentChar) == 0){
                    uniqueCharCount--;
                }
            }
            
            while(uniqueCharCount == 0){
                if(windowEnd-windowStart+1 < minLength){
                    minLength = windowEnd - windowStart + 1;
                    smallestSubString = text.substring(windowStart, windowEnd+1);
                }
                if(patternMap.containsKey(text.charAt(windowStart))){
                    int count = patternMap.get(text.charAt(windowStart));
                    if(count == 0){
                        uniqueCharCount++;   
                    }
                    patternMap.put(text.charAt(windowStart), count+1);
                }
                windowStart++;
            }
            windowEnd++;
        }
        
        return smallestSubString;
        
        
    }
}