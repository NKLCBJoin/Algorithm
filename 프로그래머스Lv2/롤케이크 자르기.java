import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;

        HashSet<Integer> first = new HashSet<>();//순서없고 중복된 거 저장 안하는 배열
        HashMap<Integer, Integer> second = new HashMap<>();//키,값

        first.add(topping[0]);
        //1~전체 해시맵에 집어넣고 이미 존재한다면 +1
        for (int i = 1;i < size; i++) {
            second.put(topping[i], second.getOrDefault(topping[i], 0) + 1);
        }

        //1~전체 해시맵 순회
        for (int i = 1;i < size; i++) {
            first.add(topping[i]);//해시Set에 넣기(이미 있다면 안 넣는다)
            second.put(topping[i], second.get(topping[i]) - 1);//이미 넣은 값들에서 -1
            if (second.get(topping[i]) == 0) {//-1해서 0이라면 맵에서 제거하자
                second.remove(topping[i]);
            }
            if (first.size() == second.size())
                answer++;
        }
        return answer;
    }
}
