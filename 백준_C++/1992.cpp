#include<bits/stdc++.h>
using namespace std;

int N;
string board[65];

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
        cout << board[x][y];
        return;
    }
    int half = n / 2;
    cout << "(";
    func(x, y, half);
    func(x, y + half, half);
    func(x + half, y, half);
    func(x + half, y + half, half);
    cout << ")";
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++) cin >> board[i];
    func(0, 0, N);
}