#include <bits/stdc++.h>
using namespace std;

int N, M, d[100001];
long long s[100001];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; i++) cin >> d[i];
    s[0] = 0;
    for (int i = 1; i <= N; i++) s[i] = s[i - 1] + d[i - 1];
    while (M--) {
        int i, j;
        cin >> i >> j;
        cout << s[j] - s[i - 1] << "\n";
    }
}