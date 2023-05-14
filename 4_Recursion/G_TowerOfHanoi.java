/*
Given n disks move from Source stack To Destination stack using 1 Helper stack
Only a smaller disk can be placed on top of a larger disk
Move only 1 disk at a time
Find the steps to move the disks from Source stack To Destination stack
Disks n=1 
    Move from source to destination
Disk n=2
    Move disk no. 2 from source to helper
    Move disk no. 1 from source to destination
    Move disk no. 2 from helper to destination
Disk n=3
    This problem can be split as
    Move 2 disks from source to helper using destination
    Move 1 disk from source to destination
For n disks
    Move n-1 disks from source to helper
    Move 1 disk from source to destination
*/
public class G_TowerOfHanoi {
    public static void main(String[] args) {
        int n=2;
        towerOfHanoi(n, "S", "H", "D");
    }

    public static void towerOfHanoi(int n, String source, String helper, String destination){
        if(n == 1){
            System.out.println("Move disk "+ n +" from " + source + " to " + destination);
            return;
        }
        
        //Move n-1 disks from source to helper using destination
        towerOfHanoi(n-1, source, destination, helper);

        System.out.println("Move disk "+ n +" from " + source + " to " + destination);

        //Move n-1 disks from helper to destination using source
        towerOfHanoi(n-1, helper, source, destination);

    }
}