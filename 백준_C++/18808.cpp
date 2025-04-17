#include<bits/stdc++.h>
using namespace std;

int N, M, K, R, C, board[41][41], sticker[11][11];

bool check(int startX, int startY) {
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (sticker[i][j] == 1) {
                if (board[i + startX][j + startY] == 1) return false;
            }
        }
    }
    return true;
}

bool attach() {
    for (int i = 0; i <= N - R; i++) {
        for (int j = 0; j <= M - C; j++) {
            if (check(i, j)) {
                for (int k = 0; k < R; k++) {
                    for (int l = 0; l < C; l++) {
                        if (sticker[k][l] == 1) board[i + k][j + l] = 1;
                    }
                }
                return true;
            }
        }
    }
    return false;
}

void rotate() {
    int rotate[11][11];
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            rotate[j][R - 1 - i] = sticker[i][j];
        }
    }
    swap(R, C);
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            sticker[i][j] = rotate[i][j];
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;

    while(K--) {
        cin >> R >> C;
        for (int i = 0; i < R; i++) 
            for (int j = 0; j < C; j++) cin >> sticker[i][j];

        int t = 0;
        while(t < 4) {
            if (attach()) break;
            rotate();
            t++;
        }
    }

    int ans = 0;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++) if (board[i][j] == 1) ans++;
    cout << ans;
}