/*
https://www.youtube.com/watch?v=SF2W6VDs7bc&t=166s&ab_channel=MichaelMuinos
Input: Decode a string: 2[a2[bc2[d]]]
Output: abcddbcddabcddbcdd
Logic:
    The input string can contain 4 different type of characters
        Digits
        Letters
        Open Bracket
        Closing Bracket
    We maintain 2 stacks - one is wordStack to save the string of characters to be repeated and the second one is countStack the number of times the word should be repeated.
    We also maintain 2 variables to read the number (since it can be more than 1 digit like 12 etc.) and a variable word to store the sequence of characters read.
    Start by reading from 0th index.
Iteration:
    Since it is character 2
        number = 2
        word = ""
    then move the next index
    If we encounter an opening brace
        add the current value of number to the count stack which is 2
        and add the current value of word to word stack which is ""
    Reset both variable number = 0 and word = "" once we add to stacks.
    Then we have character a , add it to word , word = a
    Then we have character 2, add it to number variable, number = 2
    Then we have opening brace
        add the current value of number to the count stack which is 2
        and add the current value of word to word stack which is a
    Reset both variable number = 0 and word = "" once we add to stacks.
    Then we have character b , add it to word variable , word = b
    Then we have character c, add it to word variable , word = bc
    Then we have number 2, add it to number variable, number = 2
    Then we have open brace
        add the current value of number to the count stack which is 2
        and add the current value of word to word stack which is bc
    Then we have character d, add it to word variable , word = d
    If we encounter a closing brace
        pop from word stack, which has value bc, popped value = bc
        pop from number stack which has value 2, popped number = 2
        Repeat the current value of word -> popped number times, which is d 2 times
        Now concatenate the poped word stack value with word which is bc + dd = bcdd and assign it back to word , word = bcdd
    Then we encounter a closing brace
        pop from word stack , which has value a, popped value = a
        pop from number stack which has a value 2, popped number = 2
        Repeat the current value of word -> popped number times, which is bcdd 2 times
        Now concatenate the poped word stack value with word which is a + bcddbcdd and assign it back to word, word = abcddbcdd
    Then we encounter a closing brace
        pop from word stack, which has value "", popped value = ""
        pop from number stack which has a value 2, popped number = 2
        Repeat the current value of word -> poped number times, which is abcddbcdd 2 times
        Now concatenate the poped word stack value with word which is "" + abcddbcddabcddbcdd and assign it back to word, word = abcddbcddabcddbcdd
    Once we navigate through the entire string, word will have the result.
*/
public class A_DecodeString {
    public static void main(String[] args) {
        
    }
}
