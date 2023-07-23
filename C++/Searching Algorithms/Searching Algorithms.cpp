
#include <iostream>
#include<vector>

using namespace std;

int binarySearch1(vector<int>& arr, int x, int left, int right) {
    while (left <= right) {
        int middle = left + (right - left) / 2;

        if (arr[middle] == x)
            return middle;

        if (arr[middle] < x)
            left = middle + 1;
        else
            right = middle - 1;
    }

    //Element is not found
    return -1;
}

//Return left index if it is not found
pair<bool, int> binarySearch2(vector<int>& arr, int x, int left, int right) {
    while (left <= right) {
        int middle = left + (right - left) / 2;

        if (arr[middle] == x)
            return make_pair(true, middle);

        if (arr[middle] < x)
            left = middle + 1;
        else
            right = middle - 1;
    }

    //Element is not found
    return make_pair(false, right);
}


int main()
{
    vector<int> arr = {11, 33, 44, 55, 66, 77, 88, 99};
    int x = 65;

    cout << binarySearch1(arr, x, 0, arr.size() - 1) << endl;

    cout << (boolalpha) << binarySearch2(arr, x, 0, arr.size() - 1).first << endl;
    cout << binarySearch2(arr, x, 0, arr.size() - 1).second << endl;

    return 0;
}

