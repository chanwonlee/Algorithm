import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> m = new ArrayList<>();
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            if (t == 1) {
                answer++;
            } else if (t > 0) {
                p.add(t);
            } else {
                m.add(t);
            }
        }
        
        Collections.sort(p);
        Collections.sort(m);

        for (int i = p.size() - 1; i > 0; i = i - 2) {
            answer += p.get(i) * p.get(i - 1);
        }

        for (int i = 0; i < m.size() - 1; i = i + 2) {
            answer += m.get(i) * m.get(i + 1);
        }

        if (p.size() % 2 == 1) answer += p.get(0);
        if (m.size() % 2 == 1) answer += m.get(m.size() - 1);
        System.out.print(answer);
    }
}