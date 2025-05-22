#include <bits/stdc++.h>
using namespace std;

int N;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<long long> arr;
    cin >> N;
    for (int i = 0; i < N; i++) {
        string str;
        cin >> str;
        reverse(str.begin(), str.end());
        arr.push_back(stoll(str));
    }
    sort(arr.begin(), arr.end());
    for (auto i : arr) cout << i << '\n';
}