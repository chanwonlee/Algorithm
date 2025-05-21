#include <bits/stdc++.h>
using namespace std;

int get_sum(const string& s) {
    int sum = 0;
    for (char c : s) {
        if (isdigit(c)) sum += c - '0';
    }
    return sum;
}

int N;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    vector<string> serials(N);
    for (int i = 0; i < N; i++) cin >> serials[i];
    sort(serials.begin(), serials.end(), [](auto a, auto b) {
        if (a.length() != b.length()) return a.length() < b.length();
        int sum1 = get_sum(a);
        int sum2 = get_sum(b);
        if (sum1 != sum2) return sum1 < sum2;
        return a < b;
    });
    for (auto s : serials) cout << s << '\n';
}