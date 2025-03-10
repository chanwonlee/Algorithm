#include <bits/stdc++.h>
using namespace std;

int a[2][26], ans;
int main() {
    string s1, s2;
    cin >> s1 >> s2;
    for (auto c : s1) a[0][c - 'a']++;
    for (auto c : s2) a[1][c - 'a']++;

    for (int i =0; i < 26; i ++) {
        ans += abs(a[0][i] - a[1][i]);
    }

    cout << ans;
}