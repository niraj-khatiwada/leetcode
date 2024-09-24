package FindTheLengthOfTheLongestCommonPrefix3043;

public class FindTheLengthOfTheLongestCommonPrefix {
    private class Node {
        public int value;
        public Node[] children;

        public Node(int value) {
            this.value = value;
            this.children = new Node[10];
        }

        public Node() {
            this.children = new Node[10];
        }
    }

    private Node root = new Node();

    public void _add(int value) {
        var p = 0;
        var nstr = value + "";
        var current = root;
        while (current != null && p < nstr.length()) {
            var d = nstr.charAt(p) - 48;
            if (current.children[d] == null) {
                current.children[d] = new Node(d);
            }
            current = current.children[d];
            p++;
        }
    }

    public int _distance(int value) {
        var p = 0;
        var dist = 0;
        var nstr = value + "";
        var current = root;
        while (current != null && p < nstr.length()) {
            var d = nstr.charAt(p) - 48;
            if (current.children[d] == null) {
                break;
            }
            current = current.children[d];
            p++;
            dist++;
        }
        return dist;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for (var num : arr1) {
            this._add(num);
        }
        var max = 0;
        for (var num : arr2) {
            max = Math.max(max, this._distance(num));
        }
        return max;

    }
}