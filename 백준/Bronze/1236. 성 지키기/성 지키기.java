import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 세로 값 입력
        int M = sc.nextInt(); // 가로 값 입력

        // 2차원 배열
        String[][] array = new String[N][M];

        // 값 입력하면서 확인하기
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            String[] split = input.split("");
            for (int j = 0; j < M; j++) {
                array[i][j] = split[j];
            }
        }

        // 결과 초기화
        int row = 0;

        // 행 비교
        for (int i = 0; i < N; i++) {
            int index = 0;

            for (int j = 0; j < M; j++) {
                if (array[i][j].equals("X")) {
                    index++;
                }
            }
            // 더 한 후 확인하기
            if (index == 0) {
                row += 1;
            }
        }

        // 열 비교
        // 행과 중복 가능한 지점 삭제
        int column = 0;
        for (int i = 0; i < M; i++) {
            int index = 0;
            for (int j = 0; j < N; j++) {
                if (array[j][i].equals("X")) {
                    index++;
                }
            }
            // 더 한 후 확인하기
            if (index == 0) {
                column += 1;
            }
        }
        int max = (row > column) ? row : column;

        System.out.println(max);
    }
}
