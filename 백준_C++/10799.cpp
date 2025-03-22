#include<bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string a;
    cin >> a;

    int ans = 0;
    int plate = 0;
    stack<char> s;
    char before = '(';
    for (char ch : a) {
        if (ch == ')') {
            plate--;
            if (before == '(') {
                ans += plate;
            } else ans++;
            s.pop();
        } else {
            s.push(ch);
            plate++;
        } 
        before = ch;
    }
    cout << ans;
}