import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> primes = new ArrayList<>();
        initPrimes(primes, n);
        primes.add(0);
        
        int start = 0;
        int end = 1;
        int sum = primes.get(0);
        int answer = 0;

        while (end < primes.size()) {
            if (sum == n) answer++;
            if (sum <= n) sum += primes.get(end++);
            if (sum > n) sum -= primes.get(start++);
        }

        System.out.print(answer);
    }

    static void initPrimes(List<Integer> primes, int n) {
        boolean[] state = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (state[i]) continue;
            for (int j = i * i; j <= n; j += i) state[j] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (!state[i]) primes.add(i);
        }
    }
}