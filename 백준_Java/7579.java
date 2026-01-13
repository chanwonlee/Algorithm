import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] memories = new int[n];
        int[] costs = new int[n];
        int[][] dp = new int[n][10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {
                    if (j >= costs[i]) dp[i][j] = memories[i];
                }
                else {
                    if (j >= costs[i]) dp[i][j] = Math.max(dp[i - 1][j - costs[i]] + memories[i], dp[i - 1][j]);
                    else dp[i][j] = dp[i - 1][j];
                }

                if (dp[i][j] >= m) answer = Math.min(answer, j);
            }
        }
        System.out.println(answer);
    }
}