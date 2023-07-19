#include <iostream>
#include<vector>

using namespace std;

void bubbleSort(int arr[], int n) {
   for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j+1]);
            }
        }
    }
}

void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int curValue = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > curValue) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = curValue;
    }
}

void selectionSort(int arr[], int n) {
    for (int j = 0; j < n - 1; j++) {
        int iMin = j;

        for (int i = j + 1; i < n; i++) {
            if (arr[i] < arr[iMin]) {
                iMin = i;
            }
        }
        if (j != iMin) {
            swap(arr[j], arr[iMin]);
        }
    }
}

int partitionMade(int arr[], int l, int r) {
    int pivot = arr[r];

    int i = l; 

    for (int j = l; j < r; j++) {
        if (arr[j] <= pivot) {
            swap(arr[i], arr[j]);
            i++;
        }
    }

    swap(arr[i], arr[r]);
    return i;
}

void quickSort(int arr[], int l, int r) {
    if (l < r) {
        int pivot = partitionMade(arr, l, r);

        quickSort(arr, l, pivot - 1);
        quickSort(arr, pivot + 1, r);
    }
}

void mergeMade(int arr[], int l, int mid, int r) {
    vector<int> left;
    vector<int> right;

    for (int i = l; i <= mid; i++) {
        left.push_back(arr[i]);
    }

    for (int i = mid + 1; i <= r; i++) {
        right.push_back(arr[i]);
    }

    int i = 0;
    int j = 0;
    int index = l;

    while (i < left.size() && j < right.size()) {
        if (left[i] < right[j]) {
            arr[index++] = left[i++];
        }
        else {
            arr[index++] = right[j++];
        }
    }

    while (i < left.size()) {
        arr[index++] = left[i++];
    }

    while (j < right.size()) {
        arr[index++] = right[j++];
    }
}

void mergeSort(int arr[], int l, int r) {
    if (r - l <= 0) {
        return;
    }
    int mid = l + (r - l) / 2;
    mergeSort(arr, l, mid);
    mergeSort(arr, mid + 1, r);

    mergeMade(arr, l, mid, r);
}

void countingSort(int arr[], int n) {
    int maxElement = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] > maxElement) {
            maxElement = arr[i];
        }
    }

    vector<int> countingArray(maxElement + 1);

    for (int i = 0; i < maxElement + 1; i++) {
        countingArray[i] = 0;
    }

    for (int i = 0; i < n; i++) {
        countingArray[arr[i]]++;
    }

    int currentIndexOfArray = 0;
    for (int i = 0; i <= maxElement; i++) {
        for (int j = 0; j < countingArray[i]; j++) {
            arr[currentIndexOfArray++] = i;
        }
    }
}

const int SIZE = 10;
int main()
{
    //Bubble Sort
    int arr[SIZE] = {3, 7, 9, 12, 6, 8, 2, 4, 1, 11};
    bubbleSort(arr, SIZE);
        
    for (int i = 0; i < SIZE; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    //Insertion Sort
    int arr2[SIZE] = { 3, 7, 9, 12, 6, 8, 2, 4, 1, 11 };
    insertionSort(arr2, SIZE);

    for (int i = 0; i < SIZE; i++) {
        cout << arr2[i] << " ";
    }
    cout << endl;

    //Selection Sort
    int arr3[SIZE] = { 3, 7, 9, 12, 6, 8, 2, 4, 1, 11 };
    insertionSort(arr3, SIZE);

    for (int i = 0; i < SIZE; i++) {
        cout << arr3[i] << " ";
    }
    cout << endl;

    //Quick Sort
    int arr4[SIZE] = { 3, 7, 9, 12, 6, 8, 2, 4, 1, 11 };
    quickSort(arr4, 0, SIZE - 1);

    for (int i = 0; i < SIZE; i++) {
        cout << arr4[i] << " ";
    }
    cout << endl;

    //Merge Sort
    int arr5[SIZE] = { 3, 7, 9, 12, 6, 8, 2, 4, 1, 11 };
    mergeSort(arr5, 0, SIZE - 1);

    for (int i = 0; i < SIZE; i++) {
        cout << arr5[i] << " ";
    }
    cout << endl;

    //Counting Sort
    int arr6[SIZE] = { 3, 7, 9, 12, 6, 8, 2, 4, 1, 11};
    countingSort(arr6, SIZE);

    for (int i = 0; i < SIZE; i++) {
        cout << arr6[i] << " ";
    }
    cout << endl;

    return 0;
}

