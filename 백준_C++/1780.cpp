#include<bits/stdc++.h>
using namespace std;

int N, ans[3], board[2200][2200];

bool check(int x, int y, int k) {
    for (int i = x; i < x + k; i++) {
        for (int j = y; j < y + k; j++) {
            if (board[i][j] != board[x][y]) return false;
        }
    }
    return true;
}

void solve(int x, int y, int k) {
    if (check(x, y, k)) {
        ans[board[x][y] + 1]++;
        return;
    } 
    int nk = k/3;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            solve(x + i * nk, y + j * nk, nk);
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> board[i][j];

    solve(0, 0, N);
    for(auto i : ans) cout << i << "\n";
}