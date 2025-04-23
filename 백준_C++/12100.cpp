#include <bits/stdc++.h>
using namespace std;

int N, mx, board[21][21];

void get_max() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            mx = max(mx, board[i][j]);
        }
    }
}

void move_up() {
    for (int i = 0; i < N; i++) {
        vector<int> tmp;
        for (int j = 0; j < N; j++) {
            if (board[j][i] == 0) continue;
            else tmp.push_back(board[j][i]);
        }

        vector<int> result;
        for (int j = 0; j < tmp.size(); j++) {
            if (j + 1 < tmp.size() && tmp[j] == tmp[j + 1]) {
                result.push_back(tmp[j] * 2);
                j++;
            } else result.push_back(tmp[j]);
        }

        for (int j = 0; j < N; j++) {
            board[j][i] = 0;
        }

        for (int j = 0; j < result.size(); j++) {
            board[j][i] = result[j];
        }
    }
}

void move_down() {
    for (int i = 0; i < N; i++) {
        vector<int> tmp;
        for (int j = N - 1; j >= 0; j--) {
            if (board[j][i] == 0) continue;
            else tmp.push_back(board[j][i]);
        }

        vector<int> result;
        for (int j = 0; j < tmp.size(); j++) {
            if (j + 1 < tmp.size() && tmp[j] == tmp[j + 1]) {
                result.push_back(tmp[j] * 2);
                j++;
            } else result.push_back(tmp[j]);
        }

        for (int j = 0; j < N; j++) {
            board[j][i] = 0;
        }

        for (int j = 0; j < result.size(); j++) {
            board[N - j - 1][i] = result[j];
        }
    }
}

void move_left() {
    for (int i = 0; i < N; i++) {
        vector<int> tmp;
        for (int j = 0; j < N; j++) {
            if (board[i][j] == 0) continue;
            else tmp.push_back(board[i][j]);
        }

        vector<int> result;
        for (int j = 0; j < tmp.size(); j++) {
            if (j + 1 < tmp.size() && tmp[j] == tmp[j + 1]) {
                result.push_back(tmp[j] * 2);
                j++;
            } else result.push_back(tmp[j]);
        }

        for (int j = 0; j < N; j++) {
            board[i][j] = 0;
        }

        for (int j = 0; j < result.size(); j++) {
            board[i][j] = result[j];
        }
    }
}

void move_right() {
    for (int i = 0; i < N; i++) {
        vector<int> tmp;
        for (int j = N - 1; j >= 0; j--) {
            if (board[i][j] == 0) continue;
            else tmp.push_back(board[i][j]);
        }

        vector<int> result;
        for (int j = 0; j < tmp.size(); j++) {
            if (j + 1 < tmp.size() && tmp[j] == tmp[j + 1]) {
                result.push_back(tmp[j] * 2);
                j++;
            } else result.push_back(tmp[j]);
        }

        for (int j = 0; j < N; j++) {
            board[i][j] = 0;
        }

        for (int j = 0; j < result.size(); j++) {
            board[i][N - j - 1] = result[j];
        }
    }
}

void game(int n) {
    if (n == 5) {
        get_max();
        return;
    }
    int backup[21][21];
    memcpy(backup, board, sizeof(board));

    void (*moves[]) () = { move_up, move_down, move_left, move_right };
    for (auto mv : moves) {
        mv();
        game(n + 1);
        memcpy(board, backup, sizeof(board));
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) 
        for (int j = 0; j < N; j++) cin >> board[i][j];

    game(0);
    cout << mx;
}