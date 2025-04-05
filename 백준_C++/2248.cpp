#include<bits/stdc++.h>
using namespace std;

char board[4000][8000];

void fill_star(int x, int y) {
    board[x][y] = '*';
    board[x + 1][y - 1] = '*';
    board[x + 1][y + 1] = '*';
    for (int i = y - 2; i <= y + 2; i++) board[x + 2][i] = '*';
}

void func(int x, int y, int s) {
    if (s == 3) {
        fill_star(x, y);
        return;
    }

    int ns = s / 2;
    func(x, y, ns);
    func(x + ns, y - ns, ns);
    func(x + ns, y + ns, ns);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N; 
    cin >> N;
    func(0, N - 1, N);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < 2 * N - 1; j++) {
            if (board[i][j] == '*')
                cout << '*';
            else 
                cout << ' ';
        }
        cout << '\n';
    }
}