import java.io.*;
import java.util.*;

class Solution {

    public int solution(int[] numbers, int target) {

        // 결과에 대해서 초기화
        int answer = 0;

        // 재귀 연산 로직
        answer = dfs(numbers, target,0,0);

        // 결과 출력
        return answer;
    }
    
    // DFS 함수 작성
    public int dfs(int[] numbers, int target, int index, int sum){
        
        // 초기화
        int count = 0;
        
        // 종료 로직
        if(index == numbers.length){
            if(sum==target){
                return 1;
            } else{
                return 0;
            }
        }
            
        // + 의 케이스
        count += dfs(numbers,target,index+1, sum+numbers[index]);

        // - 의 케이스
        count += dfs(numbers,target,index+1, sum-numbers[index]);            
        
        
        // 결과
        return count;
        
    }
    
}