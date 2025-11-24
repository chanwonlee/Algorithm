import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tastcase = 0; tastcase < t; tastcase++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tree = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    tree.put(n, tree.getOrDefault(n, 0) + 1);
                } else {
                    if (tree.isEmpty()) continue;

                    int key = (n == -1) ? tree.firstKey() : tree.lastKey();

                    if (tree.get(key) == 1) {
                        tree.remove(key);
                    } else {
                        tree.put(key, tree.get(key) - 1);
                    }
                }
            }
            if (tree.size() == 0) {
                System.out.println("EMPTY");
            } else {
                System.out.println(tree.lastEntry().getKey() + " " + tree.firstEntry().getKey());
            }
        }
    }
}