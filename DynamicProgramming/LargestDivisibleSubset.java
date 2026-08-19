class Solution {
    public boolean isLexoGraphical(int i,int j,int[] arr,int[] hash){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        while(i!=hash[i]){
            a.add(arr[i]);
            i = hash[i];
        }
        a.add(arr[i]);
        while(j!=hash[j]){
            b.add(arr[j]);
            j = hash[j];
        }
        b.add(arr[j]);
        Collections.reverse(a);
        Collections.reverse(b);
        for(int k=0;k<a.size();k++){
            if(!a.get(k).equals(b.get(k))){
                return a.get(k)>b.get(k);
            }
        }
        return false;
    }
    public ArrayList<Integer> largestSubset(int[] arr) {
        // code here
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            hash[i] = i;
        }
        int maxi = 1;
        int k = 0;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            for(int prevIdx = 0;prevIdx<i;prevIdx++){
                if(arr[i]%arr[prevIdx]==0){
                    if(dp[prevIdx]+1>dp[i]){
                        dp[i] = dp[prevIdx]+1;
                        hash[i] = prevIdx;
                    }
                    else if(dp[prevIdx]+1==dp[i]){
                        if(isLexoGraphical(prevIdx,hash[i],arr,hash)){
                            hash[i] = prevIdx;
                        }
                    }
                }
            }
            if(dp[i]>maxi){
                maxi = dp[i];
                k = i;
                }
            else if(dp[i]==maxi){
                if(isLexoGraphical(i,k,arr,hash)){
                    k = i;
                }
            }
        }
        ArrayList<Integer> li = new ArrayList<>();
        li.add(arr[k]);
        while(hash[k]!=k){
            li.add(arr[hash[k]]);
            k = hash[k];
        }
        Collections.reverse(li);
        return li;
    }
}

//It is required to return besed on lexographical order 
//TC : O(N^2) nearly because of Lexographical function is there 
//SC : O(N)+O(N)+O(Largest Divisable subset) 
