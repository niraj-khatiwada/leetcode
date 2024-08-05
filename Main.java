import java.util.*;
import ConvertSortedListToBST109.ConvertSortedListToBST;

public class Main {
    public static void main(String[] args) {
        var r = new ConvertSortedListToBST();
        var abc = r.sortedListToBST();
        r.bfsUsingQueue(abc);
    }

}
