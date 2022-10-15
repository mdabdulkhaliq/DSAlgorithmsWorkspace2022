import java.util.HashMap;
import java.util.Map;

/*
Problem Statement
------------------
    str : F O R X X O R F X A O F R
    pattern: F O R
    Anagram: No of characters and their quantity should be the same.
    Result: F O R X X O R F X A O F R

    str: a a b a a b a a
    pattern: a a b a
    No of patterns that can be generated for pattern are: 4 * 3 * 2 * 1 = 4! = 24
    All of these can be present in the string which are anagrams.

Identification
--------------
String is given
Pattern is given, and size of pattern will always be same, so we need to find a substring/pattern in the original string with window size k = 3, for first example

Explanation
-----------
str: a a b a a b a a
pattern: a a b a

Create a Map for pattern character count: a -> 3, b -> 1
Maintain a count for distinct character: map.size() = 2
While iterating through the characters in the string, if str[j] is present in the map, then decrement the value for that character in the map. 
If the value = 0 for that character then decrement the distinct char count by 1.
When the window size is reached, check if count = 0 then increment the noOfAnagrams by 1.
To slide the window, if the character at index i, str[i] is in map then increment its value by 1, if the new value is 1, then increment the distinct char count by 1. Then i++, j++

Pseudo Code
-----------
//Add all characters of the pattern with its count to a map
HashMap<Character, Integer> map;
for ( int i = 0; i < pattern.length; i++)
	if ( map.contains( pattern[i] ))
map.put( pattern[i], map.get(pattern[i])+1)
else
	map.put( pattern[i], 1)
count = map.size()
i = 0, j = 0, anagrams = 0
while ( j < size )
//do the calculations
if ( map.contains( str[j] ) )
	map.put( str[j] , map.get( str[j] ) - 1 )
if ( map.get( str[j] ) == 0 )
	count--
//Check if window size i.e length of pattern not reached yet
if ( j - i +1 < k )
	j++
//window size is reached
else if ( j - i + 1 == k )
	//Get the result from the calculations
if ( count == 0 )
		anagrams += 1
	//Remove i index calculations, add character at i index back to the map
	if ( map.contains( str[i] ) )
		map.put( str[i], map.get( str[i] ) + 1 )
	if ( map.get( str[i] ) == 1)
		count++
	//Slide the window
	i++, j++

 */

public class C_CountOccurencesOfAnagram {
    public static void main(String[] args) {
        //String text = "forxxorfxaofr";
        //String pattern="for";
        String text = "aabaabaa";
        String pattern = "aaba";
        
        Map<Character, Integer> patternMap = new HashMap<>();
        for(char c : pattern.toCharArray()){
            if(patternMap.containsKey(c)){
                patternMap.put(c, patternMap.get(c)+1);
            } else{
                patternMap.put(c, 1);
            }
        }
        int distinctCharCount = patternMap.size();
        int k = pattern.length();

        int totalNoOfAnagrams = countOccurencesOfAnagram(text, k, patternMap, distinctCharCount);
        System.out.println(totalNoOfAnagrams);

    }

    private static int countOccurencesOfAnagram(String text, int k, Map<Character, Integer> patternMap, int distinctCharCount) {
        int i=0, j=0, totalNoOfAnagrams = 0;
        while(j<text.length()){
            if(patternMap.containsKey(text.charAt(j))){
                patternMap.put(text.charAt(j), patternMap.get(text.charAt(j))-1);
                if(patternMap.get(text.charAt(j)) == 0){
                    distinctCharCount--;
                }
            }
            if(j-i+1 < k){
                j++;
            } else {
                if(distinctCharCount == 0){
                    totalNoOfAnagrams++;
                }
                if(patternMap.containsKey(text.charAt(i))){
                    patternMap.put(text.charAt(i), patternMap.get(text.charAt(i))+1);
                    if(patternMap.get(text.charAt(i)) == 1)
                        distinctCharCount++;
                }
                j++;
                i++;
            }
        }
        return totalNoOfAnagrams;
    }
}
