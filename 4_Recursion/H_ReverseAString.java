/*
    Print reverse of a string
    Pass the string and its last index
    Base case 
        if idx is 0 print the element and then return
    Else 
        print element at index
        Recursive call with idx-1
*/
public class H_ReverseAString {
    public static void main(String[] args) {
        String str = "abcd";
        printReverse(str, str.length()-1);
    }

    public static void printReverse(String str, int idx){
        if(idx == 0){
            System.out.print(str.charAt(idx));
            return;
        }

        System.out.print(str.charAt(idx));
        printReverse(str, idx-1);
    }
}
