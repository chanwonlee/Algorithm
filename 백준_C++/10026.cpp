#include<bits/stdc++.h>
using namespace std;

int N;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int vis1[101][101], vis2[101][101];
string board[101];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for(int i = 0; i < N; i++) 
        cin >> board[i];
    
    int ans1 = 0;
    int ans2 = 0;
    queue<pair<int, int>> Q;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (vis1[i][j] == 1) continue;
            Q.push({i, j});
            vis1[i][j] = 1;
            char cur_color = board[i][j];
            ans1++;
            while(!Q.empty()) {
                auto cur = Q.front(); Q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = dx[dir] + cur.first;
                    int ny = dy[dir] + cur.second;
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (vis1[nx][ny] == 1 || board[nx][ny] != cur_color) continue;
                    vis1[nx][ny] = 1;
                    Q.push({nx, ny});
                }
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (vis2[i][j] == 1) continue;
            Q.push({i, j});
            vis2[i][j] = 1;
            char cur_color = board[i][j];
            ans2++;
            while(!Q.empty()) {
                auto cur = Q.front(); Q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = dx[dir] + cur.first;
                    int ny = dy[dir] + cur.second;
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (vis2[nx][ny] == 1) continue;
                    if (cur_color == 'B') {
                        if (board[nx][ny] != 'B') continue;
                    } else {
                        if (board[nx][ny] == 'B') continue;
                    }
                    vis2[nx][ny] = 1;
                    Q.push({nx, ny});
                }
            }
        }
    }
    cout << ans1 << " " << ans2;
}