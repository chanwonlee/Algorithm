#include<bits/stdc++.h>
using namespace std;

int N, s, e;
int q[2000005];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    while(N--) {
        string command;
        cin >> command;
        if (command == "push") cin >> q[s++];

        if (command == "pop") cout << (e == s ? -1 : q[e++]) << "\n"; 

        if (command == "size") cout << s - e << "\n";

        if (command == "empty") cout << (e == s ? 1 : 0) << "\n";

        if (command == "front") cout << (e == s ? -1 : q[e]) << "\n";

        if (command == "back") cout << (e == s ? -1 : q[s - 1]) << "\n";
    }
}