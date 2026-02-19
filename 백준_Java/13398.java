import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][2];
        int answer = arr[1];
        dp[1][0] = arr[1];
        dp[1][1] = arr[1];

        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.print(answer);
    }
}