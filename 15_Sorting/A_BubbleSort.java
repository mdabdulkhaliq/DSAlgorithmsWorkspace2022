/*
    Bubble sort the largest element will be pushed to the last index after every iteration
    Logic:
        Loop1 runs from 1st element to 2nd last element (because the next loop will run till +1 element)
        Loop2 runs from 1st element to last element, every time eliminating the last element
*/
public class A_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {7, 8, 3, 1, 2};

        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }    
}
