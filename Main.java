import java.util.*;

import WordSearch79.WordSearch;

public class Main {
    public static void main(String[] args) {
        var bt = new WordSearch();
        System.out.println(bt.exist(
                new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED"));
    }

}
