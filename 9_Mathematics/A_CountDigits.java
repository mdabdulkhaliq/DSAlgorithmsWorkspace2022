/*
Count the digits in a given number
To count number should be greater than 0
Get the last digit by %
and increment count
Remove the last digit by dividing by 0.
*/
public class A_CountDigits {
    public static void main(String[] args) {
        int num = 12450;
        countDigits(num);
    }
    public static void countDigits(int num){
        int count = 0;
        while(num > 0){
            count++;
            num/=10;
        }
        System.out.println(count);
    }
}