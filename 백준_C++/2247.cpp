#include<bits/stdc++.h>
using namespace std;

char board[2200][2200];
void func(int x, int y, int n) {
    if (n == 1) {
        board[x][y] = '*';
        return;
    }
    
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++) {
            if (i == 1 && j == 1) continue;
            func(x + n / 3 * i, y + n / 3 * j, n / 3);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N; 
    cin >> N;
    for (int i = 0; i < N; i++) fill(board[i], board[i] + N, ' ');
    func(0, 0, N);
    for (int i = 0; i < N; i++) cout << board[i] << '\n';
}