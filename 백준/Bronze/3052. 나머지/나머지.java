import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // 배열 제작
        Integer[] numbers = new Integer[10]; 

        // 배열에 입력한 값 저장
        for (int j = 0 ; j < 10; j++) {

            int I = sc.nextInt();

            for (int i = 0; i < 1 ; i++) {
               numbers[j] = I % 42;
            } 
        }
        // 배열을 Hashset으로 전환 (중복 불가)
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(numbers));

        // 값 표현
        System.out.println(set.size());

    }
}