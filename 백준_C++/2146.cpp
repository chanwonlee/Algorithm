#include<bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int N, board[101][101], dist[101][101], land[101][101];
queue<pair<int, int>> Q;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++) 
            cin >> board[i][j];

    
    int mapNo = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (board[i][j] == 0 || land[i][j] != 0) continue;
            land[i][j] = ++mapNo;
            Q.push({i, j});

            while(!Q.empty()) {
                auto cur = Q.front(); Q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = dx[dir] + cur.first;
                    int ny = dy[dir] + cur.second;
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (board[nx][ny] == 0 || land[nx][ny] != 0) continue;
                    land[nx][ny] = mapNo;
                    Q.push({nx, ny});
                }
            }
        }
    }

    for (int i = 0; i < N; i++)
        fill(dist[i], dist[i] + N, -1);

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (land[i][j] != 0) {
                Q.push({i, j});
                dist[i][j] = 0;
            }
        }
    }

    int ans = 999999;

    while (!Q.empty()) {
        auto cur = Q.front(); Q.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = dx[dir] + cur.first;
            int ny = dy[dir] + cur.second;
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (land[nx][ny] != 0 && land[nx][ny] != land[cur.first][cur.second]) {
                ans = min(ans, dist[cur.first][cur.second] + dist[nx][ny]);
            }

            if (board[nx][ny] == 0 && dist[nx][ny] == -1) {
                land[nx][ny] = land[cur.first][cur.second];
                dist[nx][ny] = dist[cur.first][cur.second] + 1;
                Q.push({nx, ny});
            }
        }
    }

    cout << ans;
}