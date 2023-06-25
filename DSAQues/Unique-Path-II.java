import java.util.ArrayList;
// There is error somewhere don't know where
// Problem Link : https://www.codingninjas.com/codestudio/problems/maze-obstacles_977241?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
public class Solution {
     static int f(int i , int j,ArrayList<ArrayList<Integer>> mat, int dp[][] ){
        if(i == 0 && j == 0) return 1;
        if(i <0 || j < 0) return 0;
        if(mat.get(i).get(j)==-1 && i>=0 && j>=0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = f(i-1, j , mat, dp);
        int down = f(i, j-1, mat , dp);
        return dp[i][j] = up + down;
    }
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        // int dp[][] = new int [n][m];
        int dp[][] = new int[n][m];
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < m ; j++){
				dp[i][j]=-1;
			}
		}
        int mod = (int)(1e9+7);
		return f(n-1, m-1,mat,dp)%mod;

    }

}

/// Tabulation
int mod = (int)(1e9+7);
		// return f(n-1, m-1,mat,dp)%mod;
        int dp [][] = new int[n][m];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat.get(i).get(j)==-1) dp[i][j]=0;
                else if(i==0 && j ==0) dp[i][j] =1;
                else{
                    int up = 0, left = 0;
                    if(i >0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = (up + left)%mod;
                }
            }
        }
        return dp[n-1][m-1];

// Space Otimised
int [] prev = new int[m];
        for(int i =0 ; i < n ; i++){
            int cur [] = new int[m];
            for(int j = 0 ; j < m ; j++){
                if(mat.get(i).get(j)==-1) cur[j]=0;
                else if(i==0 && j ==0) cur[j] =1;
                else{
                    int up = 0, left = 0;
                    if(i >0) up = prev[j];
                    if(j>0) left = cur[j-1];
                    cur[j] = (up + left)%mod;
                }
            }
            for(int k = 0 ; k < m ; k++){
                prev[k] = cur[k];
            }
        }
        return prev[m-1];
