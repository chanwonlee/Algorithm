#include<bits/stdc++.h>
using namespace std;

int M, N, H, board[101][101][101], dist[101][101][101];
int dx[6] = {0, 0, 1, -1, 0, 0};
int dy[6] = {1, -1, 0, 0, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};
queue<tuple<int, int, int>> Q;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> M >> N >> H;
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                int tmp;
                cin >> tmp;
                board[j][k][i] = tmp;
                if (tmp == 1) Q.push({j, k, i});
                if (tmp == 0) dist[j][k][i] = -1;
            }
        }
    }

    while (!Q.empty()) {
        auto cur = Q.front(); Q.pop();
        int curX, curY, curZ;
        tie(curX, curY, curZ) = cur;
        for (int dir = 0; dir < 6; dir++) {
            int nx = dx[dir] + curX;
            int ny = dy[dir] + curY;
            int nz = dz[dir] + curZ;
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
            if (dist[nx][ny][nz] >= 0) continue;
            dist[nx][ny][nz] = dist[curX][curY][curZ] + 1;
            Q.push({nx, ny, nz});
        }
    }

    int ans = 0;
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if (dist[j][k][i] == -1) {
                    cout << -1 << "\n";
                    return 0;
                }
            ans = max(ans, dist[j][k][i]);
            }
        }
    }
    cout << ans << "\n";
}