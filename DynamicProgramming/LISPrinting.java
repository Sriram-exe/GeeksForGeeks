class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            hash[i] = i;
        }
        int maxi = 1;
        int k = 0;
        for(int i=0;i<n;i++){
            for(int prevIdx = 0; prevIdx<i;prevIdx++){
                if(arr[i]>arr[prevIdx]){
                    if(dp[prevIdx]+1>dp[i]){
                        dp[i] = dp[prevIdx]+1;
                        hash[i] = prevIdx;
                    }
                }
                if(dp[i]>maxi){
                    maxi = dp[i];
                    k = i;
                }
            }
        }
        ArrayList<Integer> li = new ArrayList<>();
        li.add(arr[k]);
        while(k!=hash[k]){
            li.add(arr[hash[k]]);
            k = hash[k];
        }
        Collections.reverse(li);
        return li;
    }
}
//Printing LIS by using a hash array by storing every previous LIS chain for evey longest LIS from left to right 
//TC : O(N*2) + O(LIS) -> to store Lis and a reverse function O(LIS) to reverse arraylist to get proper order
//SC : O(N) + O(N)  + O(LIS) -> for Longest increasing subsequence 
