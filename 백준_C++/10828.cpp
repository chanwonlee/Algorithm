#include <bits/stdc++.h>
using namespace std;

int d[10001];
int pos = 0;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;

    for (int i =0; i < N; i++) {
        string command;
        cin >> command;

        if (command == "push") {
            int n;
            cin >> n;
            d[++pos] = n;
        }
        
        if (command == "pop") {
            if (pos == 0) cout << -1 << "\n";
            else {
                cout << d[pos] << "\n";
                pos--;
            }
        }

        if (command == "size") {
            cout << pos << "\n";
        }

        if (command == "empty") {
            if (pos == 0) cout << 1 << "\n";
            else cout << 0 << "\n";
        }

        if (command == "top") {
            if (pos == 0) cout << -1 << "\n";
            else cout << d[pos] << "\n";
        }
    }
}