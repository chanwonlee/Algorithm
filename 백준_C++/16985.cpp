#include <bits/stdc++.h>
using namespace std;

int dx[6] = {0, 0, 1, -1, 0, 0};
int dy[6] = {1, -1, 0, 0, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};
int rawBoard[6][6][6], board[6][6][6], dist[6][6][6], ans;
void rotate(int n) {
    int temp[5][5][5];
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            temp[n][j][4 -i] = board[n][i][j];
        }
    }

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            board[n][i][j] = temp[n][i][j];
        }
    }
}

int bfs() {
    if (board[0][0][0] == 0) return 9999;

    for (int i = 0; i < 5; i++)
        for (int j = 0; j < 5; j++) fill(dist[i][j], dist[i][j] + 5, -1);

    queue<tuple<int, int, int>> q;
    q.push({0, 0, 0});
    dist[0][0][0] = 0;
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        int x, y, z;
        tie(z, x, y) = cur;
        
        if (z == 4 && x == 4 && y == 4) {
            if (dist[z][x][y] == -1) return 9999;
            else return dist[z][x][y];
        }

        for (int cur = 0; cur < 6; cur++) {
            int nx = x + dx[cur];
            int ny = y + dy[cur];
            int nz = z + dz[cur];
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5) continue;
            if (dist[nz][nx][ny] != -1 || board[nz][nx][ny] == 0) continue;
            dist[nz][nx][ny] = dist[z][x][y] + 1;
            q.push({nz, nx, ny});
        }
    }
    return 9999;
}

void solve(int n) {
    if (n == 5) {
        ans = min(ans, bfs());
        return;
    }

    for (int i = 0; i < 4; i++) {
        rotate(n);
        solve(n + 1);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 5; i++)
        for (int j = 0; j < 5; j++)
            for (int k = 0; k < 5; k++) cin >> rawBoard[i][j][k];

    ans = 9999;
    vector<int> order = {0,1,2,3,4};
    do {
        for (int z = 0; z < 5; z++)
            for (int x = 0; x < 5; x++)
                for (int y = 0; y < 5; y++)
                    board[z][x][y] = rawBoard[order[z]][x][y];
        solve(0);
    } while(next_permutation(order.begin(), order.end()));
    cout << (ans == 9999 ? -1 : ans);
}