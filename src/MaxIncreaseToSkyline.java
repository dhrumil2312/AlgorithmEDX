public class MaxIncreaseToSkyline {
    public static void main(String[] args) {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};

        int[] maxCol = new int[grid.length];
        int[] maxRow = new int[grid[0].length];

        int maxc= 0;
        int maxr = 0;

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid.length ; j++){
                maxr = Math.max(maxr,grid[i][j]);
                maxc = Math.max(maxc , grid[j][i]);
            }
            maxCol[i] = maxc;
            maxRow[i] = maxr;
            maxc = 0;
            maxr = 0;
        }

        int sum = 0;

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                sum += Math.min(maxRow[i] , maxCol[j])  - grid[i][j];
            }
        }

        System.out.println(sum);

    }
}
