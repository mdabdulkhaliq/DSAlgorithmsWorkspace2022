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
