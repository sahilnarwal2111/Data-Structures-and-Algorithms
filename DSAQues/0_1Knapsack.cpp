#include <bits/stdc++.h> 
#include <climits>
int f(vector<int> weight, vector<int> value, int n, int maxWeight, int i, vector<vector<int>> &dp){
	// if(bag >  maxWeight){
	// 	return 0;
	// }
	if(i == 0){
		if(weight[i]<=maxWeight) return value[0];
		else return 0;
	}
	if(dp[i][maxWeight]!=-1) return dp[i][maxWeight];
	int notTake = f(weight, value, n, maxWeight, i-1,dp);
	int take = std::numeric_limits<int>::min();

	if(maxWeight>=weight[i]) take = value[i] + f(weight, value, n, maxWeight-weight[i],i-1,dp);
	return dp[i][maxWeight]= max(notTake, take);
}
int knapsack(vector<int> weight, vector<int> value, int n, int maxWeight) 
{
	// Write your code here
	// vector<vector<int>> dp(n, vector<int>(maxWeight+1, -1));
	// return f(weight, value, n, maxWeight, n-1,dp);
	//TABULATION:
	// vector<vector<int>> dp(n, vector<int>(maxWeight+1, 0));
	// for(int i = weight[0] ; i <=maxWeight ; i++) dp[0][i] = value[0];
	// for(int i = 1 ; i < n ; i++){
	// 	for(int wt = 0 ; wt <= maxWeight; wt++){
	// 		int notTake = dp[i-1][wt];
	// 		int take = std::numeric_limits<int>::min();

	// 		if(wt>=weight[i]) take = value[i] + dp[i-1][wt-weight[i]];
	// 		dp[i][wt] = max(take, notTake);
	// 	}
	// }
	// return dp[n-1][maxWeight];
	//SAPCE OPTIMIZED: two array
	// vector<int> prev(maxWeight+1, 0), cur(maxWeight+1, 0);
	// for(int i = weight[0] ; i <=maxWeight ; i++) prev[i] = value[0];
	// for(int i = 1 ; i < n ; i++){
	// 	for(int wt = 0 ; wt <= maxWeight; wt++){
	// 		int notTake = prev[wt];
	// 		int take = std::numeric_limits<int>::min();

	// 		if(wt>=weight[i]) take = value[i] + prev[wt-weight[i]];
	// 		cur[wt] = max(take, notTake);
	// 	}
	// 	prev = cur;
	// }
	// return prev[maxWeight];
	//SAPCE OPTIMIZED: one array
	vector<int> prev(maxWeight+1, 0);
	for(int i = weight[0] ; i <=maxWeight ; i++) prev[i] = value[0];
	for(int i = 1 ; i < n ; i++){
		for(int wt = maxWeight ; wt >= 0; wt--){
			int notTake = prev[wt];
			int take = std::numeric_limits<int>::min();
			if(wt>=weight[i]) take = value[i] + prev[wt-weight[i]];
			prev[wt] = max(take, notTake);
		}
		
	}
	return prev[maxWeight];


}
