#include <bits/stdc++.h>
using namespace std;

int N, board[501][501];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    cin >> board[0][0];

    for (int i = 1; i < N; i++) {
        for (int j = 0; j < i + 1; j++) {
            cin >> board[i][j];
        }

        for (int j = 0; j < i + 1; j++) {
            if (j == 0) board[i][j] += board[i - 1][j];
            else if (j == N - 1) board[i][j] += board[i - 1][j - 1];
            else board[i][j] += max(board[i - 1][j - 1], board[i - 1][j]);
        }
    }
    cout << *max_element(board[N - 1], board[N - 1] + N);
}