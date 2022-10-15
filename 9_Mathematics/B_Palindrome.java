/*
Find if a given number is palindrome
Logic:
    copy the number to temp, as we need num to compare with the reverse value to see if it is same.
    while temp > 0, get the last digit/remainder by %
    reverse is created with formula rev = rev * 10 + last digit/remainder
    remove the last digit from temp by dividing by 10.
*/
public class B_Palindrome {
    public static void main(String[] args) {
        int num = 121211;
        isPalindrome(num);
    }
    public static void isPalindrome(int num){
        int temp = num;
        int reverse = 0;
        while (temp > 0){
            int remainder = temp % 10;
            reverse = reverse * 10 + remainder;
            temp = temp/10;
        }
        if(reverse == num){
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("It is not a Palindrome");
        }
    }
}