package ProductsOfArray238;

// Medium
public class ProductsOfArray {
    // O(n)
    // This approach uses division operator. But, the question might have a
    // condition that restricts you from using division operator.
    public int[] productExceptSelfDivision(int[] nums) {
        var product = 1;
        var zerosCount = 0;
        for (var n : nums) {
            if (n != 0) {
                product *= n;
            } else {
                zerosCount++;
            }
        }

        var result = new int[nums.length];

        for (var i = 0; i < nums.length; i++) {
            var current = nums[i];
            if (zerosCount > 1) {
                result[i] = 0;
            } else if (zerosCount == 1) {
                result[i] = current == 0 ? product : 0;
            } else {
                result[i] = product / (current == 0 ? 1 : current);
            }
        }

        return result;
    }

    // No division method
    // Uses Postfix and Prefix method
    public int[] productExceptSelf(int[] nums) {
        var len = nums.length;
        // We can also compute prefix and postfix within same result array. This saves
        // these 2 extra array spaces.
        // See solution below.
        var prefix = new int[len];
        var postfix = new int[len];

        for (var i = 0; i < len; i++) {
            prefix[i] = i == 0 ? nums[i] : (prefix[i - 1] * nums[i]);
            var endIndex = len - 1 - i;
            postfix[endIndex] = endIndex == (len - 1) ? nums[endIndex] : (postfix[endIndex + 1] * nums[endIndex]);
        }

        var result = new int[len];
        for (var i = 0; i < len; i++) {
            result[i] = (i == 0 ? 1 : prefix[i - 1]) * (i == (len - 1) ? 1 : postfix[i + 1]);
        }
        return result;
    }

    public int[] productExceptSelfEnhanced(int[] nums) {
        var len = nums.length;
        // We can also compute prefix and postfix within same result array. This saves
        // these 2 extra array spaces.
        // See solution below.
        var result = new int[len];

        for (var i = 0; i < len; i++) {
            result[i] = i == 0 ? nums[i] : (result[i - 1] * nums[i]);
        }

        var postfixValue = 1;
        for (var i = (len - 1); i >= 0; i--) {
            // Store the prefix * postfix value
            result[i] = ((i - 1) < 0 ? 1 : result[i - 1]) * postfixValue;
            // Store the prefix value for previous index to use next time.
            postfixValue *= nums[i];
        }
        return result;
    }

}
