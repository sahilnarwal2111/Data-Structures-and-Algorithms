import java.util.* ;
import java.io.*; 
public class Solution {
    public static int util(int n, int heights[], int i, ArrayList<Integer> dp){
        if(i==0) return 0;
        if(dp.get(i)!=-1) return dp.get(i);
        int left = util(n, heights, i-1, dp)+Math.abs(heights[i]-heights[i-1]);
        int right = Integer.MAX_VALUE;
        if(i >=2){ 
            right = util(n, heights, i-2, dp)+Math.abs(heights[i]-heights[i-2]); 
        }
        dp.set(i, Math.min(left,right));
        return  Math.min(left, right);
    }
    public static int frogJump(int n, int heights[]) {
        // Write your code here..
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i = 0 ; i <=n ; i++) dp.add(-1);

        return util(n, heights, n-1, dp);
    }

}

--------------------
  import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        ArrayList<Integer> dp = new ArrayList<>(n+1);
        dp.add(0);
        // return util(n, heights, n-1, dp);
        for(int i = 1 ; i < n ; i++){
            int fs = dp.get(i-1) + Math.abs(heights[i]-heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1)
            ss = dp.get(i-2) + Math.abs(heights[i]-heights[i-2]);
            dp.add(Math.min(ss, fs));
        }
        return dp.get(n-1);
    }

}
--------------------
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int prev = 0;
        int prev2 = 0;
        for(int i = 1; i < n ; i++){
            int fs = prev + Math.abs(heights[i]-heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1) ss = prev2 + Math.abs(heights[i-2]-heights[i]);
            int curi = Math.min(fs,ss);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }

}
