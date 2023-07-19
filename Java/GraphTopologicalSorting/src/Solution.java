import java.util.Arrays;

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int currentM = 0;
        int currentN = 0;

        for (int i = 0; i < m + n; i++) {

            if (currentM + 1 > m) {
                nums1[i] = nums2[currentN++];
                continue;
            }

            if (currentN + 1 > n) {
                nums1[i] = nums1[currentM++];
                continue;
            }

            if (nums1[currentM] < nums2[currentN]) {
                nums1[i] = nums1[currentM++];
            } else if (nums1[currentM] >= nums2[currentN]) {
                nums1[i] = nums2[currentN++];
            }
        }
    }

    public static int removeElement(int[] nums, int val) {

        int numberOfDifferentElements = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                numberOfDifferentElements++;
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        numberOfDifferentElements++;
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
        return numberOfDifferentElements;
    }

    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
//        Task1: Merge Arrays
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//
//        int[] nums2 = {2, 5, 6};
//        int n = 3;
//
//        merge(nums1, m, nums2, n);
//
//        System.out.println(Arrays.toString(nums1));

//        Task2: Remove Elements
//        int[] nums = {3, 2, 2, 3};
//        int val = 3;
//
//        System.out.println(removeElement(nums, val));
//
//        System.out.println(Arrays.toString(nums));

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(removeDuplicates(nums));

        System.out.println(Arrays.toString(nums));

    }
}