import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> basis = new LinkedList<>();
        Stack<Integer> assist = new Stack<>();
        for(int i = 1 ; i <= order.length; i++)
            basis.add(i);

        //order순회
        for(int curFind = 0; curFind < order.length; curFind++){
            //종료해야할 거 같다면(기존 컨테보다 작은데 && 보조 컨베 젤 위보다 작아)
            if(!basis.isEmpty() && !assist.isEmpty() && basis.peek() > order[curFind] && assist.peek() > order[curFind])
                break;

            //보조 컨베에서 꺼낼 수 있다(스택 최상단 == 찾는 거)
            if(!assist.isEmpty() && assist.peek() == order[curFind]){
                assist.pop();
                answer++;
                continue;
            }

            //기존 컨베에 있긴한데 계속 꺼내야 하는 상황
            if(!basis.isEmpty() && order[curFind] >= basis.peek()){
                //기존 컨베에서 원하는게 나올 때까지 보조 컨베에 옮기는 작업!
                while(basis.peek() < order[curFind]){
                    //기존 컨베 제거 && 보조 컨베에 넣기
                    assist.add(basis.remove());
                }
                //-1 까지 옮기고
                //해당 위치 제거
                basis.remove();
                answer++;
            }
        }


        return answer;
    }
}