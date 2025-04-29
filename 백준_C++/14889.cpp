#include <bits/stdc++.h>
using namespace std;

int n;
int a[25][25];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) cin >> a[i][j];

    vector<int> team(n);
    fill(team.begin() + n / 2, team.end(), 1);
    int ans = INT_MAX;
    do {
        int diff = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (team[i] != team[j]) continue;
                if (team[i] == 0) diff += (a[i][j] + a[j][i]);
                else diff -= (a[i][j] + a[j][i]);
            }
        }
        ans = min(ans, abs(diff));
    } while (next_permutation(team.begin(), team.end()));
    cout << ans;
}