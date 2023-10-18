//https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
//https://www.prepbytes.com/blog/stacks/the-celebrity-problem/

import java.util.Stack;

public class B_FindTheCelebrity {
    
    //Approach 1: O(N)
    private void findCelebrity(int[][] M, int noOfPeople){
        
        //Assume celebrity is the first person
        int celebrity = 0;

        //check for all other members
        for(int i=1; i<noOfPeople; i++){
            //if celebirty knows someone else, then he is not celebrity, so someone else may be a celebrity so change celebrity to someone else.
            if( M[celebrity][i] == 1){
                celebrity = i;
            }
        }
        
        //We will have a potential celebrity after the above loop, to validate run another loop
        for(int i=0; i<noOfPeople; i++){
            //Validate that the above celebrity found should not know anyone AND and everyone else should know celebrity
            if(i != celebrity && (M[celebrity][i] == 1 || M[i][celebrity] == 0)){
                System.out.println("There is no celebrity");
            }
        }

        System.out.println("Celebrity is " + celebrity);

    }

    private int findCelebrity2(int[][] M, int noOfPeople){
        //Approach2: O(N^2)
        //Maintain two arrays IN and OUT.
        //IN array will maintain count of incoming connections
        //Out array will maintain couint of all outgoing connections
        //For a celebrity count of incoming connection = N-1 and count of outgoing connections = 0

        int[] in = new int[noOfPeople];
        int[] out = new int[noOfPeople];

        for(int i=0; i < noOfPeople; i++){
            for(int j=0; j<noOfPeople; j++){
                if(M[i][j]  == 1){ //i knows j
                    in[j] = in[j]+1; //j++
                    out[i] = out[i] + 1; //i++
                }
            }
        }

        for(int i=0; i<noOfPeople; i++){
            if(in[i] == noOfPeople-1 && out[i] == 0) //celebrity condition
                return i;
        }

        return -1; //no celebrity   
    }

    //Approach3: O(N) using stack
    //Push all the elements at the party 0 to N into the stack.
    //Pop two elements at a time for col and row value
    //if matrix[row][col] == 1 push back col as it may or may not be celeb. But row cannot be celeb because it knows another person.
    //When there is only 1 element left in stack we need to validate
    //Run a loop to check that all values in the row for the celeb is 0 i.e they dont know anyone
    //Run a loop to check that all values in the col for the celeb is 1 i.e everyone know the celeb.
    private int findCelebrity3(int[][] M, int noOfPeople){
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<M.length; i++){
            stack.push(i);
        }

        while(stack.size() > 1){
            int col = stack.pop();
            int row = stack.pop();
            if(M[row][col] == 1){
                stack.push(col);
            } else {
                stack.push(row);
            }
        }

        //one element left in stack , which COULD be a celeb, validate below
        int celeb = stack.pop();

        for(int i=0; i<noOfPeople; i++){
            if(i == celeb) continue;
            if(M[celeb][i] == 1) //celeb should not know anyone
                return -1;
        }

        for(int j=0; j<noOfPeople; j++){
            if(M[j][celeb] == 0) //everyone should know celeb
                return -1;
        }

        return celeb;
        
    }

}
