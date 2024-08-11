import java.util.*;
import CountNumberOfIslands200.UsingBFS;

public class Main {
    public static void main(String[] args) {

        var a = new UsingBFS();

        System.out.println(a.numIslands(new char[][] {
                { '0', '1', '1', '1', '0' },
                { '0', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        }));

    }

}
