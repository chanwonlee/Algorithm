#include <bits/stdc++.h>
using namespace std;

string gear[5];
int top[5];
int rotation[5]; // 0: 회전X, 1: 시계, -1: 반시계

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 1; i <= 4; i++) {
        cin >> gear[i];
        top[i] = 0;
    }

    int k;
    cin >> k;
    while (k--) {
        int n, dir;
        cin >> n >> dir;
        fill(rotation, rotation + 5, 0);
        rotation[n] = dir;

        for (int i = n; i < 4; i++) {
            if (gear[i][(top[i] + 2) % 8] == gear[i + 1][(top[i + 1] + 6) % 8]) break;
            rotation[i + 1] = -rotation[i];
        }

        for (int i = n; i > 1; i--) {
            if (gear[i][(top[i] + 6) % 8] == gear[i - 1][(top[i - 1] + 2) % 8]) break;
            rotation[i - 1] = -rotation[i];
        }

        for (int i = 1; i <= 4; i++) {
            if (rotation[i]){
                int delta = (rotation[i] == 1) ? 7 : 1;
                top[i] = (top[i] + delta) % 8;
            }
        }
    }

    int ans = 0;
    for (int i = 1; i <= 4; i++) {
        if (gear[i][top[i]] == '1') {
            ans += (1 << (i - 1));
        }
    }
    cout << ans;
}