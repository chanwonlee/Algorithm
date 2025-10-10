import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.print(solution(n, r, c));
    }

    static int solution(int n, int r, int c) {
        if (n == 0) return 0;

        int half = 1 << (n - 1);

        if (r < half && c < half) {
            return solution(n - 1, r, c);
        } else if (r < half && c >= half) {
            return half * half + solution(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * half * half + solution(n - 1, r - half, c);
        } else {
            return 3 * half * half + solution(n - 1, r - half, c - half);
        }
    }
}