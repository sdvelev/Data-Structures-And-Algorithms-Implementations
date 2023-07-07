import java.util.Arrays;

public class SortingAlgorithms {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int j = 0; j < n - 1; j++) {
            int iMin = j;
            for (int i = j + 1; i < n; i++) {
                if (arr[i] < arr[iMin]) {
                    iMin = i;
                }
            }
            if (iMin != j) {
                int tmp = arr[j];
                arr[j] = arr[iMin];
                arr[iMin] = tmp;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int currValue = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > currValue) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currValue;
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];//pick rightmost element as pivot
        //elements less than pivot will be pushed to the left of i
        //elements bigger than pivot will be pushed to the right of i
        int i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] <= pivot) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }
        }
        int tmp = arr[r];
        arr[r] = arr[i];
        arr[i] = arr[r];
        return i;
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, r);
        }
    }


    public static void main(String[] args) {

        // BubbleSort
        int [] arrBubbleSort = {4, 2, 6, 1, 7, 9, 8};
        bubbleSort(arrBubbleSort);
        System.out.println(Arrays.toString(arrBubbleSort));

        // SelectionSort
        int [] arrSelectionSort = {4, 2, 6, 1, 7, 9, 8};
        selectionSort(arrSelectionSort);
        System.out.println(Arrays.toString(arrSelectionSort));

        // InsertionSort
        int [] arrInsertionSort = {4, 2, 6, 1, 7, 9, 8};
        insertionSort(arrInsertionSort);
        System.out.println(Arrays.toString(arrInsertionSort));

    }
}
