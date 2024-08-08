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
        queue.add(this.root);
        var i = 0;
        var isEnd = false;
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
                        queue.add(child);
                        if (isLastIndex && child.isEnd) {
                            isEnd = true;
                            break;
                        }
                    }
                } else {
                    for (var n : pop.children) {
                        if (n == null) {
                            continue;
                        }
                        if (isLastIndex && n.isEnd) {
                            isEnd = true;
                            break;
                        }
                        queue.add(n);
                    }
                }
            }
            i++;
        }
        return isEnd;
    }
}
