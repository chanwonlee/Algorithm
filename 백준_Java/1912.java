import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + a[i];
        }
        
        int answer = -1001;
        for (int i = 1; i <= n; i++) {
            if (answer < dp[i]) answer = dp[i];
        }

        System.out.print(answer);
    }
}