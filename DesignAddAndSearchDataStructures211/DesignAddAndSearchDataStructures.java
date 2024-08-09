package DesignAddAndSearchDataStructures211;

import java.util.ArrayDeque;

public class DesignAddAndSearchDataStructures {
    private class Node {
        public Node[] children;
        public boolean isEnd;

        public Node() {
            this.children = new Node[26];
        }
    }

    public Node root;

    public DesignAddAndSearchDataStructures() {
        this.root = new Node();
    }

    public void addWord(String word) {
        var current = this.root;
        var chars = word.toCharArray();
        for (var i = 0; i < chars.length; i++) {
            var ch = chars[i];
            var index = ch - 'a';
            var child = current.children[index];
            if (child == null) {
                current.children[index] = new Node();
            }
            var node = current.children[index];
            if (i == (chars.length - 1)) {
                node.isEnd = true;
            }
            current = node;
        }
    }

    public boolean search(String word) {
        var queue = new ArrayDeque<Node>();
        queue.offer(this.root);
        var i = 0;
        while (!queue.isEmpty()) {
            var isLastIndex = i == (word.length() - 1);
            if (i >= word.length()) {
                break;
            }
            var size = queue.size();
            var ch = word.charAt(i);
            for (var j = 0; j < size; j++) {
                var index = ch - 'a';
                var pop = queue.poll();
                if (ch != '.') {
                    var child = pop.children[index];
                    if (child != null) {
                        queue.offer(child);
                        if (isLastIndex && child.isEnd) {
                            return true;
                        }
                    }
                } else {
                    for (var n : pop.children) {
                        if (n == null) {
                            continue;
                        }
                        if (isLastIndex && n.isEnd) {
                            return true;
                        }
                        queue.offer(n);
                    }
                }
            }
            i++;
        }
        return false;
    }
}
