-----------------------------------------   TC- > O(n) SC-> O(n)+ recursion stack
#include <bits/stdc++.h> 
int f(int i , vector<int> &nums, vector<int>&dp){
    if(i == 0) return nums[i];
    if(i<0) return 0;
    if(dp[i]!=-1) return dp[i];
    int pick = nums[i] + f(i-2,nums,dp);
    int notPick = 0 + f(i-1, nums,dp);
    return dp[i]= max(pick, notPick);

}
int maximumNonAdjacentSum(vector<int> &nums){
    // Write your code here.
    vector<int> dp (nums.size(), -1);
    return f(nums.size()-1, nums,dp);
}

-------------Tabulation--------------------  TC- > O(n) SC-> O(n)
  int maximumNonAdjacentSum(vector<int> &nums){
    // Write your code here.
    vector<int> dp (nums.size(), -1);
    //Tabulation
    dp[0] = nums[0];
    int neg = 0;
    for(int i = 1; i < nums.size(); i++){
        int pick = nums[i];
        if(i-2>=0) pick += dp[i-2];
        int notPick = dp[i-1];
        dp[i] = max(pick, notPick);
    }
    return dp[nums.size()-1];
------------Space Optimization--------------- TC- > O(n) SC-> O(1)
  int prev = nums[0];
    int prev2 = 0;
    for(int i = 1 ; i < nums.size(); i++){
        int pick = nums[i] + prev2;
        int notPick = prev;
        int curi = max(pick, notPick);
        prev2 = prev;
        prev = curi;
    }
    return prev;
