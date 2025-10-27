import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Schedule[] schedules = new Schedule[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            schedules[i] = new Schedule(start, end);
        }

        Arrays.sort(schedules);
        int current = 0;
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            Schedule schedule = schedules[i];
            if (current <= schedule.start) {
                current = schedule.end;
                answer++;
            }
        }
        System.out.print(answer);
    }

    public static class Schedule implements Comparable<Schedule> {
        int start;
        int end;
        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule o) {
            return this.end - o.end;
        }
    }
}