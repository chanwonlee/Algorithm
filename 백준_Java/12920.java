import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Product[] products = new Product[2000];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int temp = 1;
            while (temp <= k) {
                products[idx++] = new Product(temp * v, temp * c);
                k -= temp;
                temp *= 2;
            }

            if (k > 0) {
                products[idx++] = new Product(k * v, k * c);
            }
        }

        int[] dp = new int[m + 1];

        for (int i = 0; i < idx; i++) {
            int w = products[i].weight;
            int v = products[i].value;

            for (int j = m; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        System.out.print(dp[m]);
    }

    static class Product {
        int weight;
        int value;

        public Product(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}