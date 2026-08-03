class Solution {
    private int[] vis;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1 && i != j){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        vis = new int[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(vis[i]==0){
                dfs(i, graph);
                count++;
            } 
        }
        return count;
    }
    private void dfs(int node, ArrayList<Integer>[] graph){
        vis[node] = 1;
        for(int neighbor : graph[node]){
            if(vis[neighbor] == 0){
                dfs(neighbor, graph);
            }
        }
    }
}