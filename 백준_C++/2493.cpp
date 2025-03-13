#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;
    stack<pair<int, int>> s;
    vector<int> ans;
    s.push(pair(100000001, 0));
    
    for (int i = 1; i <= N; i++) {
        int t;
        cin >> t;

        while (s.top().first < t) s.pop();
        cout << s.top().second << " ";
        s.push({t, i});
    }
}