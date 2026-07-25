class Solution {
    public int minDifference(int arr[]) {
        // code here
        int sum = 0;
        
        int n = arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        boolean[][] dp = new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;
        for(int i=1;i<n;i++){
            for(int t=1;t<=sum;t++){
                boolean notTake = dp[i-1][t];
                boolean take = false;
                if(arr[i]<=t){
                    take = dp[i-1][t-arr[i]];
                }
                dp[i][t] = take||notTake;
            }
        }
        int diff=0;
        for(int i=sum/2;i>=0;i--){
            if(dp[n-1][i]){
                diff = Math.abs(i-(sum-i));
                break;
            }
        }
        return diff;
    }
}

/*This is an equalent subset sum problem*/
/*I done this using i creted a sum that stores total array elements sum and i created a dp array dp[n][sum+1] i know dp[n-1][j] represents till the last index the
the target j is achieved or not ,after i created the dp array i am finding if sum/2 is possible or not it is possible i know there are 2 subsets with equal sum
so i used a loop and find the minimum difference from the dp array */
//TC : O(N*SUM)-> to make dp + O(2N)-> to find sum and init every element 0 target with true + O(SUM/2) to find difference 
//SC : O(N*SUM)


