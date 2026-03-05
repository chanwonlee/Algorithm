import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList();
        for (int num : arr) {
            int idx =   Collections.binarySearch(list, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }

            if (idx == list.size()) {
                list.add(num);
            } else {
                list.set(idx, num);
            }
        }

        System.out.print(arr.length - list.size());
    }
}