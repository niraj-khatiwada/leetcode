package WordSearchII212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WordSearchII {
    private class Node {
        public char value;
        public boolean isEnd;
        public Node[] children;

        public Node() {
            this.isEnd = false;
            this.children = new Node[26];
        }

        public Node(char value) {
            this.value = value;
            this.isEnd = false;
            this.children = new Node[26];
        }
    }

    private class Trie {
        public Node root;

        public Trie() {
            this.root = new Node();
        }

        public void add(String word) {
            var i = 0;
            var current = this.root;
            while (i < word.length()) {
                var ch = word.charAt(i);
                var chi = ch - 'a';
                if (current.children[chi] == null) {
                    current.children[chi] = new Node(ch);
                }
                i++;
                current = current.children[chi];
            }
            current.isEnd = true;
        }

        public Node containsPrefix(String word) {
            var i = 0;
            var current = this.root;
            while (i < word.length()) {
                var ch = word.charAt(i);
                var chi = ch - 'a';
                if (current.children[chi] == null) {
                    return null;
                }
                i++;
                current = current.children[chi];
            }
            return current;
        }

        public void remove(String word) {
            this._remove(this.root, word, 0, null);
        }

        private void _remove(Node node, String word, int i, Node parent) {
            if (i > word.length()) {
                return;
            }

            System.out.printf("%s %s\n", i, node.value);

            if (i == word.length() && node.isEnd) {
                node.isEnd = false;
                return;
            }

            var ch = word.charAt(i);
            var chi = ch - 'a';
            var child = node.children[chi];

            System.out.printf("Child %s\n", child.value);

            _remove(child, word, i + 1, node);

            var hasChildren = false;
            for (var j = 0; j < 26; j++) {
                if (child.children[j] != null) {
                    hasChildren = true;
                    break;
                }
            }
            if (!hasChildren) {
                node.children[chi] = null;
            }

        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        var list = new ArrayList<String>();
        var trie = new Trie();
        var map = new HashMap<String, Boolean>(); // word -> found
        for (var w : words) {
            trie.add(w);
            map.put(w, false);
        }
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                var visited = new TreeSet<int[]>((a, b) -> Arrays.compare(a, b));
                this._dfs(board, trie, i, j, "", list, map, visited);
                if (list.size() == words.length) {
                    break;
                }
            }
        }
        return list;
    }

    private void _dfs(char[][] board, Trie trie, int x, int y, String path, List<String> result,
            Map<String, Boolean> map, Set<int[]> visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited.contains(new int[] { x, y })) {
            return;
        }

        path += board[x][y];
        var node = trie.containsPrefix(path);
        if (node == null) {
            return;
        }

        if (node.isEnd && !map.get(path)) {
            result.add(path);
            map.put(path, true);
            trie.remove(path);
        }

        var coord = new int[] { x, y };
        visited.add(coord);

        var dx = new int[] { -1, 0, 1, 0 };
        var dy = new int[] { 0, 1, 0, -1 };

        for (var j = 0; j < 4; j++) {
            _dfs(board, trie, x + dx[j], y + dy[j], path, result, map, visited);
        }

        visited.remove(coord);
    }
}
