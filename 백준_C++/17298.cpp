#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int N;
    cin >> N;
    stack<pair<int, int>> s;
    vector<int> ans(N, -1);

    for(int i = 0; i < N; i ++) {
        int a;
        cin >> a;

        while(!s.empty() && s.top().first < a) {
            ans[s.top().second] = a;
            s.pop();
        }

        s.push({a, i});
    }
    for (auto i : ans) cout << i << " ";
}