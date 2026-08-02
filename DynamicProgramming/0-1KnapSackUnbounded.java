class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[] dp = new int[capacity+1];
        for(int i=0;i<=capacity;i++){
            int div = (int)i/wt[0];
            dp[i] = val[0]*div;
        }
        for(int idx=1;idx<n;idx++){
            for(int bw = 0;bw<=capacity;bw++){
                int notPick = dp[bw];
                int Pick = 0;
                if(bw>=wt[idx]){
                    Pick = val[idx] + dp[bw-wt[idx]];
                }
                dp[bw] = Math.max(Pick,notPick);
            }
        }
        return dp[capacity];
    }
}
// i optimized it to one row because it dp arrray required prev row same index element and present row calculated previous value 
//TC : O(N*Target)
//SC : O(Target)
