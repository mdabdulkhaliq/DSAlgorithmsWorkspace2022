//https://youtu.be/St0Jf_VmG_g?si=jCqW8X4YEMwPzimw
/*Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
Example:
Input :   0 1 1 0
          1 1 1 1
          1 1 1 1
          1 1 0 0

Output :  1 1 1 1
          1 1 1 1
*/
//We know how to find MaximumAreaRectangle or MaximumAreaHistogram which is for 1D array. We need to convert 2D array into 1D array to solve this.
//Take the first row of the matrix as the heights array - and find the max area rectangle.
//From the 2nd row till the last row - keep adding to the heights array if it is 1 and make height 0 if value is 0 in matrix. This is because we cannot have a area of rectange for the row where value is 0 at the bottom. If we add then it will look like there is area to calculate which will be incorrect.
//So this will be converted to 1d array of heights for each row and then apply maximumarearectangle logic.
//height1 - 0 1 1 0
//height2 - 1 2 2 1
//height3 - 2 3 3 2
//height4 - 3 4 0 0

public class N_MaximumAreaBinaryMatrix {
    public static void main(String[] args) {
        int[][] M = {{0,1,1,0}, {1,1,1,1}, {1,1,1,1}, {1,1,0,0}};
        int result = maxArea(M, 4, 4);
        System.out.println(result);
    }

    public static int maxArea(int M[][], int n, int m) {
        //create a 1d heights array to solve like MaxAreaHistogram
        int[] heights = new int[m];
        
        //Create the first heights array for row0
        for(int j=0; j<m; j++){
            heights[j] = M[0][j];
        }

        //Calcuate the MaxAreaRectangle for row0
        int maxArea = M_MaximumAreaHistogram.largestRectangleArea(heights);

        //For all other rows update the heights array and apply MaxAreaRectangle logic, add if it is non zero and make height 0 if the value is 0
        for(int i=1; i<n;i++){
            for(int j=0; j<m; j++){
                if(M[i][j] == 0) {
                    heights[j] = 0;
                } else {
                    heights[j] = heights[j] + M[i][j];
                }
            }

            //Calcuate the MaxAreaRectangle for updated heights array for each row
            int area = M_MaximumAreaHistogram.largestRectangleArea(heights);

            //Calcuate the max area
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }  

}
