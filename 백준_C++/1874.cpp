#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;
    int cnt = 1;
    stack<int> stack;
    string ans;
    while(N--) {
        int n;
        cin >> n;
        while(cnt <= n) {
            stack.push(cnt++);
            ans += "+\n";
        }

        if (stack.top() != n) {
            cout << "NO\n";
            return 0;
        }

        stack.pop();
        ans += "-\n";
    }
    cout << ans;
}