import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long x = 1;
        for (int i = 2; i <= n; i++) {
            x *= i;
            while (x % 10 == 0) x /= 10;
            x %= 1000000000000L;
        }
        long answer = x % 100000;
        System.out.printf("%05d\n", answer);
    }
}