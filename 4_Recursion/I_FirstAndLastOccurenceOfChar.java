/*
    Find the first and last occurrence of a character in a given string
    Pass the string, 0th index and the character to search.
    Base Case - If idx is str.length
        print the first and last index and return
    Else
        if current character at given idx is same as the character to search
            If first is not set till now then set both first and last idx
            else set last idx
        Recursive call with str, idx+1 and char to search
*/
public class I_FirstAndLastOccurenceOfChar {
    
    public static int first = -1;
    public static int last = -1;
    
    public static void main(String[] args) {
        String str = "abaacdaefaah";
        findOccurrence(str, 0, 'a');
    }

    public static void findOccurrence(String str, int idx, char element){
        if(idx == str.length()){
            System.out.println("First occurrence is at " + first);
            System.out.println("Last occurrence is at " + last);
            return;
        }

        if(str.charAt(idx) == element){
            if(first == -1){
                first = idx;
                last = idx;
            } else{
                last = idx;
            }
        }

        findOccurrence(str, idx+1, element);

    }
}
