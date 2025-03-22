#include<bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string a;
    cin >> a;
    stack<pair<char, int>> s;
    s.push({' ', 0});
    for (char ch : a) {
        if (ch == '(' || ch == '[') s.push({ch, 0});
        else {
            if (ch == ')') {
                if (s.top().first != '(') {
                    cout << 0;
                    return 0;
                }
                int temp = (s.top().second == 0 ? 2 : s.top().second * 2);
                s.pop();
                if (s.empty()) {
                    cout << 0;
                    return 0;
                }
                s.top().second += temp;
            }

            if (ch == ']') {
                if (s.top().first != '[') {
                    cout << 0;
                    return 0;
                }
                int temp = (s.top().second == 0 ? 3 : s.top().second * 3);
                s.pop();
                if (s.empty()) {
                    cout << 0;
                    return 0;
                }
                s.top().second += temp;
            }
        }
    };
    if (s.top().first == ' ') cout << s.top().second;
    else cout << 0;
}