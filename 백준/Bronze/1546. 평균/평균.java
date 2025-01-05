import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        LinkedList<Integer> numbers =new LinkedList<>();

        // 값 입력하여 배열에 넣기

        for (int i = 0; i < N ; i++) {
            int A = sc.nextInt();
            numbers.add(A);
        }

        // 오름차순으로 정렬 하기
        Collections.sort(numbers);

        // 최대값 뽑아내기
        int max = numbers.getLast();

        // 전체 합 뽑아내기
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += numbers.get(i);
        }

        // ( 전체 합 / 최댓값 ) * (100 / 총 갯수)
        double result = (sum * 100) / (double)(max * N);
        System.out.println(result);
        
    }
}