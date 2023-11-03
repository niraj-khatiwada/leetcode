package ContainsDuplicate217;

import java.util.HashSet;

public class Main {


    public static void main(String[] args) {
        int[] list = {1, 2, 3, 1};
        System.out.println(containsDuplicate(list));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        boolean hasDuplicate = false;
        for (int number : nums) {
            if (set.contains(number)) {
                hasDuplicate = true;
                break;
            }
            set.add(number);
        }
        return hasDuplicate;
    }


}