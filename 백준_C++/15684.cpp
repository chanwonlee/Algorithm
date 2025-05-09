#include <bits/stdc++.h>
using namespace std;

int N, M, H;
bool ladders[31][11];
vector<pair<int, int>> possible;
int ans = 4;

bool check() {
    for (int j = 1; j <= N; j++) {
        int cur = j;
        for (int i = 1; i <= H; i++) {
            if (ladders[i][cur - 1]) cur--;
            else if (ladders[i][cur]) cur++;
        }
        if (cur != j) return false;
    }
    return true;
}

void solve(int idx, int count) {
    if (count >= ans) return;
    if (check()) {
        ans = count;
        return;
    }
    if (count == 3) return;

    for (int i = idx; i < possible.size(); i++) {
        auto [x, y] = possible[i];
        if (ladders[x][y] || ladders[x][y - 1] || ladders[x][y + 1]) continue;
        ladders[x][y] = true;
        solve(i + 1, count + 1);
        ladders[x][y] = false;
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> H;

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        ladders[a][b] = true;
    }
 
    for (int i = 1; i <= H; i++) {
        for (int j = 1; j < N; j++) {
            if (ladders[i][j - 1] || ladders[i][j] || ladders[i][j + 1]) continue;
            possible.push_back({i, j});
        }
    }

    solve(0, 0);
    cout << (ans == 4 ? -1 : ans) << '\n';
}