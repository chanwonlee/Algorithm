#include<bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int T;
    cin >> T;

    while(T--) {
        string p;
        int n;
        string x;
        cin >> p >> n >> x;
    
        deque<int> d;
        int cur = 0;
        for (int i = 1; i < x.size() - 1; i++) {
            if (x[i] == ',') {
                d.push_back(cur);
                cur = 0;
            } else {
                cur = 10 * cur + (x[i] - '0');
            }
        }
        if (cur != 0) d.push_back(cur);
        

        bool front = true;
        bool error = false;
        for (char c : p) {
            if (c == 'R') front = !front;
            else {
                if (d.empty()) {
                    error = !error;
                    break;
                }
                if (front) d.pop_front();
                else d.pop_back();
            }
        }

        if (error) {
            cout << "error\n";
            continue;  
        } else {
            cout << "[";
            if (front) {
                for (int i = 0; i < d.size(); i++) {
                    cout << d[i];

                    if (i != d.size() - 1) {
                        cout << ",";
                    }
                }
            } else {
                for (int i = d.size() - 1; i >= 0; i--) {
                    cout << d[i];

                    if (i != 0) {
                        cout << ",";
                    }
                }
            }
            cout << "]\n";
        }
    }
}