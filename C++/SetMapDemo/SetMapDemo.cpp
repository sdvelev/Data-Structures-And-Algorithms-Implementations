

#include <iostream>
#include<vector>
#include<unordered_set>
#include<set>

using namespace std;

void printUnorderedSet(unordered_set<int> collection) {
    for (auto a : collection) {
        cout << a << " ";
    }
    cout << '\n';
}

void printUnorderedMultiSet(unordered_multiset<int> collection) {
    for (auto a : collection) {
        cout << a << " ";
    }
    cout << '\n';
}

void printOrderedSet(set<int> collection) {
    for (auto a : collection) {
        cout << a << " ";
    }
    cout << '\n';
}

void printOrderedMultiSet(multiset<int> collection) {
    for (auto a : collection) {
        cout << a << " ";
    }
    cout << '\n';
}

int main()
{
    cout << "Demonstration of unordered_set" << "\n";
    unordered_set<int> collectionSet;

    collectionSet.insert(6);
    collectionSet.insert(3);
    collectionSet.insert(4);
    collectionSet.insert(5);

    printUnorderedSet(collectionSet);

    collectionSet.insert(6);

    printUnorderedSet(collectionSet);

    cout << "Demonstration of unordered_multiset" << "\n";
    unordered_multiset<int> collectionMultiSet;

    collectionMultiSet.insert(6);
    collectionMultiSet.insert(3);
    collectionMultiSet.insert(4);
    collectionMultiSet.insert(5);

    printUnorderedMultiSet(collectionMultiSet);

    collectionMultiSet.insert(6);

    printUnorderedMultiSet(collectionMultiSet);

    cout << "Demonstration of set" << "\n";
    set<int> collectionSetOrdered;

    collectionSetOrdered.insert(6);
    collectionSetOrdered.insert(3);
    collectionSetOrdered.insert(4);
    collectionSetOrdered.insert(5);

    printOrderedSet(collectionSetOrdered);

    collectionSetOrdered.insert(6);

    printOrderedSet(collectionSetOrdered);

    cout << "Demonstration of multiset" << "\n";
    multiset<int> collectionMultiSetOrdered;

    collectionMultiSetOrdered.insert(6);
    collectionMultiSetOrdered.insert(3);
    collectionMultiSetOrdered.insert(4);
    collectionMultiSetOrdered.insert(5);

    printOrderedMultiSet(collectionMultiSetOrdered);

    collectionMultiSetOrdered.insert(6);

    printOrderedMultiSet(collectionMultiSetOrdered);
}
