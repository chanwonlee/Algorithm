import java.io.*;
import java.util.*;

class Main {
    static int n;
    static boolean[] isused1 = new boolean[16];
    static boolean[] isused2 = new boolean[31];
    static boolean[] isused3 = new boolean[31];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        solution(0);
        System.out.print(answer);
    }

    static void solution(int k) {
        if (k == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isused1[i] || isused2[i + k] || isused3[k - i + n - 1]) continue;
            isused1[i] = true;
            isused2[i + k] = true;
            isused3[k - i + n - 1] = true;

            solution(k + 1);

            isused1[i] = false;
            isused2[i + k] = false;
            isused3[k - i + n - 1] = false;
        }
    }
}