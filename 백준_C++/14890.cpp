#include <bits/stdc++.h>
using namespace std;

int N, L, board[101][101], ans;
bool check[101][101];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> L;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> board[i][j];

    for (int i = 0; i < N; i++) {
        int prev = board[i][0];
        bool possible = true;
        for (int j = 1; j < N; j++) {
            if (abs(prev - board[i][j]) > 1) {
                possible = false;
                break;
            }

            if (prev > board[i][j]) {
                for (int k = 1; k <= L; k++) {
                    if (j + k - 1 > N || check[i][j + k - 1] || prev - 1 != board[i][j + k - 1]) {
                        possible = false;
                        break;
                    }
                    check[i][j + k - 1] = true;
                }
            }

            if (prev < board[i][j]) {
                for (int k = 1; k <= L; k++) {
                    if (j - k < 0 || check[i][j - k] || prev != board[i][j - k]) {
                        possible = false;
                        break;
                    }
                }
            }
            prev = board[i][j];
        }
        if (possible) ans++;
    }

    for (int i = 0; i < N; i++) fill(check[i], check[i] + N, false);

    for (int i = 0; i < N; i++) {
        int prev = board[0][i];
        bool possible = true;
        for (int j = 1; j < N; j++) {
            if (abs(prev - board[j][i]) > 1) {
                possible = false;
                break;
            }

            if (prev > board[j][i]) {
                for (int k = 1; k <= L; k++) {
                    if (j + k - 1 > N || check[j + k - 1][i] || prev - 1 != board[j + k - 1][i]) {
                        possible = false;
                        break;
                    }
                    check[j + k - 1][i] = true;
                }
            }

            if (prev < board[j][i]) {
                for (int k = 1; k <= L; k++) {
                    if (j - k < 0 || check[j - k][i] || prev != board[j - k][i]) {
                        possible = false;
                        break;
                    }
                }
            }
            prev = board[j][i];
        }
        if (possible) ans++;
    }
    cout << ans;
}