import java.util.* ;
import java.io.*; 
public class Solution {
    public static int f(int i, int j, int [][]grid, int dp[][]){
        if(i==0 && j ==0 ) return grid[i][j];
        if(i <0 || j <0) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int top = grid[i][j] + f(i-1, j, grid, dp);
        int left = grid[i][j] + f(i, j-1, grid, dp);
        return dp[i][j]= Math.min(top, left);
    }
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        // int dp[][]= new int[grid.length][grid[0].length];
        // for(int i = 0 ; i < grid.length; i++ ){
        //     for(int j = 0; j < grid[0].length; j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return f(grid.length-1,grid[0].length-1, grid, dp);
        
        // for(int i= 0; i < grid.length; i++){
        //     for(int j = 0 ; j < grid[0].length; j++){
        //         if(i==0 && j ==0 ) dp[i][j] = grid[i][j];
        //         else{
        //             int up = grid[i][j];
        //             if(i>0) up+=dp[i-1][j];
        //             else up+=1e9;
        //             int left = grid[i][j];
        //             if(j>0) left+=dp[i][j-1];
        //             else left+=1e9;
        //             dp[i][j] = Math.min(up,left);
        //         }
        //     }
        // }
        // return dp[grid.length-1][grid[0].length-1];

        int prev [] = new int[grid[0].length];
        for(int i = 0 ; i < grid.length; i++){
            int cur [] = new int[grid[0].length];
            for(int j = 0 ; j < grid[0].length; j++){
                if(i==0 && j ==0 ) cur[j] = grid[i][j];
                else{
                    int up = grid[i][j];
                    if(i>0) up += prev[j];
                    else up+=1e9;
                    int left = grid[i][j];
                    if(j>0) left+=cur[j-1];
                    else left+=1e9;
                    cur[j] = Math.min(up,left);
                }
                for(int k =0 ; k < grid[0].length; k++) prev[k] = cur[k];
            }
        }
            return prev[grid[0].length-1];
    }
}
