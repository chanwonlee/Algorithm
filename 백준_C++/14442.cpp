#include<bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int N, M, K, dist[1001][1001][11];
string board[1001];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;
    for (int i = 0; i < N; i++) cin >> board[i];
    for (int i = 0; i < N; i++) 
        for (int j = 0; j < M; j++) fill(dist[i][j], dist[i][j] + 11, -1);
    
    queue<tuple<int, int, int>> Q;
    Q.push({0, 0, 0});
    dist[0][0][0] = 0;
    while(!Q.empty()) {
        int curX, curY, broken;
        tie(curX, curY, broken) = Q.front(); Q.pop();
        if (curX == N - 1 && curY == M - 1) {
            cout << dist[curX][curY][broken] + 1;
            return 0;
        }
        for (int dir = 0; dir < 4; dir++) {
            int nx = dx[dir] + curX;
            int ny = dy[dir] + curY;

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (board[nx][ny] == '0' && dist[nx][ny][broken] == -1) {
                dist[nx][ny][broken] = dist[curX][curY][broken] + 1;
                Q.push({nx, ny, broken});
            }
            if (board[nx][ny] == '1' && broken + 1 <= K && dist[nx][ny][broken + 1] == -1) {
                dist[nx][ny][broken + 1] = dist[curX][curY][broken] + 1;
                Q.push({nx, ny, broken + 1});
            }
        }
    }
    cout << "-1";
}