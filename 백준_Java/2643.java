import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Paper[] papers = new Paper[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int height = Math.min(a, b);
            int width = Math.max(a, b);
            papers[i] = new Paper(height, width);
        }
        
        Arrays.sort(papers);
        int[] dp = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (papers[i].height >= papers[j].height && papers[i].width >= papers[j].width) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.print(answer);
    }

    static class Paper implements Comparable<Paper>{
        int height;
        int width;
        public Paper(int height, int width) {
            this.height = height;
            this.width = width;
        }

        @Override
        public int compareTo(Paper o) {
            if (this.height == o.height) return this.width - o.width;
            else return this.height - o.height;
        }
    }
}