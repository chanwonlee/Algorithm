import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] arr = new int[10];
    static boolean[] isused = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        solution(0);
        System.out.print(sb);
    }

    static void solution(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!isused[i]) {
                arr[k] = i;
                isused[i] = true;
                solution(k + 1);
                isused[i] = false;
            }
        }
    }
}