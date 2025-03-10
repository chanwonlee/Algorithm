#include <bits/stdc++.h>
using namespace std;

int main(){
    int n, x;
    int answer = 0;
    
    cin >> n;
    int d[n];
    for (int i=0; i<n; i++) cin >> d[i];
    cin >> x;
    sort(d, d+n);

    int left = 0, right = n - 1;
    while(left < right) {
        int sum = d[left] + d[right];
        if (sum == x){
            answer += 1;
            left += 1;
            right -= 1;
        } else if (sum > x) {
            right -= 1;
        } else {
            left += 1;
        }
    }
    cout << answer;
}