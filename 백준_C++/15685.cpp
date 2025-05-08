#include <bits/stdc++.h>
using namespace std;

bool board[101][101];
int k, x, y, d, g, ans;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> k;
    while(k--) {
        cin >> x >> y >> d >> g;
        
        vector<int> v;
        v.push_back(d);
        board[x][y] = 1;
        while(g--) {
            for (int i = v.size() - 1; i >= 0; i--) 
                v.push_back((v[i] + 1) % 4);
        }

        for (int i = 0; i < v.size(); i++) {
            if (v[i] == 0) x++;
            else if (v[i] == 1) y--;
            else if (v[i] == 2) x--;
            else if (v[i] == 3) y++;
            board[x][y] = 1;
        }
    }

    for(int i = 0; i < 100; i++){
        for(int j = 0; j < 100; j++){
            if(!board[i][j]) continue;
            if(board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) ans++;
        }
    }
    cout << ans;
}