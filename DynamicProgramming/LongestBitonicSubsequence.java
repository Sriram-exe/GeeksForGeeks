class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        // code here
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=n-1;i>=0;i--){
            for(int prevIdx=n-1;prevIdx>i;prevIdx--){
                if(nums[i]>nums[prevIdx]){
                    if(dp[prevIdx]+1>dp[i]){
                        dp[i] = dp[prevIdx]+1;
                    }
                }
            }
        }
        int[] dp2 = new int[n];
        int maxi = 0;
        Arrays.fill(dp2,1);
        for(int i=0;i<n;i++){
            for(int prevIdx=0;prevIdx<i;prevIdx++){
                if(nums[i]>nums[prevIdx]){
                    if(dp2[prevIdx]+1>dp2[i]){
                        dp2[i] = dp2[prevIdx]+1;
                    }
                }
            }
            if(dp[i]>1 && dp2[i]>1 && (dp[i]+dp2[i]-1)>maxi){
                maxi = dp[i]+dp2[i]-1;
            }
        }
        return maxi;
    }
}
//Asded no strictly increasing and decreasing is not considered as biotonic
//TC : O(N^2)+O(N^2) 
//SC : O(N+N)

