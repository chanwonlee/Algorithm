#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;
    int M;
    cin >> M;
    list<char> list(s.begin(), s.end());
    auto cursor = list.end();

    while (M--) {
        char op;
        cin >> op;
        if (op == 'L') {
            if (cursor != list.begin()) cursor--;
        }

        if (op == 'D') {
            if (cursor != list.end()) cursor++;
        }

        if (op == 'B') {
            if (cursor != list.begin()) {
                cursor--;
                cursor = list.erase(cursor);
            }
        }

        if (op == 'P') {
            char c;
            cin >> c;
            list.insert(cursor, c);
        }
    }

    for (char c : list) cout << c;
}