#include<bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0 ,0};
string board[1001];
queue<pair<int, int>> Q;
pair<int, int> start;
int T, w, h, fire[1001][1001], dist[1001][1001];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while(T--) {
        cin >> w >> h;
        for(int i = 0; i < h; i++) cin >> board[i];
        for (int i = 0; i < h; i++) {
            fill(fire[i], fire[i] + w, -1);
            fill(dist[i], dist[i] + w, -1);
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if (board[i][j] == '*') {
                    Q.push({i, j});
                    fire[i][j] = 0;
                }
                if (board[i][j] == '@') {
                    start = {i, j};
                    dist[i][j] = 0;
                }
            }
        }
        
        while (!Q.empty()) {
            auto cur = Q.front(); Q.pop();
            for(int dir = 0; dir < 4; dir++) {
                int nx = dx[dir] + cur.first;
                int ny = dy[dir] + cur.second;
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (board[nx][ny] == '#' || fire[nx][ny] >= 0) continue;
                fire[nx][ny] = fire[cur.first][cur.second] + 1;
                Q.push({nx, ny});
            }
        }

        bool escape = false;
        Q.push(start);
        while (!Q.empty() && !escape) {
            auto cur = Q.front(); Q.pop();
            for(int dir = 0; dir < 4; dir++) {
                int nx = dx[dir] + cur.first;
                int ny = dy[dir] + cur.second;
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    escape = true;
                    cout << dist[cur.first][cur.second] + 1 << "\n";
                    break;
                }
                if (board[nx][ny] == '#' || dist[nx][ny] >=0) continue;
                if (fire[nx][ny] != -1 && dist[cur.first][cur.second] + 1 >= fire[nx][ny]) continue;
                dist[nx][ny] = dist[cur.first][cur.second] + 1;
                Q.push({nx, ny});
            }
        }
        if (!escape) cout << "IMPOSSIBLE" << "\n";
    }
}