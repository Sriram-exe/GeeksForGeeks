class Solution {
    public static int f(int i,int j,int isTrue,String s,int[][][] dp){
        if(i>j) return 0;
        if(i==j){
            if(isTrue==1){
                return s.charAt(i)=='T'?1:0;
            }
            else return s.charAt(i)=='F'?1:0;
        }
        if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];
        int ways = 0;
        for(int idx=i+1;idx<j;idx+=2){
            int lt = f(i,idx-1,1,s,dp);
            int lf = f(i,idx-1,0,s,dp);
            int rt = f(idx+1,j,1,s,dp);
            int rf = f(idx+1,j,0,s,dp);
            if(s.charAt(idx)=='&'){
                if(isTrue==1) ways = (ways+ (lt*rt));
                else ways = (ways+(lt*rf)+(lf*rt)+(lf*rf));
            }
            else if(s.charAt(idx)=='|'){
                if(isTrue==1) ways = (ways+(lf*rt)+(lt*rf)+(lt*rt));
                else ways = (ways+(lf*rf));
            }
            else{
                if(isTrue==1) ways = (ways+(lf*rt)+(lt*rf));
                else ways = (ways+(lt*rt)+(lf*rf));
            }
        }
        return dp[i][j][isTrue]=ways;
    }
    static int countWays(String s) {
        // code here
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return f(0,n-1,1,s,dp);
    }
}
/*I used nearly same matrix chain multiplication partiation i only added extra isTrue because for some times i need the count of false values in sub problems
at the end i need to find for the count of true values so i passed in f(0,n-1,1) */
/*TC : (N*N*2)*N nearly O(N^3) I applied memoization/
/*SC : O(N*N)+O(N)->Auxaliry Stack Space*/


class Solution {
    static int countWays(String str) {
        // code here
        int n = str.length();
        int[][][] dp = new int[n+1][n+1][2];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k] = 0;
                }
            }
        }
        for(int i=0;i<n;i+=2){
            if(str.charAt(i)=='T') dp[i][i][1] = 1;
            else dp[i][i][0] = 1;
        }
        for(int len = 3;len<=n;len+=2){
            for(int i=0;i+len-1<n;i++){
                int j = i+len-1;
                for(int b=0;b<=1;b++){
                    int ways = 0;
                    for(int k=i+1;k<=j;k+=2){
                        int lt = dp[i][k-1][1];
                        int lf = dp[i][k-1][0];
                        int rt = dp[k+1][j][1];
                        int rf = dp[k+1][j][0];
                        if(str.charAt(k)=='&'){
                            if(b==1) ways = ways + (lt*rt);
                            else ways = ways + (lt*rf)+(lf*rt)+(lf*rf);
                        }
                        else if(str.charAt(k)=='|'){
                            if(b==1) ways = ways+(lt*rf)+(lf*rt)+(lt*rt);
                            else ways = ways+ (lf*rf);
                        }
                        else{
                            if(b==1) ways = ways+(lf*rt)+(lt*rf);
                            else ways = ways+(lt*rt) + (lf*rf);
                        }
                    }
                    dp[i][j][b] = ways;
                }
            }
        }
        return dp[0][n-1][1];
    }
}
/*Achieved Tabulation code after a lot of efforts*/
/*TC : (N*N*2)*N nearly O(N^3) */
/*SC : O(N*N)*/







