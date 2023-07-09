import java.util.AbstractMap;
import java.util.Map;

public class SearchingAlgorithms {

    public static boolean linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchRecursive(int[] arr, int l, int r, int x) {
        if (l > r) {
            return false;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] == x) {
            return true;
        } else if (arr[mid] < x) {
            return binarySearchRecursive(arr, mid + 1, r, x);
        } else {
            return binarySearchRecursive(arr, l, mid - 1, x);
        }
    }

    public static int binarySearchIterative(int[] arr, int l, int r, int x) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x) {
                return m;
            } else if (arr[m] < x) {
                l = m + 1;
            } else if (arr[m] > x) {
                r = m - 1;
            }
        }
        return -1;
    }

    public static Map.Entry<Boolean, Integer> binarySearchIterativeWithPositions(int[] arr, int l, int r, int x) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x) {
                return new AbstractMap.SimpleEntry<>(true, m);
            } else if (arr[m] < x) {
                l = m + 1;
            } else if (arr[m] > x) {
                r = m - 1;
            }
        }
        return new AbstractMap.SimpleEntry<>(false, l);
    }

    public static boolean ternarySearch(int[] arr, int l, int r, int x) {
        if (r < l) {
            return false;
        }
        int m1 = (2 * l + r) / 3;
        int m2 = (l + 2 * r) / 3;
        if (arr[m1] == x || arr[m2] == x) {
            return true;
        }
        if (arr[m1] > x) {
            return ternarySearch(arr, 0, m1 - 1, x);
        }
        if (arr[m2] > x) {
            return ternarySearch(arr, m1 + 1, m2 - 1, x);
        }
        return ternarySearch(arr, m2 + 1, r, x);
    }

    public static void main(String[] args) {
        // Linear Search
        int[] arrLinearSearch = {4, 3, 2, 5, 7, 8, 111, 13};
        System.out.println(linearSearch(arrLinearSearch, 13));

        // Binary Search
        int[] arrBinarySearch = {4, 6, 7, 7, 8, 9, 9, 11};
        System.out.println(binarySearchRecursive(arrBinarySearch, 0, arrBinarySearch.length - 1, 11));
        System.out.println(binarySearchIterative(arrBinarySearch, 0, arrBinarySearch.length - 1, 4));
        Map.Entry<Boolean, Integer> res = binarySearchIterativeWithPositions(arrBinarySearch, 0, arrBinarySearch.length - 1, 5);
        System.out.println(res.getKey() + " " + res.getValue());

        // Ternary Search
        int[] arrTernarySearch = {2, 3, 4, 5, 7, 8, 11, 13};
        System.out.println(ternarySearch(arrTernarySearch, 0, arrTernarySearch.length - 1, 17));
    }
}