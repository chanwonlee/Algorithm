#include <bits/stdc++.h>
using namespace std;

int N, d[1000005], pre[1000005];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    d[1] = 0;

    for (int i = 2; i <= N; i++) {
        d[i] = d[i - 1] + 1;
        pre[i] = i - 1;
        if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
            d[i] = d[i / 2] + 1;
            pre[i] = i / 2;
        }

        if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
            d[i] = d[i / 3] + 1;
            pre[i] = i / 3;
        }
    }

    cout << d[N] << '\n';
    int cur = N;
    while (true) {
        cout << cur << ' ';
        if (cur == 1) break;
        cur = pre[cur];
    }
}