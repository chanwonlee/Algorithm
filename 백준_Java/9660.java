import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n % 7 == 0 || n % 7 == 2) {
            System.out.print("CY");
        } else {
            System.out.print("SK");
        }
    }
}
