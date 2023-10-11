/*
    Print all subsets of a set of first n natural numbers
    Logic:
    if n = 3, subsets are 1,2,3 and 1,2 and 1,3 and 2,3 and 1 and 2 and 3 and empty
    Every element has a choice to be part of the subset or not
*/

import java.util.ArrayList;

public class T_PrintSubsets {
    public static void main(String[] args) {
        int n = 3;
        ArrayList<Integer> subset = new ArrayList<>();
        findSubsets(n, subset);
    }

    public static void findSubsets(int n, ArrayList<Integer> subset){

        if(n == 0){
            //print subset
            for(int i=0; i< subset.size(); i++){
                System.out.print(subset.get(i) + " ");
            }
            System.out.println();
            return;
        }

        //if element should be in subset
        subset.add(n);
        findSubsets(n-1, subset);

        //if element should not be in subset
        subset.remove(subset.size()-1);
        findSubsets(n-1, subset);
    }

}
