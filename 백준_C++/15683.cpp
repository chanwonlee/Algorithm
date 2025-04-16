#include<bits/stdc++.h>
using namespace std;

// 0: U, 1: R, 2: D, 3: L
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int N, M, board[10][10], ans = INT_MAX;
vector<pair<int, int>> cctv;

int count_area() {
    int count = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (board[i][j] == 0) count++;
        }
    }
    return count;
}

void go(int x, int y, int dir, int change) {
    for (int i = 1; i <= 8; i++) {
        int nx = x + dx[dir] * i;
        int ny = y + dy[dir] * i;
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
        if (board[nx][ny] == 6) break;
        if (board[nx][ny] >= 1 && board[nx][ny] <= 6) continue;
        board[nx][ny] = change;
    }
}

void solve(int n) {
    if (n == cctv.size()) {
        ans = min(ans, count_area());
        return;
    }

    auto cur = cctv[n];
    int prev_board[10][10];

    for (int k = 0; k < N; k++) 
        for (int l = 0; l < M; l++) prev_board[k][l] = board[k][l];

    if (board[cur.first][cur.second] == 1) {
        for (int j = 0; j < 4; j++) {
            go(cur.first, cur.second, j, 7);
            solve(n + 1);
            for (int k = 0; k < N; k++) 
                for (int l = 0; l < M; l++) board[k][l] = prev_board[k][l];
        }
    }

    if (board[cur.first][cur.second] == 2) {
        for (int j = 0; j < 2; j++) {
            go(cur.first, cur.second, j, 7);
            go(cur.first, cur.second, j + 2, 7);
            solve(n + 1);
            for (int k = 0; k < N; k++) 
                for (int l = 0; l < M; l++) board[k][l] = prev_board[k][l];
        }
    }

    if (board[cur.first][cur.second] == 3) {
        for (int j = 0; j < 4; j++) {
            go(cur.first, cur.second, j, 7);
            go(cur.first, cur.second, (j + 1) % 4, 7);
            solve(n + 1);
            for (int k = 0; k < N; k++) 
                for (int l = 0; l < M; l++) board[k][l] = prev_board[k][l];
        }
    }

    if (board[cur.first][cur.second] == 4) {
        for (int j = 0; j < 4; j++) {
            go(cur.first, cur.second, j, 7);
            go(cur.first, cur.second, (j + 1) % 4, 7);
            go(cur.first, cur.second, (j + 2) % 4, 7);
            solve(n + 1);
            for (int k = 0; k < N; k++) 
                for (int l = 0; l < M; l++) board[k][l] = prev_board[k][l];
        }
    }

    if (board[cur.first][cur.second] == 5) {
        go(cur.first, cur.second, 0, 7);
        go(cur.first, cur.second, 1, 7);
        go(cur.first, cur.second, 2, 7);
        go(cur.first, cur.second, 3, 7);
        solve(n + 1);
        for (int k = 0; k < N; k++) 
            for (int l = 0; l < M; l++) board[k][l] = prev_board[k][l];
    }
    
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> board[i][j];
            if (board[i][j] >= 1 && board[i][j] <= 5) cctv.push_back({i, j});
        }
    }
    solve(0);
    cout << ans;
}
