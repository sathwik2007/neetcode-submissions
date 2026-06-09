class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(helper(prerequisites, i, visited, rec)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(int[][] prerequisites, int curr, boolean[] visited, boolean[] rec) {
        visited[curr] = true;
        rec[curr] = true;
        for(int[] edge : prerequisites) {
            if(edge[0] == curr) {
                if(rec[edge[1]]) {
                    return true;
                }
                else if(!visited[edge[1]]) {
                    if(helper(prerequisites, edge[1], visited, rec)) {
                        return true;
                    }
                }
            }
        }
        rec[curr] = false;
        return false;
    }
}
