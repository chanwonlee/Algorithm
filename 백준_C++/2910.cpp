#include <bits/stdc++.h>
using namespace std;

int N, C;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> C;
    vector<pair<int, int>> arr;
    for (int i = 0; i < N; i++) {
        int x;
        cin >> x;
        bool check = false;
        for (auto &a : arr) {
            if (a.second == x) {
                check = true;
                a.first++;
                break;
            }
        }
        if (!check) arr.push_back({1, x});
    }
    stable_sort(arr.begin(), arr.end(), [](auto a, auto b) {
        return a.first > b.first;
    });
    for (auto a : arr) 
        while (a.first--) cout << a.second << ' ';
}