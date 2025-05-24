#include <bits/stdc++.h>
using namespace std;

int N;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    vector<tuple<int, int, int, string>> arr;
    for (int i = 0; i < N; i++) {
        string name;
        int k, e, m;
        cin >> name >> k >> e >> m;
        arr.push_back({-k, e, -m, name});
    }
    sort(arr.begin(), arr.end());
    for (auto& s : arr) cout << get<3>(s) << '\n';
}