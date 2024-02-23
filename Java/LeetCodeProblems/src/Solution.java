import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums[0] != 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                return nums[i - 1] + 1;
            }
        }

        return nums.length;
    }

    public static boolean isHappy(int n) {
        while (n > 9) {
            int currentNumber = n;
            n = 0;
            while (currentNumber != 0) {
                n = n + (currentNumber % 10) * (currentNumber % 10);
                currentNumber /= 10;
            }
        }
        return n == 1 || n == 7;
    }

    public static int hammingWeight(int n) {
        int counter = 0;
        long l = n;
        if (l < 0) {
            l = (long) Math.pow(2, 32) + l;
        }

        String binary = decimalToBinary(l);;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                ++counter;
            }
        }
        return counter;
    }

    private static String decimalToBinary(long decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            long remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal /= 2;
        }

        return binary.toString();
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headA : a.next;
            b = b == null ? headB : b.next;
        }

        return a;
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s.toLowerCase());

        for (int i = 0; i < stringBuilder.length(); i++) {
            if (!Character.isLetterOrDigit(stringBuilder.charAt(i))) {
                stringBuilder.deleteCharAt(i);
                --i;
            }
        }
        for (int i = 0; i < stringBuilder.length() / 2; i++) {
            if (stringBuilder.charAt(i) != stringBuilder.charAt(stringBuilder.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int maxProfit(int[] prices) {
        int maxAnswer = 0;
        int buyValue = prices[0];
        for (int price : prices) {
            buyValue = Math.min(buyValue, price);
            maxAnswer = Math.max(maxAnswer, price - buyValue);
        }
        return maxAnswer;
    }

    public static List<List<Integer>> generatePascal(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            Integer[] temp = new Integer[i + 1];
            Arrays.fill(temp, 1);
            ans.add(Arrays.asList(temp));
        }

        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < ans.get(i).size() - 1; j++) {
                ans.get(i).set(j, ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
        }
        return ans;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    public  static String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            StringBuilder currentString = new StringBuilder(words[i]);
            if (words[i].equals(currentString.reverse().toString())) {
                return words[i];
            }
        }
        return "";
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    public static int reverse(int x) {
        boolean isNegative = false;
        if (x == Integer.MIN_VALUE) {
            return 0;
        } else if (x < 0) {
            isNegative = true;
            x = -x;
        }

        String numberString = String.valueOf(x);
        StringBuilder numberStringBuilder = new StringBuilder(numberString);
        numberString = numberStringBuilder.reverse().toString();

        if (isNegative) {
            if (-Long.parseLong(numberString) < Integer.MIN_VALUE) {
                return 0;
            }
        } else {
            if (Long.parseLong(numberString) > Integer.MAX_VALUE) {
                return 0;
            }
        }

        return isNegative ? -Integer.parseInt(numberString) : Integer.parseInt(numberString);
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
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

        // Missing Number
        System.out.println(Solution.missingNumber(new int[] {5, 3, 0, 1, 4, 2}));

        // Is Happy Number
        System.out.println(Solution.isHappy(19));

        // Hamming Weight
        System.out.println(Solution.hammingWeight(11));
        System.out.println(Solution.hammingWeight(-3));

        // Single Number
        System.out.println(Solution.singleNumber(new int[]{1, 6, 5, 4, 4, 5, 3, 1, 3}));

        // Valid Palindrome
        System.out.println(Solution.isPalindrome("A man, a plan, a canal: Panama"));

        // Max profit
        System.out.println(Solution.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));

        // Pascal Triangle
        System.out.println(Solution.generatePascal(6));

        // First Palindrome
        System.out.println(Solution.firstPalindrome(new String[] {"abc", "car", "racecar", "azx", "ala"}));

        // Reverse Integer
        System.out.println(Solution.reverse(666000));
        System.out.println(Solution.reverse(120));
        System.out.println(Solution.reverse(-2147483648));

        // Valid Sudoku
        System.out.println(Solution.isValidSudoku(new char[][] {
            {'5','3', '.','.','7','.','.','.','.'},
            {'6','.', '.','1','9','5','.','.','.'},
            {'.','9', '8','.','.','.','.','6','.'},
            {'8','.', '.','.','6','.','.','.','3'},
            {'4','.', '.','8','.','3','.','.','1'},
            {'7','.', '.','.','2','.','.','.','6'},
            {'.','6', '.','.','.','.','2','8','.'},
            {'.','.', '.','4','1','9','.','.','5'},
            {'.','.', '.','.','8','.','.','7','9'},
        }));

        // Search in Rotated Sorted Array
        System.out.println(Solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
