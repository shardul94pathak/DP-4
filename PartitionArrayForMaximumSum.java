// Time Complexity : O(n*k)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
      if(arr == null || arr.length==0)
      {
        return 0;
      }
      
      int dp[] =  new int[arr.length];
      
      for(int i=0;i<dp.length;i++)
      {
        int max = Integer.MIN_VALUE;
        for(int j=1;j<=k && (i-j+1) >= 0;j++)
        {
          max = Math.max(max,arr[i-j+1]);
          
          if(i>=j)
          {
            dp[i] = Math.max(dp[i],max * j + dp[i-j]);
          }
          else
          {
            dp[i] = Math.max(dp[i],max * j);
          }
        }
      }
      return dp[dp.length-1];
    }
}