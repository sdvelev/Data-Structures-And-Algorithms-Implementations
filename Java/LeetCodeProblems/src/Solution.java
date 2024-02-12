import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> collection1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            collection1.put(nums1[i], collection1.getOrDefault(nums1[i], 0) + 1);
        }

        Map<Integer, Integer> collection2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            collection2.put(nums2[i], collection2.getOrDefault(nums2[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> currentEntry : collection1.entrySet()) {
            int currentNumber = currentEntry.getKey();
            int currentNumberCount1 = currentEntry.getValue();
            if (collection2.containsKey(currentNumber)) {
                int currentNumberCount2 = collection2.get(currentNumber);
                for (int i = 0; i < Math.min(currentNumberCount1, currentNumberCount2); i++){
                    result.add(currentNumber);
                }
            }
        }

        int[] resultAsArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultAsArray[i] = result.get(i);
        }

        return resultAsArray;
    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

    public static boolean isPowerOfThree(int n) {
        long biggestPossible = (long) Math.pow(3, 32);
        if (n <= 0) {
            return false;
        }

        return biggestPossible % n == 0;
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }

        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        // Intersect Problem
        int[] resultIntersect = Solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(Arrays.toString(resultIntersect));

        // Reverse string in-place
        char[] toReverseArray = new char[] {'H', 'e', 'l', 'l', 'o'};
        Solution.reverseString(toReverseArray);
        System.out.println(Arrays.toString(toReverseArray));

        // Power of Three
        System.out.println(Solution.isPowerOfThree(43_046_721));

        // Move Zeroes
        int[] arrayToMoveZeroes = new int[] {1, 0, 0, 0, 2, 3, 5, 4, 0, 0, 0, 6, 0, 7, 8, 0, 0, 9, 0};
        Solution.moveZeroes(arrayToMoveZeroes);
        System.out.println(Arrays.toString(arrayToMoveZeroes));
    }
}
