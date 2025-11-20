import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] choice = new int[100001];
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        int answer = 0;
        for (int start = 0; start < n; start++) {
            while (end < n) {
                if (choice[a[end]] == k) break;
                choice[a[end]]++;
                end++;
            }

            answer = Math.max(end - start, answer);
            choice[a[start]]--;
        }
        System.out.print(answer);
    }
}