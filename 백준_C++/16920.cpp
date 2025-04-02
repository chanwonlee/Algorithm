#include <bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int N, M, P, S[10], area[10], vis[1001][1001];
string board[1001];
queue<tuple<int, int, int>> Q[10];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> P;
    for (int i = 1; i <= P; i++) cin >> S[i];
    for (int i = 0; i < N; i++) cin >> board[i];
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (board[i][j] - '0' < 1 || board[i][j] - '0' >= 10) continue;
            area[board[i][j] - '0']++;
            Q[board[i][j] - '0'].push({i, j, 0});
        }
    }

    while(1) {
        bool isExtend = 0;
        for (int i = 1; i <= P; i++) {
            queue<tuple<int, int, int>> nextQ;
            while (!Q[i].empty()) {
                int curx, cury, curstep;
                tie(curx, cury, curstep) = Q[i].front(); Q[i].pop();
                if (curstep >= S[i]) {
                    nextQ.push({curx, cury, 0});
                    continue;
                }
                for (int dir = 0; dir < 4; dir++) {
                    int x = curx + dx[dir];
                    int y = cury + dy[dir];
                    if (x < 0 || x >= N || y < 0 || y >= M) continue;
                    if (board[x][y] != '.') continue;
                    Q[i].push({x, y, curstep + 1});
                    board[x][y] = i + '0';
                    area[i]++;
                    isExtend = 1;
                }
            }
            Q[i] = nextQ;
        }
        if (!isExtend) break;
    }
    for(int i=1; i<=P; i++)
        cout << area[i] << " ";
}