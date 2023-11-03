package ProductOfArrayExceptItself238;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(list)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        int prefixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            prefixProduct *= value;
            prefix[i] = prefixProduct;
        }

        int postfixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int value = nums[i];
            postfixProduct *= value;
            postfix[i] = postfixProduct;
        }
        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(postfix));


        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prefixValue = i == 0 ? 1 : prefix[i - 1];
            int postfixValue = i == (nums.length - 1) ? 1 : postfix[i + 1];
            result[i] = prefixValue * postfixValue;
        }
        return result;
    }


}