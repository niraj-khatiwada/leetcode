import java.util.*;

import WordSearchII212.WordSearchII;

public class Main {
    public static void main(String[] args) {
        var bt = new WordSearchII();
        System.out.println(bt.findWords(
                new char[][] { { 'o', 'a', 'a', 'n' },
                        { 'e', 't', 'a', 'e' },
                        { 'i', 'h', 'k', 'r' }, {
                                'i', 'f', 'l', 'v'
                        } },
                new String[] { "oath", "pea", "eat", "rain" }));
    }

}
