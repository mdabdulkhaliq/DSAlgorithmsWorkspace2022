/*
Problem Statement
------------------
    Pick Toys
    Make the kid get the maximum no of toys but with the condition no. of unique toys is 2.
    str: a b a c c a b
    Result: a c c a = 4 toys.

Identification
--------------
    Given a series of toys.
    can pick continuous toys.
    Max 2 types of toys can be picked.

Explanation
-----------
same as longest substring with k unique chars.(below)
Create a Map, to store characters and their count.
Total unique character count will be = size of keys in the map.
As we loop through the characters in the string, add the character to the map and increment its count, keep doing this until the size of the map is < K.
When the size of map is same as K, evaluate the length of the substring and find max value of substring and increment j to add another character.
If the size of the map crosses K, then we need to slide the window by removing one character from the start and decrease its count in map or remove char from map if its current value is 1. Then slide the window.

Pseudo Code
-----------
    maxLen = 0, k = 2
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
import java.util.Map;
import java.util.HashMap;

public class D_PickToys {
    public static void main(String args[]){
        String toys = "abaccab";
        int maxToys = 2;
        int maxLength = pickMaxToys(toys, maxToys);
        System.out.println(maxLength);
    }

    public static int pickMaxToys(String toys, int maxToys){
        int i=0, j=0, maxLen=0;
        Map<Character, Integer> toysMap = new HashMap<>();
        while(j<toys.length()){
            //Operation for current jth character
            if(toysMap.containsKey(toys.charAt(j))){
                toysMap.put(toys.charAt(j), toysMap.get(toys.charAt(j))+1);
            } else {
                toysMap.put(toys.charAt(j), 1);
            }

            //Check if condition is not reached yet, just increment window.
            if(toysMap.size() < maxToys){
                j++;
            } else if(toysMap.size() == maxToys){
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            } else if(toysMap.size() > maxToys){
                while(toysMap.size() > maxToys){
                    if(toysMap.get(toys.charAt(i)) == 1){
                        toysMap.remove(toys.charAt(i));
                    } else {
                        toysMap.put(toys.charAt(i), toysMap.get(toys.charAt(i))-1);
                    }
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }
}
