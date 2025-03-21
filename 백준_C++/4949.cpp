#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    while(true) {
        string a;
        getline(cin, a);
        stack<char> s;

        if (a == ".") {
            return 0;
        }

        bool isValid = true;
        for (auto ch : a) {
            if (ch == '[' or ch == '(') s.push(ch);
            if (ch == ']') {
                if (s.empty() || s.top() != '[') {
                    isValid = false;
                    break;
                }
                s.pop();
            }
            if (ch == ')') {
                if (s.empty() || s.top() != '(') {
                    isValid = false;
                    break;
                }
                s.pop();
            }
        }
        if (!s.empty()) isValid = false;
        if (isValid) cout << "yes\n";
        else cout << "no\n";
    }
}