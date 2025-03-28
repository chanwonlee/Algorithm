#include <bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int N, M, board[301][301], vis[301][301];
queue<pair<int, int>> Q;

int count_glacier() {
    int count = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (board[i][j] == 0 || vis[i][j] == 1) continue;
            count++;
            Q.push({i, j});
            vis[i][j] = 1;
            while(!Q.empty()) {
                auto cur = Q.front(); Q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = dx[dir] + cur.first;
                    int ny = dy[dir] + cur.second;
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (board[nx][ny] == 0 || vis[nx][ny] == 1) continue;
                    Q.push({nx, ny});
                    vis[nx][ny] = 1;
                }
            }
        }
    }
    for (int i = 0; i < N; i++) fill(vis[i], vis[i] + M, 0);
    return count;
}

void melt() {
    int newBoard[301][301];
    for (int i = 0; i < N; i++) fill(newBoard[i], newBoard[i] + M, 0);

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (board[i][j] == 0) continue;

            int count = 0;
            for (int dir = 0; dir < 4; dir++) {
                int nx = dx[dir] + i;
                int ny = dy[dir] + j;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (board[nx][ny] > 0) continue;
                count++;
            }
            newBoard[i][j] = max(0, board[i][j] - count);
        }
    }
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            board[i][j] = newBoard[i][j];
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; i++) 
        for (int j = 0; j < M; j++)
            cin >> board[i][j];

    int ans = 0;
    while(true) {
        int count = count_glacier();
        if (count == 0) {
            cout << "0";
            break;
        }
        if (count >= 2) {
            cout << ans;
            break;
        }
        melt();
        ans++;
    }
}