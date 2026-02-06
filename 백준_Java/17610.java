import java.io.*;
import java.util.*;

class Main {
    static int k;
    static int[] d;
    static boolean[] n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        d = new int[k];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            d[i] = Integer.parseInt(st.nextToken());
            sum += d[i];
        }
        n = new boolean[sum + 1];
        go(0, 0);

        int answer = 0;
        for (int i = 1; i <= sum; i++) {
            if (!n[i]) answer++;
        }
        System.out.print(answer);
    }

    static void go(int w, int i) {
        if (i == d.length && w > 0) {
            n[w] = true;
        }
        
        if (i < d.length) {
            go(w, i + 1);
            go(w - d[i], i + 1);
            go(w + d[i], i + 1);
        }
    }
}

