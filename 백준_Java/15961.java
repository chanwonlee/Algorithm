import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] arr = new int[d + 1];
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (arr[sushi[i]] == 0) {
                count++;
            }
            arr[sushi[i]]++;
        }

        int answer = (arr[c] == 0) ? count + 1 : count;

        for (int i = 0; i < n; i++) {
            int tail = sushi[i];
            int head = sushi[(i + k) % n];
            arr[tail]--;
            if (arr[tail] == 0) count--;

            if (arr[head] == 0) count++;
            arr[head]++;

            int cur = (arr[c] == 0) ? count + 1 : count;
            answer = Math.max(answer, cur);
        }

        System.out.print(answer);
    }
}