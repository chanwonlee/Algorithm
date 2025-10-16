import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static int[] result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            arr = new int[n];
            result = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb = new StringBuilder();
            solution(0, 0);
            System.out.println(sb);
        }   
    }

    static void solution(int k, int start) {
        if (k == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            result[k] = arr[i];
            solution(k + 1, i + 1);
        }
    }
}