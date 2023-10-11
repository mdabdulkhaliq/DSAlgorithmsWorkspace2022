/*
    Given a n*m/3*3 matrix count all possible paths from first cell 0,0 to last cell n-1,m-1
    The rule is we can only either go down or right
    Logic:
        n*m is size of matrix
        i,j are current cell indexes
        Total paths is sum of downpaths + right paths
        Find all downpaths by incrementing i value
        Find all rightpaths by incrementing j value
        Base case: 
            when i = n-1 and j=m-1 we found a path return 1
            when i = n (crossed last row) there is no more down path so return 0
            when j = m (crossed last column) there is no more right paths so return 0
*/
public class Q_CountMazePaths {
    public static void main(String[] args) {
        int n=3, m=3;
        int i=0, j=0;
        int totalPaths = countMazePaths(i, j, n, m);
        System.out.println(totalPaths);
    }

    public static int countMazePaths(int i, int j, int n, int m){

        //Reached last corner cell so found a path return 1
        if(i == n-1 && j == m-1){
            return 1;
        }

        //Corner cell, no more down path or no more right path return 0
        if(i == n || j == m){
            return 0;
        }

        //down paths
        int downPaths = countMazePaths(i+1, j, n, m);

        //right paths
        int rightPaths = countMazePaths(i, j+1, n, m);

        return downPaths + rightPaths;
    }
}
