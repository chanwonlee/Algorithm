#include <bits/stdc++.h>
using namespace std;

int N;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    vector<pair<int, int>> x(N);
    for (auto& p : x) cin >> p.second >> p.first;
    sort(x.begin(), x.end());
    for (auto p : x) cout << p.second << ' ' << p.first << '\n';
}