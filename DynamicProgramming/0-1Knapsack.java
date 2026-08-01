class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[] prev = new int[W+1];
        for(int i=wt[0];i<=W;i++){
            prev[i] = val[0];
        }
        for(int idx = 1;idx<n;idx++){
            for(int bw = W;bw>=0;bw--){
                int pick = 0;
                if(wt[idx]<=bw){
                    pick = prev[bw-wt[idx]]+val[idx];
                }
                int notPick = prev[bw];
                prev[bw] = Math.max(pick,notPick);
            }
        }
        return prev[W];
    }
}
/* First i wrote recurrence and then i converted it to tabulatoin and then i made it to two row optimization there i found an pattern when i going from
left to right when i calculating the 'bw' i am calculating (prev row same index element) and (prev row [bw-wt[idx]] index element i got an idea if i calcualte it 
from right to left i not need two rows so i wrote inner for loop bw = W->0 and calculate for one row */
//TC = O(N*W)
//SC = O(W)
