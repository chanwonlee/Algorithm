import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Meat[] meats = new Meat[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            meats[i] = new Meat(weight, price);
        }

        Arrays.sort(meats);

        int curWeight = 0;
        long curCost = 0;
        long answer = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            curWeight += meats[i].weight;

            if (i > 0 && meats[i].price == meats[i - 1].price) {
                curCost += meats[i].price;
            } else {
                curCost = meats[i].price;
            }

            if (curWeight >= m) {
                answer = Math.min(answer, curCost);
            }
        }

        if (answer == Long.MAX_VALUE) System.out.print(-1);
        else System.out.print(answer);
    }

    static class Meat implements Comparable<Meat> {
        int weight;
        int price;

        public Meat(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Meat o) {
            if (this.price == o.price) return o.weight - this.weight;
            return this.price - o.price;
        }
    }
}