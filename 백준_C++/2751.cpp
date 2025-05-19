#include <bits/stdc++.h>
using namespace std;

int N, arr[1000001], tmp[1000001];

void merge(int start, int end) {
    int mid = (start + end) / 2;
    int left = start;
    int right = mid;
    for (int i = start; i < end; i++) {
        if (right == end) tmp[i] = arr[left++];
        else if (left == mid) tmp[i] = arr[right++];
        else if (arr[left] <= arr[right]) tmp[i] = arr[left++];
        else tmp[i] = arr[right++];
    }
    for (int i = start; i < end; i++) arr[i] = tmp[i];
}

void merge_sort(int start, int end) {
    if (end - start == 1) return;
    int mid = (start + end) / 2;
    merge_sort(start, mid);
    merge_sort(mid, end);
    merge(start, end);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++) cin >> arr[i];
    merge_sort(0, N);
    for (int i = 0; i < N; i++) cout << arr[i] << "\n";
}