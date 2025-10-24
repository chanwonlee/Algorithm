import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 2];
        int[] p = new int[n + 2];
        int[] dp = new int[n + 2];
        
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i =1 ; i <= n; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            if (i + t[i] - 1 <= n) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
        }

        System.out.print(Arrays.stream(dp).max().getAsInt());
    }
}