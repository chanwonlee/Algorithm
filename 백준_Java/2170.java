import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            a[i] = new Pair(x, y);
        }

        Arrays.sort(a);
        long min = a[0].x;
        long max = a[0].y;
        long answer = 0;

        for (int i = 1; i < n; i++) {
            if (max < a[i].x) {
                answer += max - min;
                min = a[i].x;
                max = a[i].y;
            } else {
                max = Math.max(max, a[i].y);
            }
        }
        answer += max - min;
        System.out.print(answer);
    }
    
    static class Pair implements Comparable<Pair> {
        long x;
        long y;
        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x != o.x) {
                return Long.compare(this.x, o.x);
            }
            return Long.compare(o.y, this.y);
        }
    }
}