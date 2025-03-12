#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int K;
    cin >> K;

    stack<int> stack;
    while(K--) {
        int n;
        cin >> n;

        if(n == 0) stack.pop();
        else stack.push(n);
    }

    int ans = 0;
    while (!stack.empty()) {
        ans += stack.top();
        stack.pop();
    }
    cout << ans;
}