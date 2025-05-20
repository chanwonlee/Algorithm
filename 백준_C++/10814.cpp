#include <bits/stdc++.h>
using namespace std;

int N;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;

    vector<pair<int, string>> x(N);
    for (auto& s : x) cin >> s.first >> s.second;

    stable_sort(x.begin(), x.end(), [](pair<int, string> a, pair<int, string> b) {
        return a.first < b.first;
    });

    for (auto p : x) cout << p.first << ' ' << p.second << '\n';
}