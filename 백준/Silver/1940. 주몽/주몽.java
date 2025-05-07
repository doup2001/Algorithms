import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 재료 수
        int m = sc.nextInt();  // 갑옷을 만들기 위한 수
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);  // 정렬

        int count = 0;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == m) {
                count++;
                i++;
                j--;
            } else if (sum < m) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println(count);
    }
}
