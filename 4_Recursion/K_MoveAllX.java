/*
    Move all x from a string towards the end.
    Logic: Check every character in the string based on idx
    if the character is x add it to a count
    if character is not x add it to a new String
    Call the function recursively for next character  
    Base conditon idx is equal to string length (which is 1 more than last character) in which case just add the x for count time to the new string
*/
public class K_MoveAllX {
    
    public static int xCount = 0;
    public static StringBuilder newString = new StringBuilder();

    public static void main(String[] args) {
        String input = "axbxcxxd";
        moveAllX(input, 0);
        System.out.println(newString);
    }

    public static void moveAllX(String input, int idx){
        if(idx == input.length()){
            for(int i=0; i<xCount; i++){
                newString.append('x');
            }
            return;
        }
        if(input.charAt(idx) == 'x'){
            xCount++;
        } else {
            newString.append(input.charAt(idx));
        }
        moveAllX(input, idx+1);
    }
}