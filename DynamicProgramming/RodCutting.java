class Solution {
    public int cutRod(int[] price) {
        // code here
        int rodLength = price.length;
        int[] row = new int[rodLength+1];
        for(int i=0;i<=rodLength;i++){
            row[i] = i*price[0];
        }
        for(int idx = 1;idx<rodLength;idx++){
            for(int rl = 0;rl<=rodLength;rl++){
                int notPick = row[rl];
                int pick = 0;
                if(rl>=(idx+1)){
                    pick = price[idx] + row[rl-(idx+1)];
                }
                row[rl] = Math.max(pick,notPick);
            }
        }
        return row[rodLength];
    }
}
//TC : O(N*N) -> N - length of the array 
//SC : O(N) 
