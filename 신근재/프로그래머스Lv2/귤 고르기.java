import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int gul : tangerine)
            map.put(gul, map.getOrDefault(gul,0)+1);

        //맵을 꼭 정렬 시킬 필요없이 리스트 형태로 가장 큰 값들만 뽑아오면 된다!
        //키들을 가지는 리스트를 만들고 그 안에서 get(키)해서 결론적으로 값들끼리 비교를 하게 해서 정렬된 키 값을..
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        for(int i : keySet) {
            k -= map.get(i);//가장 많이 있는 귤부터 담기 시작
            answer++;//한 종류의 귤을 담았음
            if(k <= 0)//이미 다 담았으면 종료!
                return answer;
        }

        return 1;
    }
}