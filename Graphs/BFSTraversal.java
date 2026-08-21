class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q = new LinkedList<>();
        int v = adj.size();
        boolean[] vis = new boolean[v];
        Arrays.fill(vis,false);
        ArrayList<Integer> li = new ArrayList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            li.add(node);
            for(int i=0;i<adj.get(node).size();i++){
                if(vis[i]==false){
                    vis[i] = true;
                    q.add(adj.get(node).get(i));
                }
            }
        }
        return li;
    }
}

//I used Queue and visited array to track level and check it is already visited or not
//TC : 2(E)
//SC : O(V) -> visited boolean array + O(V) -> nearly for Queue
