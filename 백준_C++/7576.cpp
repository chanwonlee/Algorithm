#include<bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int M, N, board[1001][1001];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> M >> N;
    queue<pair<int, int>> Q;
    for(int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> board[i][j];
            if (board[i][j] == 1) Q.push({i, j});
        }
    }
    
    while(!Q.empty()) {
        auto cur = Q.front(); Q.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (board[nx][ny] != 0) continue;
            board[nx][ny] = board[cur.first][cur.second] + 1;
            Q.push({nx, ny});
        }
    }

    int ans = 0;
    for(int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (board[i][j] == 0) {
                cout << -1;
                return 0;
            }
            if (ans < board[i][j]) ans = board[i][j];
        } 
    }
    cout << ans - 1;
}