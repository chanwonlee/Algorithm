#include <bits/stdc++.h>
using namespace std;

int N;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    vector<string> arr(N);
    for (int i = 0; i < N; i++) cin >> arr[i];
    sort(arr.begin(), arr.end(), [](const string& a, const string& b) {
        int al = a.length();
        int bl = b.length();
        if (al != bl) return al < bl;
        return a < b;
    });
    arr.erase(unique(arr.begin(), arr.end()), arr.end());
    for(string& s : arr) cout << s << '\n';
}