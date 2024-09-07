package CourseScheduleII210;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] edges = new HashSet[numCourses];
        for (var i = 0; i < numCourses; i++) {
            edges[i] = new HashSet<Integer>();
        }
        for (var p : prerequisites) {
            edges[p[1]].add(p[0]);
        }
        var visited = new HashSet<Integer>();
        var stack = new Stack<Integer>();
        for (var i = 0; i < numCourses; i++) {
            var visiting = new HashSet<Integer>();
            if (!this._dfs(edges, i, visiting, visited, stack)) {
                return new int[0];
            }
        }
        var order = new int[numCourses];
        var p = 0;
        while (!stack.isEmpty()) {
            order[p] = stack.pop();
            p++;
        }
        return order;
    }

    public boolean _dfs(Set<Integer>[] edges, int i, Set<Integer> visiting, Set<Integer> visited,
            Stack<Integer> stack) {
        if (i >= edges.length || visited.contains(i)) {
            return true;
        }
        // Cycle
        if (visiting.contains(i)) {
            return false;
        }
        visiting.add(i);
        for (var edge : edges[i]) {
            if (!_dfs(edges, edge, visiting, visited, stack)) {
                return false;
            }
        }
        visited.add(i);
        stack.add(i);
        visiting.remove(i);
        return true;
    }
}
