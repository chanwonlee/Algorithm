#include <bits/stdc++.h>
using namespace std;

int R, C, fire[1001][1001], dist[1001][1001];
string board[1001];
int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> R >> C;
    for (int i = 0; i < R; i++) cin >> board[i];
    queue<pair<int, int>> Q;
    pair<int, int> start;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (board[i][j] == 'J') start = {i, j};
            if (board[i][j] == 'F') {
                Q.push({i, j});
                fire[i][j] = 1;
            }
        }
    }

    while(!Q.empty()) {
        auto cur = Q.front(); Q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (fire[nx][ny] > 0 || board[nx][ny] == '#') continue;
            fire[nx][ny] = fire[cur.first][cur.second] + 1;
            Q.push({nx, ny});
        }
    }

    Q.push({start});
    dist[start.first][start.second] = 1;
    while(!Q.empty()) {
        auto cur = Q.front(); Q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx == -1 || nx == R || ny == -1 || ny == C) {
                cout << dist[cur.first][cur.second];
                return 0;
            } 
            if (dist[nx][ny] != 0 || board[nx][ny] == '#') continue;
            if (fire[nx][ny] != 0 && dist[cur.first][cur.second] + 1 >= fire[nx][ny]) continue;

            dist[nx][ny] = dist[cur.first][cur.second] + 1;
            Q.push({nx, ny});
        }
    }
    cout << "IMPOSSIBLE";
}