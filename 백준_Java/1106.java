import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] cities = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cities[i][0] = Integer.parseInt(st.nextToken());
            cities[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[c + 100];

        for (int i = 0; i < c + 100; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = cities[i][1]; j < c + 100; j++) {
                if (dp[j - cities[i][1]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - cities[i][1]] + cities[i][0]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = c; i < c + 100; i ++) {
            answer = Math.min(dp[i], answer);
        }
        System.out.println(answer);
    }
}