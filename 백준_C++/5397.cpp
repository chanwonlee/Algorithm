#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        list<char> L;
        auto cursor = L.begin();
        
        for (auto c : s) {
            if (c == '<') {
                if (cursor != L.begin()) {
                    cursor--;
                }
            }
            else if (c == '>') {
                if (cursor != L.end()) {
                    cursor++;
                }
            }
            else if (c == '-') {
                if (cursor != L.begin()) {
                    auto temp = cursor;
                    temp--;
                    cursor = L.erase(temp);
                }
            }
            else {
                L.insert(cursor, c);
            }
        }
        
        for (auto c : L) cout << c;
        cout << '\n';
    }
}