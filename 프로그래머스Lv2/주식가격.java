import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> noLoss = new Stack();
        int[] answer = new int[prices.length];

        for(int i = 0 ; i < prices.length; i++){
            //스택 안에 값 존재 + stack최상단 > 지금꺼내는거
            while(!noLoss.isEmpty() && prices[noLoss.peek()] > prices[i]){
                //ans 갱신
                answer[noLoss.peek()] = i - noLoss.peek();
                noLoss.pop();
            }
            noLoss.push(i);
        }

        //아직 남아있는 스택들 계산
        //=> 마지막까지 감소하지 않은 녀석들
        while(!noLoss.isEmpty()){
            answer[noLoss.peek()] = prices.length - noLoss.peek() - 1;
            noLoss.pop();
        }
        return answer;
    }
}