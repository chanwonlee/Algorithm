#include <bits/stdc++.h>
using namespace std;

int M, N, K, board[101][101], vis[101][101];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
vector<int> ans;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> M >> N >> K;
    while(K--){
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        for (int i = y1; i < y2; i++)
            for (int j = x1; j < x2; j++) board[i][j] = 1;
    }

    int count = 0;
    for(int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            if (board[i][j] == 1 || vis[i][j] == 1) continue;
            count++;
            queue<pair<int, int>> Q;
            vis[i][j] = 1;
            int area = 1;
            Q.push({i, j});
            while(!Q.empty()) {
                auto cur = Q.front(); Q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = dx[dir] + cur.first;
                    int ny = dy[dir] + cur.second;
                    if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                    if (vis[nx][ny] == 1 || board[nx][ny] == 1) continue;
                    area++;
                    vis[nx][ny] = 1;
                    Q.push({nx, ny});
                }
            }
            ans.push_back(area);
        }
    }
    cout << count << "\n";
    sort(ans.begin(), ans.end());
    for(auto i : ans) cout << i << " ";
}