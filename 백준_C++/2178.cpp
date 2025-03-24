#include<bits/stdc++.h>
using namespace std;

int N, M, dist[101][101];
string board[101];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N >> M;
    for (int i = 0; i < N; i++) cin >> board[i];
    for(int i = 0; i < N; i++) fill(dist[i], dist[i] + M, -1);
    queue<pair<int, int>> Q;
    dist[0][0] = 0;
    Q.push({0, 0});
    
    while (!Q.empty()) {
        pair<int, int> cur = Q.front(); Q.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (dist[nx][ny] >= 0|| board[nx][ny] != '1') continue;
            dist[nx][ny] = dist[cur.first][cur.second] + 1;
            Q.push({nx, ny});
        }
    }
    cout << dist[N - 1][M - 1] + 1;
}