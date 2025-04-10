#include<bits/stdc++.h>
using namespace std;

int L, C;
char arr[15], ans[15];
void func(int k, int start, int a, int b) {
    if (k == L) {
        if (a >= 1 && b >= 2) {
            for (int i = 0; i < L; i++) cout << ans[i];
            cout << '\n';
        }
        return;
    }

    for (int i = start; i < C; i++) {
        ans[k] = arr[i];
        if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') 
            func(k + 1, i + 1, a + 1, b);
        else func(k + 1, i + 1, a, b + 1);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> L >> C;
    for (int i = 0; i < C; i++) cin >> arr[i];
    sort(arr, arr + C);
    func(0, 0, 0, 0);
}