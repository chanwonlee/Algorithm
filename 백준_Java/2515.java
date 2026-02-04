import java.io.*;
import java.util.*;

class Main {
    static int[][] paintings; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        paintings = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            paintings[i][0] = h;
            paintings[i][1] = c;
        }

        Arrays.sort(paintings, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n];
        dp[0] = paintings[0][1];
        for (int i = 1; i < n; i++) {
            int cur = binarySearch(i, s);
            if (cur >= 0) {
                dp[i] = Math.max(dp[i - 1], dp[cur] + paintings[i][1]);
            } else {
                dp[i] = Math.max(dp[i - 1], paintings[i][1]);
            }
        }
        System.out.print(dp[n - 1]);
    }

    static int binarySearch(int pos, int s) {
        int left = 0;
        int right = pos;
        while (left <= right) {
            int mid = (left + right) / 2;
            int diff = paintings[pos][0] - paintings[mid][0];
            if (diff >= s) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}