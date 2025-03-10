#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;

    for (int i=0; i<N; i++) {
        string str1, str2;
        cin >> str1 >> str2;
        
        int a[26] = {0};
        for (auto c : str1) a[c - 'a']++;
        for (auto c : str2) a[c - 'a']--;
        
        bool isPossible = true;
        for (int i : a) if (i != 0) isPossible = false;

        if (isPossible) cout << "Possible\n";
        else cout << "Impossible\n";
    }
}