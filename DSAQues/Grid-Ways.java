// TC - > O(2^m*n);
// SC- > O(Longest Path length)
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int f(int i, int j){
		if(i==0 && j ==0 ) return 1;
		if(i<0 || j <0) return 0;
		int up = f(i-1, j);
		int left = f(i, j-1);
		return up + left;
	}
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		return f(m-1, n-1);

	}
}

---------------------------------------------------------------------
  //Memoization
  //  with DP Array TC - > O(m*n) SC - > O(LongestPathLength) + O(m*n)
  import java.util.* ;
import java.io.*; 
public class Solution {
	public static int f(int i, int j, int dp[][]){
		if(i==0 && j ==0 ) return 1;
		if(i<0 || j <0) return 0;
		if(dp[i][j]!=-1) return dp[i][j];
		int up = f(i-1, j,dp);
		int left = f(i, j-1,dp);
		return dp[i][j]= up + left;
	}
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		int dp[][] = new int[m][n];
		for(int i = 0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				dp[i][j]=-1;
			}
		}

		return f(m-1, n-1,dp);

	}
}
---------------------------------------------------------------------
// Tabulation

public static int uniquePaths(int m, int n) {
		int dp[][] = new int[m][n];
		dp[0][0]=1;
		for(int i = 0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				if(i==0 && j == 0) dp[i][j] =1;
				else{
					int up=0, left=0;
					if(i >0) up = dp[i-1][j];
					if(j>0) left = dp[i][j-1];
					dp[i][j] = up+left;
				}
			}
		}
		return dp[m-1][n-1];
	}

// most optimised approah TC - > O(m-1) or O(n-1) USING PERMUATATION AND COMBINATIONS
int N = m + n -2;
		int r = m-1;
		double res = 1;
		for(int i =1 ; i <= r ; i++){
			res = res * (N-r+i)/i;
		}
		return (int)res;


//-----------space otimisezd
int prev[] = new int [n];
		for(int i = 0 ; i < m ; i++){
			int cur[] = new int[n];
			for(int j = 0 ; j < n ; j++){
				if(i == 0 && j == 0) cur[j]=1;
				else{
					int up = 0, left =0;
					if(i>0) up = prev[j];
					if(j>0) left = cur[j-1];
					cur[j] = up + left;
				}
			}
			for(int k = 0 ; k < n ; k++){
				prev[k] = cur[k];
			}
		}
		return prev[n-1];
  
