import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay);
        }
        int cur = 301;
        int answer = 0;

        while (cur < 1201) {
            int next = cur;
            for (int i = 0; i < n; i++) {
                if (flowers[i].startDate <= cur && flowers[i].endDate > next) {
                    next = flowers[i].endDate;
                }
            }
            
            if (next <= cur) {
                answer = 0;
                break;
            }
            
            answer++;
            cur = next;
        }
        System.out.print(answer);
    }

    static class Flower {
        int startDate;
        int endDate;
        public Flower(int startDate, int endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }
}