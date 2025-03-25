#include <bits/stdc++.h>
using namespace std;

int N, dist[301][301];
int dx[8] = {2, 2, 1, 1, -2, -2, -1, -1};
int dy[8] = {1, -1, 2, -2, 1, -1, 2, -2};
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int T;
    cin >> T;

    while(T--) {
        cin >> N;
        pair<int, int> start;
        pair<int, int> end;
        cin >> start.first >> start.second;
        cin >> end.first >> end.second;
        for (int i = 0; i < N; i++) fill(dist[i], dist[i] + N, -1);
        queue<pair<int, int>> Q;
        Q.push({start});
        dist[start.first][start.second] = 0;
        while (!Q.empty()) {
            auto cur = Q.front(); Q.pop();
            if (cur.first == end.first && cur.second == end.second) {
                cout << dist[cur.first][cur.second] << "\n";
                break;
            } 
            for (int dir = 0; dir < 8; dir++) {
                int nx = dx[dir] + cur.first;
                int ny = dy[dir] + cur.second;
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[cur.first][cur.second] + 1;
                Q.push({nx, ny});
            }
        }
    }
}