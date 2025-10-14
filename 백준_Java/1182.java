import java.io.*;
import java.util.*;

class Main {
    static int n, s, answer;
    static int[] arr;
    static boolean[] isused = new boolean[20];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);
        if (s == 0) answer--;
        System.out.print(answer);
    }

    static void solution(int k, int sum) {
        if (k == n) {
            if (sum == s) answer++;
            return;
        }

        solution(k + 1, sum + arr[k]);
        solution(k + 1, sum);
    }
}