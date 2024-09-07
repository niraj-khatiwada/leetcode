package CourseSchedule207;

import java.util.HashSet;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] edges = new HashSet[numCourses];
        for (var i = 0; i < numCourses; i++) {
            edges[i] = new HashSet<Integer>();
        }
        for (var p : prerequisites) {
            edges[p[1]].add(p[0]);
        }
        var visited = new HashSet<Integer>();
        for (var i = 0; i < numCourses; i++) {
            var visiting = new HashSet<Integer>();
            if (!this._dfs(edges, i, visiting, visited)) {
                return false;
            }
            visited.addAll(visiting);
        }
        return true;
    }

    public boolean _dfs(Set<Integer>[] edges, int i, Set<Integer> visiting, Set<Integer> visited) {
        if (i >= edges.length || visited.contains(i)) {
            return true;
        }
        // Cycle
        if (visiting.contains(i)) {
            return false;
        }
        visiting.add(i);
        for (var edge : edges[i]) {
            if (!_dfs(edges, edge, visiting, visited)) {
                return false;
            }
        }
        visited.add(i);
        visiting.remove(i);
        return true;
    }
}
