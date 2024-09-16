/*Given a string and a list of words, find all the starting indices of substrings in the given string that are a concatenation of all the given words exactly once without any overlapping of words. It is given that all words are of the same length.

Input: String="catfoxcat", Words=["cat", "fox"]
Output: [0, 3]
Explanation: The two substring containing both the words are "catfox" & "foxcat".

Logic:
Calculate the below
length of string = string.length() = 9
number of words = words.length = 2
length of word = words[0].length() since the length of each word is the same. = 3

Maintain a frequencyMapOfWords containing the frequency of each word from the words list., cat = 1 and fox =1
Since all the words needs to be present once in the window, this is a fixed size window where windowlength is numberofwords * length of word = 6
window is from 0 till length of concatenated words array

For i=0 till LTEQ stringlength - numberofwords * lengthofword //leaving length of window at the end from the current index position, we can either increment i by 1 or by i + oneWordLength to avoid unnecessary checks 
    create a map of words seen and its count
    for j 0 till numberofwords //all these words needs to be present
        wordindex = i + j * wordlength //this will give starting indexes of each word
        fetch 1 word from the string
        check if the word is in the original freq map if not break move on to next index
        as the word is present in freq map, add word to seenMap and increment count.
        if the incremented count in seen map is > frequency map count for that word it means we have more occurrence of the word so break and proceed to next window
        if the incremented count in seen map is < frequency map it means there are more words to come.
        if we have come till end of the words it means that j is at the last word index, so if j+1 = wordsLength it means it has found all words.
        then add that i to result and proceed with next window.
        
*/        

import java.util.*;
public class E_ConcatenateWords {
    public static void main(String args[]){
        String text = "catfoxcat";
        String[] words = new String[]{"cat", "fox"};
        
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String s: words){
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }
        
        List<Integer> result = concatenateWords(text, words, frequencyMap);
        
        System.out.println(result.toString());
    }
    
    private static List<Integer> concatenateWords(String text, String[] words, Map<String, Integer> frequencyMap){
        List<Integer> result = new ArrayList<>();
        
        int textLength = text.length();
        int wordsLength = words.length;
        int oneWordLength = words[0].length();
        
        for(int i=0; i<=textLength - wordsLength * oneWordLength; i=i+oneWordLength){
            Map<String, Integer> seenMap = new HashMap<>();
            
            for(int j=0; j<wordsLength;j++){
                int nextWordIndex = i + j * oneWordLength;
                String nextWord = text.substring(nextWordIndex, nextWordIndex + oneWordLength);
                
                if(!frequencyMap.containsKey(nextWord)){
                    break;
                }
                
                seenMap.put(nextWord, seenMap.getOrDefault(nextWord, 0) + 1);
                
                if(seenMap.get(nextWord) > frequencyMap.getOrDefault(nextWord,0)){
                    break;
                }
                
                if(j + 1 == wordsLength){
                    result.add(i);
                }

            }
        }
        return result;
    }
}