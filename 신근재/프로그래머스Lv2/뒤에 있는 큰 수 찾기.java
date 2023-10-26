import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        //한 숫자, 한 숫자 모두 뒤에꺼랑 비교할 때는 스택이 괜찮
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack();

        for(int i = 0 ; i < numbers.length; i++){
            //스택 최상단에 들어있는 값(지금까지 제일 큰 값)보다 더 큰 값이 존재하니?
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                //존재 => 정답 기록 + pop
                answer[stack.peek()] = numbers[i];
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.peek()] = -1;
            stack.pop();
        }

        return answer;
    }
}