#include<bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;
    int ans = 0;

    while(N--) {
        string a;
        cin >> a;
        stack<char> s;
        for(auto ch : a){
            if (!s.empty() && s.top() == ch) s.pop();
            else s.push(ch);
        }
        if (s.empty()) ans++;
    }
    cout << ans;
}