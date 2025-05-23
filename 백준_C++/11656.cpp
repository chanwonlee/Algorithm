#include <bits/stdc++.h>
using namespace std;

string str;
vector<string> arr;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> str;
    int l = str.length();
    for (int i = 0; i < l; i++) {
        string tmp = str.substr(i);
        arr.push_back(tmp);
    }
    sort(arr.begin(), arr.end());
    for (auto i : arr) cout << i << '\n';
}