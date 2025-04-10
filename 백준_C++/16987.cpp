#include<bits/stdc++.h>
using namespace std;

int N, cnt, ans, S[8], W[8];

void solve(int cur) {
    if (cur == N - 1) {
        ans = max(cnt, ans);
        return;
    }

    if (S[cur] <= 0 || cnt == N - 1) {
        solve(cur + 1);
        return;
    }

    for (int i = 0; i < N; i++) {
        if (cur == i || S[i] <= 0) continue;
        S[cur] -= W[i];
        S[i] -= W[cur];
        if (S[cur] <= 0) cnt++;
        if (S[i] <= 0) cnt++;
        solve(cur + 1);
        if (S[cur] <= 0) cnt--;
        if (S[i] <= 0) cnt--;
        S[cur] += W[i];
        S[i] += W[cur];
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> S[i] >> W[i];
    }
    solve(0);
    cout << ans;
}