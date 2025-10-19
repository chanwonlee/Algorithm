import java.io.*;
import java.util.*;

class Main {
    static Egg[] eggs = new Egg[10];
    static int n, answer, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durability, weight);
        }
        
        solution(0);
        System.out.print(answer);
    }

    static void solution(int cur) {
        if (cur == n) {
            answer = Math.max(answer, count);
            return;
        }

        if (eggs[cur].durability <= 0 || count == n - 1) {
            solution(cur + 1);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (eggs[i].durability <= 0 || cur == i) continue;
            
            eggs[cur].durability -= eggs[i].weight;
            eggs[i].durability -= eggs[cur].weight;
            if (eggs[cur].durability <= 0) count++;
            if (eggs[i].durability <= 0) count++;
            
            solution(cur + 1);
            
            if (eggs[cur].durability <= 0) count--;
            if (eggs[i].durability <= 0) count--;
            eggs[cur].durability += eggs[i].weight;
            eggs[i].durability += eggs[cur].weight;
        }
    }

    static class Egg {
        int durability;
        int weight;
        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
