class Solution {
    
    public void setDirections(int adjList[][], int[][] prerequisites) {
        
        for (int i = 0; i < prerequisites.length; i++) {
            
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            adjList[u][v] = 1;
            
        }
    }
    
    
    public boolean detectCycle(int adjList[][], int u, boolean visited[], boolean processed[], List<Integer> al) {
        
        
        if (visited[u]) return true;
        
        if (processed[u]) return false;
        
        visited[u] = true;
        processed[u] = true;
        
        
        for (int v = 0; v < adjList[0].length; v++) {
            
            if (adjList[u][v] == 1) {
                
                if(detectCycle(adjList, v, visited, processed, al)) {
                    
                    return true;
                    
                }
                
            }
        }
        
        al.add(u);
        
        visited[u] = false;
        return false;
        
    }
    
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int adjList[][] = new int[numCourses][numCourses];
        
        setDirections(adjList, prerequisites);
        
        boolean visited[] = new boolean[numCourses];
        boolean processed[] = new boolean[numCourses];
        
        
        // do topological sorting - using post order traversal
        // if cycle is detected return -1, not possible
        
        List<Integer> al = new ArrayList<>();
    
        
        // graph can be disconnected
        
        for (int i = 0; i < numCourses; i++) {
            
            if (processed[i]) continue;
            
            // start from 0/ith vertex
            if(detectCycle(adjList, i, visited, processed, al)) {
                
                // if cycle detected return empty array
                return new int[]{};
                
            }
        }
    
        int A[] = new int[al.size()];
        
        for (int i = 0; i < al.size(); i++) {
            
            A[i] = al.get(i);
            
        }
        
        return A;

    }
}