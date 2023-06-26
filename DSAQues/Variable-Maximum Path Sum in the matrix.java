import java.util.* ;
import java.io.*; 
public class Solution {
	public static int f(int i, int j, int [][] matrix){
		if(i<0 || j <0|| j >=matrix.length) return Integer.MIN_VALUE;
		if(i == 0 && j>=0 && j < matrix[0].length) return -10001;
		int s1 = matrix[i][j] + f(i-1, j, matrix);
		int s2 = matrix[i][j] + f(i-1, j-1, matrix);
		int s3 = matrix[i][j] + f(i-1, j+1, matrix);
		return Math.max(s1, Math.max(s2,s3));
	}
	public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
		// int max = Integer.MIN_VALUE;
		// for(int k = 0 ; k < matrix[0].length; k++){
		// 	max = Math.max(max, f(matrix.length-1, k, matrix));
		// }
		// return max;
		int r = matrix.length;
		int c = matrix[0].length;
		// int dp[][] = new int[r][c];
		// for(int i = 0 ; i < c ; i++) dp[0][i] = matrix[0][i];

		// for(int i = 1; i < r; i++){
		// 	for(int j = 0; j < c; j++){
		// 		int up = matrix[i][j] + dp[i-1][j];
		// 		int ld = matrix[i][j];
		// 		if(j>0) ld += dp[i-1][j-1];
		// 		else ld += -1e7;
		// 		int rd = matrix[i][j];
		// 		if(j<c-1) rd +=dp[i-1][j+1];
		// 		else rd += -1e7;
		// 		dp[i][j] = Math.max(up, Math.max(ld,rd));
		// 	}
		// }
		// int max = Integer.MIN_VALUE;
		// for(int i = 0 ; i < c; i++){
		// 	max = Math.max(max, dp[r-1][i]);
		// }
		// return max;
		// Space Otimization:
		int prev [] = new int[c];
		for(int i = 0 ; i < r ; i++){
			int cur[] = new int[c];
			for(int j = 0; j < c ; j++){
				if(i == 0) cur[j] = matrix[i][j];
				else{
					int up = matrix[i][j] + prev[j];
					int ld = matrix[i][j];
					if(j>0) ld += prev[j-1];
					else ld += -1e7;
					int rd = matrix[i][j];
					if(j<c-1) rd +=prev[j+1];
					else rd += -1e7;
					cur[j] = Math.max(up, Math.max(ld,rd));
				}
			}
			for(int k = 0; k < c; k++) prev[k] = cur[k];
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < c; i++){
			max = Math.max(max, prev[i]);
		}
		return max;
	}
}
