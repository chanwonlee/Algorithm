#include <bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int N, board[101][101], vis[101][101];
queue<pair<int, int>> Q;

int bfs(int h) {
    int count = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (board[i][j] <= h || vis[i][j] == 1) continue;
            count++;
            vis[i][j] = 1;
            Q.push({i, j});
            while(!Q.empty()) {
                auto cur = Q.front(); Q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = dx[dir] + cur.first;
                    int ny = dy[dir] + cur.second;
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (board[nx][ny] <= h || vis[nx][ny] == 1) continue;
                    Q.push({nx, ny});
                    vis[nx][ny] = 1;
                }
            }
        }
    }
    for (int i = 0; i < N; i++) fill(vis[i], vis[i] + N, 0);
    return count;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++) 
        for (int j = 0; j < N; j++) cin >> board[i][j];

    int ans = 0;
    for (int i = 0; i < 101; i++) {
        ans = max(ans, bfs(i));
    }
    cout << ans;
}