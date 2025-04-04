#include<bits/stdc++.h>
using namespace std;

int N, board[129][129], ans[2];

bool check(int x, int y, int n) {
    for (int i = x; i < x + n; i++) {
        for (int j = y; j < y + n; j++) {
            if (board[x][y] != board[i][j]) return false;
        }
    }
    return true;
}

void func(int x, int y, int n) {
    if (check(x, y, n)) {
        ans[board[x][y]]++;
        return;
    }
    int half = n / 2;
    func(x, y, half);
    func(x + half, y, half);
    func(x, y + half, half);
    func(x + half, y + half, half);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> board[i][j];

    func(0, 0, N);
    for (auto i : ans) cout << i << "\n";
}