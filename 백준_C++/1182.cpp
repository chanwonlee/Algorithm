#include <bits/stdc++.h>
using namespace std;

int N, S, ans, arr[21];

void func(int k, int tot) {
    if (k == N) {
        if (tot == S) ans++;
        return;
    }
    func(k + 1, tot);
    func(k + 1, tot + arr[k]);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> S;
    for (int i = 0; i < N; i++) cin >> arr[i];
    func(0, 0);
    if (S == 0) ans--;
    cout << ans;
}