import java.util.*;
import DesignAddAndSearchDataStructures211.DesignAddAndSearchDataStructures;

public class Main {
    public static void main(String[] args) {

        var trie = new DesignAddAndSearchDataStructures();
        trie.addWord("cat");
        trie.addWord("car");
        trie.addWord("care");
        trie.addWord("bat");
        trie.addWord("cater");

        System.out.println(trie.search("c..e"));

    }

}
