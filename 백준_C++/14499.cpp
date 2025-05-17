#include <bits/stdc++.h>
using namespace std;

int N, M, x, y, K, board[21][21];
int dice_left, dice_right;
int dice[4];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> x >> y >> K;
    for (int i = 0; i < N; ++i)
        for (int j = 0; j < M; ++j)
            cin >> board[i][j];

    while (K--) {
        int op; cin >> op;

        if (op == 4) {
            if (x == N - 1) continue;
            ++x;
            int tmp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[3];
            dice[3] = tmp;
            if (board[x][y] == 0) board[x][y] = dice[2];
            else {
                dice[2] = board[x][y];
                board[x][y] = 0;
            }
        }

        if (op == 3) {
            if (x == 0) continue;
            --x;
            int tmp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[2];
            dice[2] = dice[1];
            dice[1] = tmp;
            if (board[x][y] == 0) board[x][y] = dice[2];
            else { 
                dice[2] = board[x][y]; 
                board[x][y] = 0; 
            }
        }

        if (op == 2) {
            if (y == 0) continue;
            --y;
            int tmp = dice[0];
            dice[0]   = dice_right;
            dice_right = dice[2];
            dice[2]   = dice_left;
            dice_left = tmp;
            if (board[x][y] == 0) board[x][y] = dice[2];
            else {
                dice[2] = board[x][y];
                board[x][y] = 0;
            }
        }

        if (op == 1) {
            if (y == M - 1) continue;
            ++y;
            int tmp = dice[0];
            dice[0]   = dice_left;
            dice_left = dice[2];
            dice[2]   = dice_right;
            dice_right = tmp;
            if (board[x][y] == 0) board[x][y] = dice[2];
            else {
                dice[2] = board[x][y];
                board[x][y] = 0;
            }
        }
        cout << dice[0] << '\n';
    }
}