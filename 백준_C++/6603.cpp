#include<bits/stdc++.h>
using namespace std;

int k, arr[13], ans[13];
void func(int n, int start) {
    if (n == 6) {
        for (int i = 0; i < 6; i++) cout << ans[i] << ' ';
        cout << '\n';
        return;
    }

    for (int i = start; i < k; i++) {
        ans[n] = arr[i];
        func(n + 1, i + 1);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    while (1) {
        cin >> k;
        if (k == 0) break;
        for (int i = 0; i < k; i++) cin >> arr[i];
        func(0, 0);
        cout << '\n';
    }
}