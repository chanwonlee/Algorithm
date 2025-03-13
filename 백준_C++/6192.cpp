#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    stack<int> s;
    long long ans = 0;

    while(n--) {
        long long h;
        cin >> h;
        while(!s.empty() && s.top() <= h) s.pop();
        ans += s.size();
        s.push(h);
    }
    cout << ans;
}