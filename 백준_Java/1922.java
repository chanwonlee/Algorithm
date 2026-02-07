import java.io.*;
import java.util.*;

class Main {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, weight));
        }

        Collections.sort(edges);

        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        int answer = 0;
        int count = 0;

        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                answer += edge.weight;
                count++;
            }
            if (count == n - 1) break;
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

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}