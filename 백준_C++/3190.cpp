#include <bits/stdc++.h>
using namespace std;

int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int N, K, L, X, board[102][102], ans;
char C;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 0; i < K; i++) {
        int x, y;
        cin >> x >> y;
        board[x][y] = 1;
    }
    
    cin >> L;
    map<int, char> info;
    for (int i = 0; i < L; i++) {
        int x;
        char c;
        cin >> x >> c;
        info.insert({x, c});
    }
    
    deque<pair<int, int>> snake;
    snake.push_front({1, 1});
    board[1][1] = 2;
    int dir = 0;
    while (true) {
        ans++;
        auto cur = snake.front();
        int nx = cur.first + dx[dir];
        int ny = cur.second + dy[dir];
        if (nx <= 0 || nx > N || ny <= 0 || ny > N) break;
        if (board[nx][ny] == 2) break;
        if (board[nx][ny] == 0) {
            board[snake.back().first][snake.back().second] = 0;
            snake.pop_back();
        }
        snake.push_front({nx, ny});
        board[nx][ny] = 2;
        if (info[ans] == 'D') dir = (dir + 1) % 4;
        if (info[ans] == 'L') dir = (dir + 3) % 4;
    }
    cout << ans;
}