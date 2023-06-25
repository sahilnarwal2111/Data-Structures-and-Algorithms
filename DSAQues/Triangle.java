import java.util.* ;
import java.io.*; 
public class Solution {
    public static int f(int i, int j ,int triangle[][], int n, int dp[][]){
        if(i == n-1 ) return triangle[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int up = triangle[i][j] + f(i+1, j+1, triangle, n,dp);
        int left = triangle[i][j] + f(i+1, j, triangle, n,dp);
        return dp[i][j]=Math.min(up, left);
    }

    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int dp[][] = new int [n][n];
        // for(int i =0 ; i < n ; i++){
        //     for(int j = 0 ; j < n ; j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return f(0,0, triangle, n,dp);
        //TABULATION:
        // for(int j = 0 ; j <=n-1 ; j++){
        //     dp[n-1][j] = triangle[n-1][j];
        // }
        // for(int i = n-2; i>=0 ; i--){
        //     for(int j = i ; j >=0; j--){
        //         int down = triangle[i][j] + dp[i+1][j];
        //         int dd = triangle[i][j] + dp[i+1][j+1];
        //         dp[i][j] = Math.min(down, dd);
        //     }
        // }

        // return dp[0][0];
        int prev [] = new int[n];
        // int cur[]  = new int[n];
        
        for(int i = n-1 ; i >=0; i--){
            int cur [] = new int[n];
            for(int j =i ; j >=0; j--){
                if(i == n-1) cur[j] = triangle[i][j];
                else{
                    int up = triangle[i][j] + prev[j];
                    int left = triangle[i][j] + prev[j+1];
                    cur[j] = Math.min(up,left);
                }
            }
            for(int k =0; k <n ;k++){
                prev[k] = cur[k];
            }
        }
        return prev[0];
    }
}
