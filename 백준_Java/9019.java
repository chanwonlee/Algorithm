import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(bfs(a, b));
        }
    }

    static String bfs(int a, int b) {
        if (a == b) return "";

        String[] prev = new String[10000];
        Arrays.fill(prev, null);
        prev[a] = "";

        Queue<Integer> q = new LinkedList();
        q.add(a);

        while(!q.isEmpty()) {
            int cur = q.poll();

            int[] next = new int[4];
            next[0] = (cur * 2) % 10000;
            next[1] = (cur == 0) ? 9999 : cur - 1;
            next[2] = (cur % 1000) * 10 + cur / 1000;
            next[3] = (cur % 10) * 1000 + cur / 10;

            char[] cmd = {'D', 'S', 'L', 'R'};

            for (int i = 0; i < 4; i++) {
                if (prev[next[i]] == null) {
                    prev[next[i]] = prev[cur] + cmd[i];
                    if (next[i] == b) return prev[b];
                    q.add(next[i]);
                }
            }
        }
        return "";
    }
}