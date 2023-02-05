// https://leetcode.com/problems/course-schedule/
class Solution {

    void setDirections(int adjList[][], int prerequisites[][]) {

        for (int i = 0; i < prerequisites.length; i++) {

            adjList[prerequisites[i][0]][prerequisites[i][1]] = 1;

        }

    }

    boolean detectCycle(int adjList[][], int u, boolean visited[], boolean processed[]) {

        if (visited[u])
            return true;

        if (processed[u])
            return false;

        // do
        visited[u] = true;

        processed[u] = true;

        // recur

        for (int v = 0; v < adjList[0].length; v++) {

            if (adjList[u][v] == 1) {

                if (detectCycle(adjList, v, visited, processed)) {

                    return true;

                }
            }
        }

        // undo
        visited[u] = false;

        return false;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int adjList[][] = new int[numCourses][numCourses];

        // directional graph
        setDirections(adjList, prerequisites);

        boolean visited[] = new boolean[numCourses];
        boolean processed[] = new boolean[numCourses];

        // start graph traversal from 0 node
        // graphs can be disconnected, so check for cycle from each vertex;

        for (int i = 0; i < adjList.length; i++) {

            if (processed[i])
                continue;

            if (detectCycle(adjList, i, visited, processed)) {

                return false;
            }
        }

        return true;
    }
}