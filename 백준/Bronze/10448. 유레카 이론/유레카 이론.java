import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 삼각수 배열 생성
        int[] arr = new int[45];
        for (int i = 1; i < 45; i++) {
            arr[i] = arr[i - 1] + i;
        }

        // 테스트 케이스 개수
        int N = sc.nextInt();

        while (N-- > 0) {
            int K = sc.nextInt();
            boolean found = false;

            // 삼각수 세 개의 합으로 표현 가능한지 확인
            for (int i = 1; i < 45 && !found; i++) {
                for (int j = i; j < 45 && !found; j++) {
                    for (int k = j; k < 45 && !found; k++) {
                        if (arr[i] + arr[j] + arr[k] == K) {
                            found = true;
                        }
                    }
                }
            }

            System.out.println(found ? 1 : 0);
        }

        sc.close();
    }
}
