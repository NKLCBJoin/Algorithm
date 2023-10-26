import java.util.Arrays;

public class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        //Str변환
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        //내림차순으로 정렬(10,2) => 102 vs 210
        Arrays.sort(arr, (o1,o2) -> (o2).compareTo(o1) );

        //내림차순인데 가장 큰 첫째가 0이다? -> 종료해라
        if (arr[0].equals("0")) {
            return "0";
        }

        //숫자들을 합쳐서 최종 숫자 만들기
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }

        return answer.toString();
    }
}