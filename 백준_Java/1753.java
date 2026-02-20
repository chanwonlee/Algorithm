import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        boolean[] visit = new boolean[v + 1];
        List<Node>[] list = new ArrayList[v + 1];
        int[] answer = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList();
            answer[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[u].add(new Node(to, cost));
        }

        // 다익스트라
        PriorityQueue<Node> pq = new PriorityQueue();
        answer[k] = 0;
        pq.offer(new Node(k, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visit[cur.to]) continue;
            visit[cur.to] = true;

            for (Node next : list[cur.to]) {
                if (!visit[next.to] && answer[cur.to] + next.cost < answer[next.to]) {
                    answer[next.to] = answer[cur.to] + next.cost;
                    pq.offer(new Node(next.to, answer[next.to]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
            System.out.println("INF");
            } else {
                System.out.println(answer[i]);
            }
        }
    }

    static class Node implements Comparable<Node>{
        int to;
        int cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}