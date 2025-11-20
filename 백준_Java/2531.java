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

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> dq = new LinkedList<>();
        int check = 0;
        for (int i = 0; i < k; i++) {
            dq.addLast(a[i]);
            if (a[i] == c) check++;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = new HashSet<>(dq).size();
            if (check == 0) count++;
            answer = Math.max(count, answer);
            
            if (dq.removeFirst() == c) check--;
            
            int newIdx = (i + k) % n;
            dq.addLast(a[newIdx]);
            if (a[newIdx] == c) check++;
        }
        System.out.print(answer);
    }
}