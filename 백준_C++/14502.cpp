#include <bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int N, M, origin_board[10][10], board[10][10], vis[10][10], ans;
vector<pair<int, int>> blank, virus;
void reset() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            board[i][j] = origin_board[i][j];
            vis[i][j] = 0;
        }
    }
}

int bfs() {
    queue<pair<int, int>> q;
    for (int i = 0; i < virus.size(); i++) {
        q.push({virus[i].first, virus[i].second});
        vis[virus[i].first][virus[i].second] = 1;
    }

    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (vis[nx][ny] == 1 || board[nx][ny] != 0) continue;
            q.push({nx, ny});
            vis[nx][ny] = 1;
        }
    }

    int result = 0;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            if (board[i][j] == 0 && vis[i][j] == 0) result++;
    return result;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> origin_board[i][j];
            if (origin_board[i][j] == 0) blank.push_back({i, j});
            if (origin_board[i][j] == 2) virus.push_back({i, j});
        }
    }
        
    vector<int> brute(blank.size());
    fill(brute.begin() + 3, brute.end(), 1);
    do {
        reset();
        for (int i = 0; i < brute.size(); i++) {
            if (brute[i] == 0) {
                board[blank[i].first][blank[i].second] = 1;
            }
        }
        ans = max(ans, bfs());
    } while(next_permutation(brute.begin(), brute.end()));
    cout << ans;
}