#include <bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int N, M, board[501][501], vis[501][501], ans;

void solve(int x, int y, int count, int sum) {
    if (count == 4) {
        ans = max(ans, sum);
        return;
    }

    for (int dir = 0; dir < 4; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if (vis[nx][ny]) continue;
        vis[nx][ny] = true;
        solve(nx, ny, count + 1, sum + board[nx][ny]);
        if (count == 2)
            solve(x, y, count + 1, sum + board[nx][ny]);
        vis[nx][ny] = false;
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; i++) 
        for (int j = 0; j < M; j++) 
            cin >> board[i][j];

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            vis[i][j] = true;
            solve(i, j, 1, board[i][j]);
            vis[i][j] = false;
        }
    }
    cout << ans;
}