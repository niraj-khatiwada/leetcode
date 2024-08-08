package ImplementPrefixTrie208;

import java.util.HashMap;

public class Trie {
    private class Node {
        public HashMap<Character, Node> children;
        public boolean isEnd;

        public Node() {
            this.children = new HashMap<>();
        }
    }

    public Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        var current = this.root;
        var chars = word.toCharArray();
        for (var i = 0; i < chars.length; i++) {
            var ch = chars[i];
            var child = current.children.get(ch);
            if (child == null) {
                var node = new Node();
                current.children.put(ch, node);
            }
            var node = current.children.get(ch);
            if (i == (chars.length - 1)) {
                node.isEnd = true;
            }
            current = node;
        }
    }

    public boolean search(String word) {
        var current = this.root;
        for (var ch : word.toCharArray()) {
            var child = current.children.get(ch);
            if (child == null) {
                return false;
            }
            current = child;
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        var current = this.root;
        for (var ch : prefix.toCharArray()) {
            var child = current.children.get(ch);
            if (child == null) {
                return false;
            }
            current = child;
        }
        return true;
    }
}
