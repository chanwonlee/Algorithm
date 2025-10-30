import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(solution(n, a));
        }
    }

    static long solution(int n, int[] a) {
        long answer = 0;
        int max = a[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > max) max = a[i];
            answer += max - a[i];
        }
        return answer;
    }
}