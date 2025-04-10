#include <bits/stdc++.h>
using namespace std;

int N, M, arr[10], ans[10];

void func(int k, int start) {
    if (k == M) {
        for (int i = 0; i < M; i++) cout << ans[i] << ' ';
        cout << '\n';
        return;
    }
    
    int tmp = 0;
    for (int i = start; i < N; i++) {
        if (tmp == arr[i]) continue;
        tmp = arr[i];
        ans[k] = arr[i];
        func(k + 1, i);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for(int i = 0; i < N; i++) cin >> arr[i];
    sort(arr, arr + N);
    func(0, 0);
}