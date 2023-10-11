/*
    Given a n*m sized floor, find different ways of placing 1*m matrix on the floor.
    Logic:
        if 1*m tile is placed vertically then call recursively to place on n-m and m space left over
        if 1*m tile is placed horizontally then call recursively to place on n-1 and m space left over
        Base case:
            if n=m there are two ways place all horizontally or place all vertically
            if n<m then it can only be placed horizontally
*/
public class R_PlaceTiles {
    public static void main(String[] args) {
        int n=4, m=2;
        int totalWays = placeTiles(n, m);
        System.out.println(totalWays);
    }

    public static int placeTiles(int n, int m){

        if(n == m){
            return 2;
        }

        if(n < m){
            return 1;
        }

        //Total vertical placements possible
        int verticalPlacements = placeTiles(n-m, m);

        //Total horizontal placements possible
        int horizontalPlacements = placeTiles(n-1, m);

        return verticalPlacements + horizontalPlacements;
    }
}