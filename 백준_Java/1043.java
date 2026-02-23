import java.io.*;
import java.util.*;

class Main {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        p = new int[n + 1];
        for (int i = 1; i <= n; i++) p[i] = i;

        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int[] people = new int[count];
        for (int i = 0; i < count; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[][] parties = new int[m][51];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            parties[i] = new int[k];

            for (int j = 0; j < k; j++) {
                parties[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < k; j++) {
                union(parties[i][0], parties[i][j]);
            }
        }

        boolean[] root = new boolean[n + 1];
        for (int person : people) {
            root[find(person)] = true;
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int person : parties[i]) {
                if (root[find(person)]) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        
        System.out.print(answer);
    }
    
    static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            p[y] = x;
        }
    } 
}