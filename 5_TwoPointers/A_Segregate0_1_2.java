/*
Dutch National flag - Segregate all 0s, 1s and 2s in an array.
Use two pointer approach - push all 0s on left side and 2s on right side. So 1s will automatically come in middle.
Start with low and high pointing to 0 and n-1.
Use another pointer mid to navigate from 0 to n-1.
if the element is 0 swap mid and low pointer values and increment the low and mid pointer.
if the element is 1 increment the mid pointer, as we want to keep 1s in middle
if the element is 2 swap mid and high pointer values and decrement high pointer. We will not increment mid pointer because the element that comes from high pointer to mid pointer we do not know if it is in correct place.
*/
public class A_Segregate0_1_2 {
    public static void main(String[] args) {
        int arr[] = new int[] {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        dutchNationalFlag(arr);
    }
    public static void dutchNationalFlag(int[] arr){
        int low =0;
        int high = arr.length-1;
        int mid = 0;

        while(mid <= high){
            switch(arr[mid]){
                case 0: 
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1: 
                    mid++;
                    break;
                case 2: 
                    int t = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = t;
                    high--;
                    break;
            }
        }

        //Print the final array
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    
    }
}