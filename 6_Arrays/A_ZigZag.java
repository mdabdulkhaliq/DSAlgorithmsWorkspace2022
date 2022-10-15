/*
Problem: Convert an array in to zig zag array
    Zig zag array is one in which an element is less than < the previous element and greater than > the next element or it is greater than the previous element and less than the next element.
    a b c d e f g...
    a < b > c
    b > c < d
Logic:
    since the elements should be less than and greater than alternatively, use a flag.
    flag = 0 -> ith element should be < i+1 element
    flag = 1 -> ith element should be > i+1 element
    if not swap i and i+1 element.
*/
public class A_ZigZag {
    public static void main(String[] args) {
        int arr[] = new int[] {3, 4, 6, 2, 1, 8, 9};
        zigZag(arr);
    }

    public static void zigZag(int[] arr){
        boolean flag = false;
        int i = 0;
        while(i<arr.length-1){
            if(flag && arr[i] < arr[i+1]){
                int t = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = t;
            } else if(!flag && arr[i] > arr[i+1]) { 
                int t = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = t;
            }
            flag = !flag;
            i++;
        }

        //Print the final array
        for(i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
