import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n + 1][10];
        
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] %= 1000000000;
            }
            dp[i][9] = dp[i - 1][8];
        }

        long answer = Arrays.stream(dp[n])
            .reduce(0L, (sum, x) -> (sum + x) % 1000000000);

        System.out.println(answer % 1000000000);
    }
}