import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        int min = Integer.MAX_VALUE;
        int total = a[0];

        for (int start = 0; start < n; start++) {
            while(end < n && total < s) {
                end++;
                if (end != n) total += a[end];
            }
            if (end == n) break;
            min = Math.min(min, end - start + 1);
            total -= a[start];
        }
        if (min == Integer.MAX_VALUE) min = 0;
        System.out.print(min);
    }
}