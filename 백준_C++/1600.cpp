#include<bits/stdc++.h>
using namespace std;

int dx[12] = {0, 0, 1, -1, 2, 2, 1, 1, -1, -1, -2, -2};
int dy[12] = {1, -1, 0, 0, -1, 1, -2, 2, -2, 2, -1, 1};
int K, W, H, board[201][201], dist[201][201][31];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> K >> W >> H;
    for (int i = 0; i < H; i++) 
        for (int j = 0; j < W; j++) cin >> board[i][j];

    for (int i  = 0; i < H; i++)
        for (int j = 0; j < W; j++)
            fill(dist[i][j], dist[i][j] + K + 1, - 1);

    queue<tuple<int, int, int>> Q;
    dist[0][0][0] = 0;
    Q.push({0, 0, 0});

    while(!Q.empty()) {
        int curX, curY, cnt;
        tie(curX, curY, cnt) = Q.front(); Q.pop();

        if (curX == H - 1 && curY == W - 1) {
            cout << dist[H - 1][W - 1][cnt];
            return 0;
        }
        for (int dir = 0; dir < 4; dir++) {
            int nx = dx[dir] + curX;
            int ny = dy[dir] + curY;
            if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
            if (dist[nx][ny][cnt] >= 0 || board[nx][ny] == 1) continue;
            dist[nx][ny][cnt] = dist[curX][curY][cnt] + 1;
            Q.push({nx, ny, cnt});
        }

        for (int dir = 4; dir < 12; dir++) {
            int nx = dx[dir] + curX;
            int ny = dy[dir] + curY;
            if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
            if (cnt + 1 > K) continue;
            if (dist[nx][ny][cnt + 1] >= 0 || board[nx][ny] == 1) continue;
            dist[nx][ny][cnt + 1] = dist[curX][curY][cnt] + 1;
            Q.push({nx, ny, cnt + 1});
        }
    }
    cout << -1;
}