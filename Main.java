import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        int[] list = new int[2];
        List<Integer>[] indexMapper = new ArrayList[2];
        List<Integer> l = new ArrayList<>(Arrays.asList(1));
        l.add(100);
        indexMapper[0] = l;
        System.out.println((Arrays.toString(indexMapper)));
    }


}