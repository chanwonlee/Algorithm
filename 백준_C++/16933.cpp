#include<bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
string board[1001];
int N, M, K, dist[1001][1001][11][2];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;
    for (int i = 0; i < N; i++) cin >> board[i];
    
    queue<tuple<int, int, int, int>> Q;
    dist[0][0][0][0] = 1;
    Q.push({0, 0, 0, 0});
    while(!Q.empty()) {
        int curX, curY, broken, t;
        tie(curX, curY, broken, t) = Q.front(); Q.pop();

        if (curX == N - 1 && curY == M - 1) {
            cout << dist[curX][curY][broken][t];
            return 0;
        }
        
        for (int dir = 0; dir < 4; dir++) {
            int nx = dx[dir] + curX;
            int ny = dy[dir] + curY;
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            int nt = 1 - t;
            if (board[nx][ny] == '0' && dist[nx][ny][broken][nt] == 0) {
                dist[nx][ny][broken][nt] = dist[curX][curY][broken][t] + 1;
                Q.push({nx, ny, broken, nt});
            }

            if (board[nx][ny] == '1' && broken + 1 <= K) {
                if (t == 0) {
                    if (dist[nx][ny][broken + 1][nt] == 0) {
                        dist[nx][ny][broken + 1][nt] = dist[curX][curY][broken][t] + 1;
                        Q.push({nx, ny, broken + 1, nt});
                    }
                } else {
                    if (dist[curX][curY][broken][nt] == 0) {
                        dist[curX][curY][broken][nt] = dist[curX][curY][broken][t] + 1;
                        Q.push({curX, curY, broken, nt});
                    }
                }
            }
        }
    }
    cout << -1;
}