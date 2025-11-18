import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);

        int end = 0;
        int min = Integer.MAX_VALUE;
        
        for (int start = 0; start < n; start++) {
            while (end < n && a[end] - a[start] < m) end++;
            if (end == n) break;
            min = Math.min(min, a[end] - a[start]);
        }
        System.out.print(min);
    }
}