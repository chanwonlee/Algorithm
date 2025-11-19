import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        boolean[] check = new boolean[100002];
        check[a[0]] = true;
        int end = 0;

        for (int start = 0; start < n; start++) {
            while (end < n - 1 && !check[a[end + 1]]) {
                end++;
                check[a[end]] = true;
            }
            answer += (end - start + 1);
            check[a[start]] = false;
        }
        System.out.print(answer);
    }
}