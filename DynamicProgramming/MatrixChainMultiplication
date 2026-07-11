class Solution {
    public static int f(int i,int j,int[] arr,int[][] dp){
        if(i==j) return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i;k<j;k++){
            int steps = arr[i-1]*arr[k]*arr[j]+f(i,k,arr,dp)+f(k+1,j,arr,dp);
            mini = Math.min(steps,mini);
        }
        return dp[i][j]=mini;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return f(1,n-1,arr,dp);
    }
}
/*TC = O(N^3) exponentional*/
/*SC = O(N^2) -> for dp + O(n) -> Auxaliry Stack Space*/
/*f(2,4) -> function defines minimum number of multiplication operations for index = 2 to 4 */
/*Memoization through n*n dp matrix */



class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i=1;i<n;i++){
            dp[i][i] = 0;
        }
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int mini = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int steps = arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                    mini = Math.min(steps,mini);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n-1];
    }
}
/*TC = nearly O(n^3)*/
/*SC = O(n^2)*/
/*By using the reccurnece i wrote an equalent tabulation code*/
