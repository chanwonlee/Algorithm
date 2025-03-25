#include<bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int board[51][51], vis[51][51];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int T;
    cin >> T;

    while (T--) {
        int M, N, K;
        cin >> M >> N >> K;
        for (int i = 0; i < K; i++) {
            int x, y;
            cin >> x >> y;
            board[x][y] = 1;
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 || vis[i][j] == 1) continue;
                queue<pair<int, int>> Q;
                vis[i][j] = 1;
                Q.push({i, j});
                ans++;
                while(!Q.empty()) {
                    auto cur = Q.front(); Q.pop();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = dx[dir] + cur.first;
                        int ny = dy[dir] + cur.second;
                        if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                        if (board[nx][ny] == 0 || vis[nx][ny] == 1) continue;
                        vis[nx][ny] = 1;
                        Q.push({nx, ny});   
                    }
                }
            }
        }
        cout << ans << "\n";
        for (int i = 0; i < M; i++) {
            fill(board[i], board[i] + N, 0);
            fill(vis[i], vis[i] + N, 0);
        }
    }
}