import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();

        System.out.print(pow(a, b, c));
    }

    static long pow(long a, long b, long c) {
        if (b == 1) return a % c;

        long val = pow(a, b/2, c);
        val = val * val * c;

        if (b % 2 == 0) return val;
        return val * a % c;
    }  
}