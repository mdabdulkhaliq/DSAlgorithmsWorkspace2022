/*
 * https://leetcode.com/problems/boats-to-save-people/
 * 
 */

import java.util.Arrays;

public class F_BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = new int[]{3,2,2,1};
        int limit = 3;
        int boats = numRescueBoats(people, limit);
        System.out.println(boats);
    }

    private static int numRescueBoats(int[] people, int limit) {
        //max persons on a boat = 2
        int boats = 0;

        //Sort the array to get the light and heavy weight persons at start and end
        Arrays.sort(people);

        int lightPointer = 0;
        int heavyPointer = people.length-1;

        //as long as we dont cross over light and heavy pointers
        while(lightPointer <= heavyPointer){
            //if the light person + heavy person is within limit put them on a boat
            if(people[lightPointer] + people[heavyPointer] <= limit){
                boats++;
                lightPointer++;
                heavyPointer--;
            } else { //just put heavy person on the boat
                boats++;
                heavyPointer--;
            }
        }

        return boats;
    }

}