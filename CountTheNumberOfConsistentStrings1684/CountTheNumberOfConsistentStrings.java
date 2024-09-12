package CountTheNumberOfConsistentStrings1684;

public class CountTheNumberOfConsistentStrings {
    // O(words.length * len(word(i)))
    public int countConsistentStrings(String allowed, String[] words) {
        var characters = new boolean[26];
        for (var ch : allowed.toCharArray()) {
            characters[ch - 'a'] = true;
        }
        var count = 0;
        for (var word : words) {
            var valid = true;
            for (var ch : word.toCharArray()) {
                if (!characters[ch - 'a']) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                count++;
            }
        }
        return count;
    }
}