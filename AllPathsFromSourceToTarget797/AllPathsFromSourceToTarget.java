package AllPathsFromSourceToTarget797;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> rs = new ArrayList<>();
        this._dfs(graph, 0, new ArrayList<Integer>(), rs);
        return rs;
    }

    private void _dfs(int[][] edges, int i, List<Integer> path, List<List<Integer>> rs) {
        if (i == (edges.length - 1)) {
            var copy = new ArrayList<Integer>(path);
            copy.add(i);
            rs.add(copy);
            return;
        }
        path.add(i);
        for (var edge : edges[i]) {
            _dfs(edges, edge, path, rs);
        }
        path.remove(Integer.valueOf(i));
    }
}