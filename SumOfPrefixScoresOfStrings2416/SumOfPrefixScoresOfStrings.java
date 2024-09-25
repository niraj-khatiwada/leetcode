package SumOfPrefixScoresOfStrings2416;

public class SumOfPrefixScoresOfStrings {
    private class Node {
        public char value;
        public int count;
        public Node[] children;

        public Node(char value) {
            this.value = value;
            this.count = 1;
            this.children = new Node[26];
        }

        public Node() {
            this.count = 1;
            this.children = new Node[26];
        }
    }

    public Node root = new Node();

    public void add(String word) {
        var p = 0;
        var current = this.root;
        while (current != null && p < word.length()) {
            var ch = word.charAt(p);
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new Node(ch);
            } else {
                current.children[ch - 'a'].count++;
            }
            current = current.children[ch - 'a'];
            p++;
        }
    }

    public int traverse(String word) {
        var p = 0;
        var current = this.root;
        var score = 0;
        while (current != null && p < word.length()) {
            var ch = word.charAt(p);
            current = current.children[ch - 'a'];
            score += current.count;
            p++;
        }
        return score;
    }

    public int[] sumPrefixScores(String[] words) {
        for (var word : words) {
            this.add(word);
        }
        var rs = new int[words.length];
        for (var i = 0; i < words.length; i++) {
            rs[i] = this.traverse(words[i]);
        }
        return rs;
    }
}
