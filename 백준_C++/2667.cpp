#include<bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int N, vis[26][26];
string board[26];
vector<int> ans;
int main() {
    ios:: sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for(int i = 0; i < N; i++) cin >> board[i];
    
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (board[i][j] == '0' || vis[i][j] == 1) continue;
            queue<pair<int, int>> Q;
            Q.push({i, j});
            vis[i][j] = 1;
            int area = 1;
            while(!Q.empty()) {
                auto cur = Q.front(); Q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = dx[dir] + cur.first;
                    int ny = dy[dir] + cur.second;
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (board[nx][ny] == '0'|| vis[nx][ny] == 1) continue;
                    vis[nx][ny] = 1;
                    Q.push({nx, ny});
                    area++;
                }
            }
            ans.push_back(area);
        }
    }
    sort(ans.begin(), ans.end());
    cout << ans.size() << "\n";
    for (auto i : ans) cout << i << "\n";
}