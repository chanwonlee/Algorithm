import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        solution(1, 3, n);
        System.out.println((1 << n) - 1);
        System.out.print(sb);
    }

    static void solution(int a, int b, int n) {
        if (n == 1) {
            sb.append(a + " " + b + "\n");
            return;
        }

        solution(a, 6 - a - b, n - 1);
        sb.append(a + " " + b + "\n");
        solution(6 - a- b, b, n - 1);
    }
}