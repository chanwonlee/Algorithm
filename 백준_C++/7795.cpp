#include <bits/stdc++.h>
using namespace std;

int T, a[20001];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T--) {
        int n, m;
        cin >> n >> m;
        for (int i = 0; i < n; i++) cin >> a[i];
        sort(a, a + n);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int num;
            cin >> num;
            int idx = upper_bound(a, a + n, num) - a;
            ans += n - idx;
        }
        cout << ans << '\n';
    }
}