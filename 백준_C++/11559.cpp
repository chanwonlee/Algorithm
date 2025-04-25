#include <bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
bool vis[13][7];
string board[13];

void down() {
    for (int i = 0; i < 6; i++) {
        vector<char> tmp;
        for (int j = 11; j >=0; j--) {
            if (board[j][i] != '.') {
                tmp.push_back(board[j][i]);
                board[j][i] = '.';
            }
        }
        for (int j = 0; j < tmp.size(); j++) board[11 - j][i] = tmp[j];
    }
}

bool check() {
    bool flag = false;
    queue<pair<int, int>> Q;
    for (int i = 0; i < 12; i++) fill(vis[i], vis[i] + 6, false);
    for (int i = 0; i < 12; i++) {
        for (int j = 0; j < 6; j++) {
            vector<pair<int, int>> tmp;
            if (vis[i][j] || board[i][j] == '.') continue;
            vis[i][j] = true;
            Q.push({i, j});
            tmp.push_back({i, j});
            while(!Q.empty()) {
                auto cur = Q.front(); Q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];

                    if (nx < 0 || ny >= 12 || ny < 0 || ny >= 6) continue;
                    if (vis[nx][ny] || board[cur.first][cur.second] != board[nx][ny]) continue;
                    Q.push({nx, ny});
                    tmp.push_back({nx, ny});
                    vis[nx][ny] = true;
                }
            }
            
            if (tmp.size() >= 4) {
                for (int k = 0; k < tmp.size(); k++) {
                    auto cur = tmp[k];
                    board[cur.first][cur.second] = '.';
                }
                flag = true;
            }
        }
    }
    return flag;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 12; i++) {
        cin >> board[i];
    }
    int ans = 0;
    while (check()) {
        ans++;
        down();
    }
    cout << ans;
}