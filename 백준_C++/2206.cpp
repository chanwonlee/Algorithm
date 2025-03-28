#include<bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int N, M, dist[1001][1001][2];
string board[1001];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; i++) cin >> board[i];
    for (int i = 0; i < N; i++) 
        for (int j = 0; j < M; j++) 
            dist[i][j][0] = dist[i][j][1] = -1;
    queue<tuple<int, int, int>> Q;
    Q.push({0, 0, 0});
    dist[0][0][0] = 1;
    while (!Q.empty()) {
        int x, y, broken;
        tie(x, y, broken) = Q.front(); Q.pop();
        if (x == N - 1 && y == M - 1) break;
        for (int dir = 0; dir < 4; dir++) {
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (board[nx][ny] == '0' && dist[nx][ny][broken] == -1) {
                dist[nx][ny][broken] = dist[x][y][broken] + 1;
                Q.push({nx, ny, broken});
            }
            if (board[nx][ny] == '1' && dist[nx][ny][1] == -1 && !broken) {
                dist[nx][ny][1] = dist[x][y][0] + 1;
                Q.push({nx, ny, 1});
            }
        }
    }

    int res0 = dist[N-1][M-1][0];
    int res1 = dist[N-1][M-1][1];

    if (res0 == -1 && res1 == -1) cout << -1 << '\n';
    else if (res0 == -1) cout << res1 << '\n';
    else if (res1 == -1) cout << res0 << '\n';
    else cout << min(res0, res1) << '\n';
}