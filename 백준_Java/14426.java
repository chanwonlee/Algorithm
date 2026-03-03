import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < m; i++) {
            String target = br.readLine();
            int index = search(arr, target);
            if (index < n && arr[index].startsWith(target)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static int search(String[] arr, String target) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid].compareTo(target) >= 0) {
                end = mid;
            }
            else start = mid + 1;
        }
        return start;
    }
}