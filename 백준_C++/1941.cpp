#include<bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int ans;
bool mask[25];
string board[5];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    for (int i = 0; i < 5; i++) cin >> board[i];
    fill(mask + 7, mask + 25, true);
    do {
        queue<pair<int, int>> q;
        int s = 0, adj = 0;
        bool select[5][5] = {}, vis[5][5] = {};
        for (int i = 0; i < 25; i++) {
            if (!mask[i]) {
                int x = i / 5, y = i % 5;
                select[x][y] = true;
                if (q.empty()) {
                    q.push({x, y});
                    vis[x][y] = true;
                }
            }
        }
        while (!q.empty()) {
            auto cur = q.front(); q.pop();
            adj++;
            s += board[cur.first][cur.second] == 'S';
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.first + dx[dir];
                int ny = cur.second + dy[dir];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (vis[nx][ny] || !select[nx][ny]) continue;
                q.push({nx, ny});
                vis[nx][ny] = true;
            }
        }
        ans += (adj >= 7 && s >= 4);
    } while (next_permutation(mask, mask + 25));
    cout << ans;
}